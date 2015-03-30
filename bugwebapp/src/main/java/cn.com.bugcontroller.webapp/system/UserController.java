package cn.com.bugcontroller.webapp.system;

import cn.com.bugmanager.ajax.response.AjaxResponse;
import cn.com.bugmanager.security.model.User;
import cn.com.bugmanager.security.model.UserState;
import cn.com.bugmanager.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserService userService;

    @RequestMapping(value={"/toregiste"},method={RequestMethod.GET})
    public String userRegister(){
        return "/system/user";
    }

    @RequestMapping(value = "/registe",method = {RequestMethod.POST})
    public String   register(HttpServletRequest  request,HttpServletResponse response){
        System.out.println("--------------registe---------");
        String userName = request.getParameter("userName");
        String password = request.getParameter("userPass");
        String email = request.getParameter("email");
        System.out.println(userName + "---------"+password+"-------"+email);
        User user = new User();
        user.setEmail(email);
        user.setUserPass(password);
        user.setUserName(userName);
        user.setUserState(UserState.HASREGISTED+"");
        userService.addUser(user);
        return "index";
    }

    @RequestMapping(value = "/{userName}")
    @ResponseBody
    public AjaxResponse  getUserByName(@PathVariable @RequestBody String userName){
        return null;
    }

}
