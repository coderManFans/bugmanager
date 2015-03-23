package cn.com.bugwebapp;

import cn.com.bugmanger.security.model.User;
import cn.com.bugmanger.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by fcs on 2015/3/23.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = {RequestMethod.POST})
    public String loginPost(User user,RedirectAttributes redirectAttributes,HttpServletRequest request,HttpServletResponse  response){
        return null;
    }

}
