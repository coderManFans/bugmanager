package cn.com.bugwebapp;

/**
 * Created by fcs on 2015/3/23.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/")
    public String index(HttpServletRequest request ){
        return "/index";
    }
}
