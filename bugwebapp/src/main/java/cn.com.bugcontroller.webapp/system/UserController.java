package cn.com.bugcontroller.webapp.system;

import cn.com.bugmanager.security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fcs on 2015/3/23.
 */
@Controller
@RequestMapping("security/user")
public class UserController {
    private UserService userService;

}
