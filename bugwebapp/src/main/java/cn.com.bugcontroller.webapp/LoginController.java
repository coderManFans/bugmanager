package cn.com.bugcontroller.webapp;

import cn.com.bugmanager.develop.service.MenuService;
import cn.com.bugmanager.security.model.User;
import cn.com.bugmanager.security.service.UserService;
import cn.com.bugmanager.utils.HttpSessionUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
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

    @Autowired
    private MenuService menuService;

    /**
     * 返回后台登陆界面
     * @return
     */
   @RequestMapping(method={RequestMethod.GET})
    public String login(){
       return "login";
    }

    /**
     * 登陆验证
     * @param request
     * @return
     */
    @RequestMapping(value={"/tologin"},method = {RequestMethod.POST})
    public String login(RedirectAttributes redirectAttributes,HttpServletRequest request,HttpServletResponse response){
        Subject currentUser = SecurityUtils.getSubject();
        String username = request.getParameter("userName");
        String userpass = request.getParameter("password");


        User user1 = new User();
        user1.setUserName(username);
        user1.setUserPass(userpass);
        UsernamePasswordToken token = new UsernamePasswordToken(user1.getUserName(),user1.getUserPass());

        try {
            currentUser.login(token);
        }catch (org.apache.shiro.authc.AuthenticationException e){
            redirectAttributes.addFlashAttribute("message","用户名或密码错误！");
            return "redirect:/login";
        }
        if(currentUser.isAuthenticated()){
            sessionHandle(user1,request);
            return "admin_index";
        }else {
            System.out.println("3---------------------------------------------");

            redirectAttributes.addFlashAttribute("message", "用户名或密码错误！");
            return "redirect:/login";
        }


       /* HttpSession session = request.getSession();
        User user  = userService.loginAuth(user1);
        if(user == null){
            return  "login";
        }else{
            session.setAttribute("user",user);
            return "admin_index";
        }*/
    }

    private String getSavedUrl(HttpServletRequest request) {
        String savedUrl = WebUtils.getAndClearSavedRequest(request)
                .getRequestUrl()
                .replace(request.getContextPath(), "");
        if (!savedUrl.contains("menuId")) {
            savedUrl = "/";
        }
        return savedUrl;
    }

    private void sessionHandle(User user, HttpServletRequest request) {
        User loginUser = userService.getUserByUsername(user.getUserName());
        System.out.println(loginUser.getUserName()+"--------------------------------------------");
        HttpSessionUtil.saveUserToSession(loginUser, request);
        //menuService.updateMenuInHttpSession(request);
    }
}
