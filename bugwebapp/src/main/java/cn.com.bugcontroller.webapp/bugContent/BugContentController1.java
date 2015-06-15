package cn.com.bugcontroller.webapp.bugContent;

import cn.com.bugmanager.bugcontent.model.BugContent;
import cn.com.bugmanager.bugcontent.service.BugAnswerService;
import cn.com.bugmanager.bugcontent.service.BugContentService;
import cn.com.bugmanager.tag.service.BugTypeService;
import cn.com.bugmanager.tag.service.TagTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

}
