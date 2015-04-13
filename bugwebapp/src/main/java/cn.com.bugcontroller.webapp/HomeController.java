package cn.com.bugcontroller.webapp;

/**
 * Created by fcs on 2015/3/23.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/home")
public class HomeController {
    /**
     * 主页默认设置为前台
     * @param request
     * @return
     */
    @RequestMapping("/")
    public String index(HttpServletRequest request ){
        return "/index";
    }
}
