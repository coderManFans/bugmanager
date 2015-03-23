package cn.com.bugwebapp.security;

import cn.com.bugmanger.security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fcs on 2015/3/23.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

}
