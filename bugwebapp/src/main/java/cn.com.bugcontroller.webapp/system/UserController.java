package cn.com.bugcontroller.webapp.system;

import cn.com.bugmanager.ajax.response.AjaxResponse;
import cn.com.bugmanager.security.model.User;
import cn.com.bugmanager.security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fcs on 2015/3/23.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @RequestMapping(method={RequestMethod.GET})
    public String userRegister(){
        return "/system/user";
    }

    @RequestMapping(value = "/registe",method = {RequestMethod.POST})
    public String   register(HttpServletRequest  request,HttpServletResponse response){
        System.out.println("--------------registe---------");
        String usern = request.getParameter("userName");
        String p = request.getParameter("userPass");
        String email = request.getParameter("email");
        System.out.println(usern+"---------------"+p+"------"+email);
        return "index";
    }

    @RequestMapping(value = "/{userName}")
    @ResponseBody
    public AjaxResponse  getUserByName(@PathVariable @RequestBody String userName){
        return null;
    }

}
