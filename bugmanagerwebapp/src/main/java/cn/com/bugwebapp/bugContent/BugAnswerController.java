package cn.com.bugwebapp.bugContent;

import cn.com.bugmanger.ajax.response.AjaxResponse;
import cn.com.bugmanger.bugcontent.model.BugAnswer;
import cn.com.bugmanger.bugcontent.service.BugAnswerService;
import cn.com.bugmanger.common.ajax.DataTablesPage;
import cn.com.bugmanger.common.ajax.DataTablesResponse;
import cn.com.bugmanger.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping("/bug/buganswer")
public class BugAnswerController {
    @Autowired
    protected BugAnswerService  bugAnswerService;

    @RequestMapping(method = {RequestMethod.GET})
    public String bugAnswer(){
        return  "/bug/buganswer";
    }


    /**
     * @param bugId
     * @param bugAnswer
     * @return
     */
    @RequestMapping(value = "/{bugId}",method = {RequestMethod.POST})
    @ResponseBody
    public DataTablesResponse  getBugAnswerListPage(@PathVariable @Valid int bugId,@RequestBody BugAnswer  bugAnswer){
        List<BugAnswer>  bugAnswerList = bugAnswerService.getBugAnswerList(bugId);
        return  new DataTablesResponse(bugAnswer,bugAnswerList);
    }

    /**
     * @param bugAnswer
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST})
    @ResponseBody
    public AjaxResponse addBugAnswer(@RequestBody  @Valid BugAnswer bugAnswer,BindingResult  result,HttpServletRequest request){
        if(result.hasErrors()){
            return new AjaxResponse(result);
        }
        return  AjaxResponse.getInstanceByResult(bugAnswerService.addBugAnswer(bugAnswer));
    }


    @RequestMapping(method = {RequestMethod.PUT})
    @ResponseBody
    public AjaxResponse updateBugAnswer(@RequestBody  @Valid BugAnswer  bugAnswer,BindingResult result ,HttpServletRequest request){
        if(result.hasErrors()){
            return  new AjaxResponse(result);
        }
        return  AjaxResponse.getInstanceByResult(bugAnswerService.updateBugAnswer(bugAnswer) == Constant.AFFECTED_LINE_1);
    }

    @RequestMapping(value = "/{bugAnswerId}",method = {RequestMethod.DELETE})
    @ResponseBody
    public AjaxResponse  deleteBugAnswer(@PathVariable @Valid int bugAnswerId){
        return AjaxResponse.getInstanceByResult(bugAnswerService.deleteBugAnswer(bugAnswerId));
    }
}
