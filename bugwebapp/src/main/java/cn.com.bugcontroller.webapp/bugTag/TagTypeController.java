package cn.com.bugcontroller.webapp.bugTag;

import cn.com.bugmanager.ajax.response.AjaxResponse;
import cn.com.bugmanager.common.ajax.DataTablesResponse;
import cn.com.bugmanager.tag.model.TagType;
import cn.com.bugmanager.tag.service.TagTypeService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.PrintWriter;
import java.util.List;
/**
 * Created by fcs on 2015/3/23.
 * 说明在Controller类中的RequestMapping中的方法的值
 * Post 请求一般对应于添加操作，返回ajaxresponse
 * Get  请求一般对应获取数据操作，将数据装入ajaxresponse中返回交给js处理
 * Delete 请求一般对应于删除数据，返回ajaxresponse
 * Put 请求一般对应于修改数据，返回ajaxresponse
 *
 */
@Controller
@RequestMapping("tags/tagtype")
public class TagTypeController {
    @Autowired
    private TagTypeService tagTypeService;
    /**
     * get方式访问的时候默认返回该路径
     * @return
     * @throws Exception
     */
    @RequestMapping(method = {RequestMethod.GET})
    public String tagType() throws  Exception{
        return  "tag/bug_tag";
    }

    /**
     * @param tagType
     * @param request
     * @return
     */
    @RequestMapping(value="/getTagTypeListPage",method={RequestMethod.POST})
    @ResponseBody
    public DataTablesResponse getTagTypeList(TagType tagType,HttpServletRequest  request){
        List<TagType>  tagTypeList = tagTypeService.getTagTypeList(tagType);
        return new DataTablesResponse(tagType,tagTypeList);
    }

    @RequestMapping(value="/add",method = {RequestMethod.POST})
    @ResponseBody
    public AjaxResponse addTagType(@RequestBody @Valid TagType tagType, BindingResult  result,HttpServletRequest request){
        System.out.println(tagType.getTagName()+"-----------------------");
        if(result.hasErrors()){
            return new AjaxResponse(result);
        }
        return   AjaxResponse.getInstanceByResult(tagTypeService.addTagType(tagType));
    }

    /**
     * @param tagId
     * @return
     */
    @RequestMapping(value="/{tagId}",method={RequestMethod.DELETE})
    @ResponseBody
    public AjaxResponse  deleteTagType(@PathVariable int tagId){

        return AjaxResponse.getInstanceByResult(tagTypeService.deleteTagTypeById(tagId));
    }

    /**
     * 修改方法中的参数要有@RequestBody 注解
     * @param tagType
     * @param result
     * @return
     */
    @RequestMapping(method = {RequestMethod.PUT})
    @ResponseBody
    public AjaxResponse  updateTagType(@RequestBody TagType tagType, BindingResult result){
            if(result.hasErrors()){
                return new AjaxResponse(result);
            }
        return   AjaxResponse.getInstanceByResult(tagTypeService.updateTagType(tagType));
    }

    @RequestMapping(value="/{tagId}",method={RequestMethod.GET})
    public String getBugContentByTagId(@PathVariable @Valid int tagId,HttpServletRequest request){
        System.out.println("tagId = "+tagId);
        return null;
    }


}
