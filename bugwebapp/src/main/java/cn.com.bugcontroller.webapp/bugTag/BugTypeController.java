package cn.com.bugcontroller.webapp.bugTag;

import cn.com.bugmanager.ajax.response.AjaxResponse;
import cn.com.bugmanager.common.ajax.DataTablesPage;
import cn.com.bugmanager.common.ajax.DataTablesResponse;
import cn.com.bugmanager.tag.model.BugType;
import cn.com.bugmanager.tag.service.BugTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.util.List;
/**
 * Created by fcs on 2015/3/23.
 */
@Controller
@RequestMapping("tags/bugtype")
public class BugTypeController {
    @Autowired
    private BugTypeService  bugTypeService;

    @RequestMapping(method = {RequestMethod.GET})
    public String bugType() throws  Exception{
        return "tag/bug_type";
    }

    /**
     * @param bugType
     * @param request
     * @return
     */
    @RequestMapping("/getBugTypeListPage")
    @ResponseBody
    public DataTablesResponse getBugTypeListPage(BugType bugType,HttpServletRequest  request){
        List<BugType>  bugTypeList = bugTypeService.getBugTypeListPage(bugType);
        return new DataTablesResponse(bugType,bugTypeList);
    }

    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    @ResponseBody
    public AjaxResponse  addBugType(@RequestBody @Valid BugType bugtype,BindingResult result,HttpServletRequest request){
       if(result.hasErrors()){
          return new  AjaxResponse(result);
       }
        return AjaxResponse.getInstanceByResult(bugTypeService.addBugType(bugtype));
    }

    @RequestMapping(method = {RequestMethod.PUT})
    @ResponseBody  //put不用加request请求
    public AjaxResponse  updateBugType(@RequestBody @Valid BugType bugType,BindingResult result){
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
    @ResponseBody
    public AjaxResponse  deleteBugType(@PathVariable  int bugTypeId){
        return  AjaxResponse.getInstanceByResult(bugTypeService.deleteBugType(bugTypeId));
    }

}
