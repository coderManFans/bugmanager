package cn.com.bugwebapp.tag;

import cn.com.bugmanger.ajax.response.AjaxResponse;
import cn.com.bugmanger.common.ajax.DataTablesPage;
import cn.com.bugmanger.tag.model.BugType;
import cn.com.bugmanger.tag.service.BugTypeService;
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
@RequestMapping("tag/bugtype")
public class BugTypeController {
    @Autowired
    private BugTypeService  bugTypeService;

    @RequestMapping(method = {RequestMethod.GET})
    public String bugType() throws  Exception{
        return "tag/bugtype";
    }

    @RequestMapping("/getBugTypeListPage")
    @ResponseBody
    public DataTablesPage  getBugTypeListPage(BugType bugType,HttpServletRequest  request){
        List<BugType>  bugTypeList = bugTypeService.getBugTypeListPage(bugType);
        return new DataTablesPage();
    }

    /**
     * @param bugType
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST})
    @ResponseBody
    public AjaxResponse  addBugType(@RequestBody @Valid BugType bugType,BindingResult result,HttpServletRequest request){
        if(result.hasErrors()){
            return new AjaxResponse(result);
        }
        return AjaxResponse.getInstanceByResult(bugTypeService.addBugType(bugType));
    }

    @RequestMapping(method = {RequestMethod.PUT})
    @ResponseBody
    public AjaxResponse  updateBugType(@RequestBody @Valid BugType bugType,BindingResult result,HttpServletRequest request){
        if(result.hasErrors()){
            return  new AjaxResponse(result);
        }
        return  AjaxResponse.getInstanceByResult(bugTypeService.updateBugType(bugType));
    }
    /**
     * @param bugTypeId
     * @return
     */
    @RequestMapping(value = "/{bugTypeId}",method = {RequestMethod.DELETE})
    public AjaxResponse  deleteBugType(@PathVariable  int bugTypeId){
        return  AjaxResponse.getInstanceByResult(bugTypeService.deleteBugType(bugTypeId));
    }




}
