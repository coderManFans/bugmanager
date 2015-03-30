package cn.com.bugcontroller.webapp.bugTag;

import cn.com.bugmanager.ajax.response.AjaxResponse;
import cn.com.bugmanager.common.ajax.DataTablesPage;
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
@RequestMapping("tag/bugtype")
public class BugTypeController {
    @Autowired
    private BugTypeService  bugTypeService;

    @RequestMapping(method = {RequestMethod.GET})
    public String bugType() throws  Exception{
        return "bugtag/bugtype";
    }

    @RequestMapping("/getBugTypeListPage")
    @ResponseBody
    public DataTablesPage  getBugTypeListPage(BugType bugType,HttpServletRequest  request){
        List<BugType>  bugTypeList = bugTypeService.getBugTypeListPage(bugType);
        return new DataTablesPage();
    }

    @RequestMapping(value = {"/add"},method = {RequestMethod.POST})
    public String  addBugType(HttpServletRequest request,HttpServletResponse response){
        String  bugType  = request.getParameter("bugType");
        String bugTypeIntroduce = request.getParameter("bugTypeIntroduce");
        BugType  bugType1 = new BugType();
        bugType1.setBugType(bugType);
        bugType1.setBugTypeIntroduce(bugTypeIntroduce);
        bugTypeService.addBugType(bugType1);
        return "/index";
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
