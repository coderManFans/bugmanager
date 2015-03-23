package cn.com.bugwebapp.bugContent;

import cn.com.bugmanger.bugcontent.service.BugContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fcs on 2015/3/23.
 */
@Controller
@RequestMapping("/bugcontent")
public class BugContentController {
    @Autowired
    private BugContentService  bugContentService;
}
