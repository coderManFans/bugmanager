package cn.com.bugcontroller.webapp.system;

import cn.com.bugmanager.security.model.User;
import cn.com.bugmanager.security.model.UserState;
import cn.com.bugmanager.security.service.UserService;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        return "system/usersetting";
    }

    @RequestMapping(value = "/registe",method = {RequestMethod.POST})
    public String   register(HttpServletRequest  request,HttpServletResponse response){
        System.out.println("--------------registe---------");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
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

    @RequestMapping(value = "/{userId}",method = {RequestMethod.GET})
    public String  getUserById(@PathVariable @RequestBody String userId){
        User user = userService.getUserById(Integer.parseInt(userId));

        return "/system/usersetting";
    }


    @RequestMapping(value="/uploadPhoto",method={RequestMethod.POST})
    public String uploadUserPhoto(Model model,HttpServletRequest request,MultipartFile photo)throws IOException{

        if(photo.isEmpty()){
            System.out.println("文件未上传");
        }
        System.out.println("文件名："+photo.getName());
        System.out.println("文件源名称："+photo.getOriginalFilename());
        System.out.println("文件类型:"+photo.getContentType());
        String realPath = request.getSession().getServletContext().getRealPath("/static/uploadImage");
        System.out.println(realPath+"-------");
        //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO关闭
        FileUtils.copyInputStreamToFile(photo.getInputStream(), new File(realPath,photo.getOriginalFilename()));
        model.addAttribute("userPhoto",photo.getOriginalFilename());

        return  "system/usersetting";
    }


}
