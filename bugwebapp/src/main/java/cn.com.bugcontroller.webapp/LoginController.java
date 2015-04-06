package cn.com.bugcontroller.webapp;

import cn.com.bugmanager.security.model.User;
import cn.com.bugmanager.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by fcs on 2015/3/23.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

   @RequestMapping(method={RequestMethod.GET})
    public String login(){
        return "login";
    }

    @RequestMapping(value={"/tologin"},method = {RequestMethod.POST})
    public String login(Model model,HttpServletRequest request,HttpServletResponse  response){
        String username = request.getParameter("userName");
        String userpass = request.getParameter("password");
        User user1 = new User();
        user1.setUserName(username);
        user1.setUserPass(userpass);
        HttpSession session = request.getSession();
        User user  = userService.loginAuth(user1);
        if(user == null){
            return  "login";
        }else{
            session.setAttribute("user",user);
            return "index";
        }
    }
}
