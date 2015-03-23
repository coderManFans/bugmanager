package cn.com.bugwebapp.tag;

import cn.com.bugmanger.tag.service.TagTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fcs on 2015/3/23.
 */
@Controller
@RequestMapping("/tagtype")
public class TagTypeController {
    @Autowired
    private TagTypeService tagTypeService;

}
