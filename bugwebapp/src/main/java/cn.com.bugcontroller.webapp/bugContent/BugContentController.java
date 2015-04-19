package cn.com.bugcontroller.webapp.bugContent;

import cn.com.bugmanager.ajax.response.AjaxResponse;
import cn.com.bugmanager.bugcontent.model.BugContent;
import cn.com.bugmanager.bugcontent.service.BugContentService;
import cn.com.bugmanager.common.ajax.DataTablesResponse;
import cn.com.bugmanager.security.model.User;
import cn.com.bugmanager.tag.model.BugType;
import cn.com.bugmanager.tag.model.TagType;
import cn.com.bugmanager.tag.service.BugTypeService;
import cn.com.bugmanager.tag.service.TagTypeService;
import cn.com.bugmanager.util.CalendarUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fcs on 2015/3/23.
 */
@Controller
@RequestMapping("/buginfo/bugcontent")
public class BugContentController {
    @Autowired
    private BugContentService  bugContentService;

    @Autowired
    private BugTypeService  bugTypeService;

    @Autowired
    private TagTypeService tagTypeService;

    /**
     * @return
     */
    @RequestMapping(value={"/toadd"},method = {RequestMethod.GET})
    public String bugContent(ModelMap modelMap){
     /*   List<BugType>  bugTypeList = bugTypeService.getBugTypeList();
        modelMap.addAttribute("bugTypeList",bugTypeList);
        List<TagType>  tagTypeList = tagTypeService.getTagTypeList();
        modelMap.addAttribute("tagTypeList",tagTypeList);*/
        return "bugcontent/bugcontent";
    }


    /**
     * @param bugContent
     * @return
     */
    @RequestMapping("/bugContentListPage")
    public DataTablesResponse  getBugContentListPage(@RequestBody BugContent bugContent){
        List<BugContent>  bugContentList = bugContentService.getBugContentListPage();
        return new DataTablesResponse(bugContent,bugContentList);
    }


    @RequestMapping(value="/add",method = {RequestMethod.POST})
    public String addBugContentNoAnwser(HttpServletRequest  request,HttpServletResponse response) {
        String[] bugIdList = request.getParameterValues("bugIdList");
        String[] tagIdList = request.getParameterValues("tagIdList");

        String consoleError = request.getParameter("consoleError");
        String bugCode = request.getParameter("bugCode");
        String bugReason = request.getParameter("bugReason");
        String bugAnswer = request.getParameter("bugAnswer");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        String upTime =  CalendarUtils.getDateTime();   //使用该方法设置时间
        System.out.println("userId = "+userId+" ----"+bugAnswer);

        BugContent bugContent = new BugContent();
        bugContent.setConsoleError(consoleError);
        bugContent.setBugCode(bugCode);
        bugContent.setBugReason(bugReason);
        bugContent.setUpDate(upTime);
        String bugContentId = CalendarUtils.getDateUUID();
        System.out.println("bugcontentId = "+bugContentId);

        if(bugAnswer != null || "".equals(bugAnswer)){
            bugContent.setHasSolved(true);
        }else{
            bugContent.setHasSolved(false);
        }

        bugContent.setUserId(userId);
        bugContent.setBugcontentid(bugContentId);
        bugContentService.addBugContentWithNoAnswer(bugContent);

        bugContentService.addBug_Tag(bugContentId,tagIdList);
        bugContentService.addBug_Type(bugContentId,bugIdList);

        return "index";
    }

  /* @RequestMapping(value="/add",method = {RequestMethod.POST})
   @ResponseBody
   public AjaxResponse addBugContentNoAnwser(@RequestBody BugContent  bugContent,HttpServletRequest  request) {

       HttpSession session = request.getSession();
       User user = (User) session.getAttribute("user");
       int userId = user.getUserId();
       System.out.println("bug---"+bugContent.toString());
       String upTime = CalendarUtils.getDateTime();   //使用该方法设置时间
       System.out.println("userId = " + userId);
       return AjaxResponse.getInstanceByResult(false);
   }*/


       /**
        * @param bugContentId
        * @return
        */
    @RequestMapping(value = "{/bugcontentid}",method = {RequestMethod.DELETE})
    @ResponseBody
    public AjaxResponse  deleteBugContent(@PathVariable String bugContentId){
        return AjaxResponse.getInstanceByResult(bugContentService.deleteBugContentById(bugContentId));
    }

    /**
     * @param bugContent
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(method = {RequestMethod.PUT})
    @ResponseBody
    public AjaxResponse  updateBugContent(@RequestBody BugContent  bugContent,BindingResult result ,HttpServletRequest request){
        if(result.hasErrors()){
            return   new AjaxResponse(result);
        }
        return  AjaxResponse.getInstanceByResult(bugContentService.updateBugContent(bugContent));
    }
}
