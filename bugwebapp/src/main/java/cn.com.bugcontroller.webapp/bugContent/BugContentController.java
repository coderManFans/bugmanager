package cn.com.bugcontroller.webapp.bugContent;

import cn.com.bugmanager.ajax.response.AjaxResponse;
import cn.com.bugmanager.bugcontent.model.BugContent;
import cn.com.bugmanager.bugcontent.service.BugContentService;
import cn.com.bugmanager.common.ajax.DataTablesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.List;

/**
 * Created by fcs on 2015/3/23.
 */
@Controller
@RequestMapping("/buginfo/bugcontent")
public class BugContentController {
    @Autowired

    private BugContentService  bugContentService;

    /**
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET})
    public String bugContent(){
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

    /**
     * @param bugContent
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value="/add",method = {RequestMethod.POST})
    @ResponseBody
    public AjaxResponse addBugContentNoAnwser(@RequestBody @Valid BugContent  bugContent, BindingResult result,HttpServletRequest  request){
        if(result.hasErrors()){
            return new AjaxResponse(result);
        }
        return AjaxResponse.getInstanceByResult(bugContentService.addBugContentWithNoAnswer(bugContent));
    }

    /**
     * @param bugContentId
     * @return
     */
    @RequestMapping(value = "{/bugContentId}",method = {RequestMethod.DELETE})
    @ResponseBody
    public AjaxResponse  deleteBugContent(@PathVariable int bugContentId){
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
