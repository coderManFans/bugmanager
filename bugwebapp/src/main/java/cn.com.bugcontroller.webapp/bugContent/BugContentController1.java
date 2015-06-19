package cn.com.bugcontroller.webapp.bugContent;

import cn.com.bugmanager.ajax.response.AjaxResponse;
import cn.com.bugmanager.bugcontent.model.BugContent;
import cn.com.bugmanager.bugcontent.service.BugAnswerService;
import cn.com.bugmanager.bugcontent.service.BugContentService;
import cn.com.bugmanager.tag.model.BugType;
import cn.com.bugmanager.tag.model.TagType;
import cn.com.bugmanager.tag.service.BugTypeService;
import cn.com.bugmanager.tag.service.TagTypeService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fcs on 2015/5/1.
 */
@Controller
@RequestMapping("bugcontroller/bugcontr")
public class BugContentController1 {
    @Autowired
    private BugContentService bugContentService;

    @Autowired
    private BugTypeService bugTypeService;

    @Autowired
    private TagTypeService tagTypeService;

    @Autowired
    protected BugAnswerService bugAnswerService;

    @RequestMapping(method={RequestMethod.GET})
    public String bugContent(){
        return "bugcontent/show_bugcontent12";
    }

    @RequestMapping(value="/getBugcontentListPage",method={RequestMethod.GET})
    @ResponseBody
    public ModelAndView getBugcontentListPage(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
        List<BugContent> bugContentList = bugContentService.getBugContentListPage(new BugContent());
        modelMap.addAttribute("bugContentList", bugContentList);
        return new ModelAndView("/bugcontent/show_bugcontent12");
    }

    /**
     * @param bugcontentid
     * @return
     */
    @RequestMapping(value = "/{bugcontentid}",method = {RequestMethod.POST})
    @ResponseBody
    public String updateBugContent(@PathVariable @Valid String bugcontentid,HttpServletRequest  request){
        BugContent bugContent = bugContentService.getBugContentById(bugcontentid);
        List<String> contentString = new ArrayList<String>();
        contentString.add(bugContent.getBugCode());
        contentString.add(bugContent.isHasSolved()+"");
        contentString.add(bugContent.getBugcontentid());
        contentString.add(bugContent.getBugReason());
        return JSON.toJSONString(contentString);

    }

    /**
     * @param bugcontentid
     * @return
     */
    @RequestMapping(value = "/gettags/{bugcontentid}",method = {RequestMethod.POST})
    @ResponseBody
    public String getBugContentTags(@PathVariable @Valid String bugcontentid,HttpServletRequest  request){

        List<BugType> bugTypeList = bugTypeService.getBugTypeListByBugcontentId(bugcontentid);
        List<TagType> tagTypeList = tagTypeService.getTagTypeListByBugcontentId(bugcontentid);
        String bugtype = "true";
        String tagtype = "true";
        if(bugTypeList== null || bugTypeList.size() == 0){
            bugtype = "false";
        }if(tagTypeList ==null || tagTypeList.size() == 0){
            tagtype = "false";
        }
        Map<String,Object> tagMap = new HashMap<String, Object>();
        tagMap.put("bugTypeList",bugTypeList);
        tagMap.put("tagTypeList",tagTypeList);
        tagMap.put("bugtype",bugtype);
        tagMap.put("tagtype",tagtype);
        return JSON.toJSONString(tagMap);
    }


    /**
     * @param bugcontentid
     * @return
     */
    @RequestMapping(value = "/{bugcontentid}",method = {RequestMethod.DELETE})
    @ResponseBody
    public AjaxResponse deleteBugContent(@PathVariable @Valid int bugcontentid,HttpServletRequest  request){
        System.out.println("--------------------sdfsf-------------------"+bugcontentid);
        return AjaxResponse.getInstanceByResult(bugContentService.deleteBugContentById(String.valueOf(bugcontentid)));
    }

}
