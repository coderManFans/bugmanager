package cn.com.bugcontroller.webapp.bugContent;

import cn.com.bugmanager.ajax.response.AjaxResponse;
import cn.com.bugmanager.bugcontent.model.BugAnswer;
import cn.com.bugmanager.bugcontent.model.BugContent;
import cn.com.bugmanager.bugcontent.service.BugAnswerService;
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
import java.util.List;

/**
 * Created by fcs on 2015/3/23.
 */
@Controller
@RequestMapping("buginfo/bugcontent")
public class BugContentController {
    @Autowired
    private BugContentService  bugContentService;

    @Autowired
    private BugTypeService  bugTypeService;

    @Autowired
    private TagTypeService tagTypeService;

    @Autowired
    protected BugAnswerService bugAnswerService;

    @RequestMapping(value="/toadd",method = {RequestMethod.GET})
    public String bugContent(ModelMap modelMap){
        List<BugType>  bugTypeList = bugTypeService.getBugTypeList();
        modelMap.addAttribute("bugTypeList",bugTypeList);
        List<TagType>  tagTypeList = tagTypeService.getTagTypeList();
        modelMap.addAttribute("tagTypeList",tagTypeList);
        return "bugcontent/bug_content";
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
        bugContent.setAddDate(upTime);

        String bugContentId = CalendarUtils.getDateUUID();
        bugContent.setUserId(userId);
        bugContent.setBugcontentid(bugContentId);

        if(bugAnswer != null || "".equals(bugAnswer)){
            bugContent.setHasSolved(true);
            bugContentService.addBugContentWithAnswer(bugContent);
            BugAnswer bugAnswerModel = new BugAnswer();
            bugAnswerModel.setAnswerInfo(bugAnswer);
            bugAnswerModel.setAnswerTime(CalendarUtils.getDateTime());
            bugAnswerModel.setAnswerUserId(userId);
            bugAnswerModel.setBugContentId(bugContentId);
            bugAnswerModel.setRight(true);

            bugAnswerService.addBugAnswer(bugAnswerModel);

        }else{
            bugContent.setHasSolved(false);
            bugContentService.addBugContentWithNoAnswer(bugContent);
        }
        bugContentService.addBug_Tag(bugContentId,tagIdList);
        bugContentService.addBug_Type(bugContentId,bugIdList);

        return "admin_index";
    }

       /**
        * @param bugcontentid
        * @return
        */
    @RequestMapping(value = "/{bugcontentid}",method = {RequestMethod.DELETE})
    @ResponseBody
    public AjaxResponse  deleteBugContent(@PathVariable @Valid int bugcontentid,HttpServletRequest  request){
        System.out.println("--------------------sdfsf-------------------"+bugcontentid);
        return AjaxResponse.getInstanceByResult(bugContentService.deleteBugContentById(String.valueOf(bugcontentid)));
    }

    /**
     * @param bugContent
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value="/update",method = {RequestMethod.PUT})
    @ResponseBody
    public AjaxResponse  updateBugContent(@RequestBody @Valid BugContent  bugContent,BindingResult result ,HttpServletRequest request){
        System.out.println(bugContent.getUserId()+"");
        System.out.println("----------------------sdfasdfasdfasdfasdfasdfasdfa-------");

        if(result.hasErrors()){
            return   new AjaxResponse(result);
        }
        return  AjaxResponse.getInstanceByResult(bugContentService.updateBugContent(bugContent));
    }

    @RequestMapping(value="/getBugcontentListPage",method={RequestMethod.POST})
    @ResponseBody
    public DataTablesResponse getBugcontentListPage(BugContent bugContent,HttpServletRequest request){
        System.out.println((bugContent == null) +"----------------------------"+bugContent.getPageSize());
        List<BugContent> bugContentList = bugContentService.getBugContentListPage(bugContent);
        System.out.println("-----------------------------");
        return  new DataTablesResponse(bugContent,bugContentList);
    }

}
