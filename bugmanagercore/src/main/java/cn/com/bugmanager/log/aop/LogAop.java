package cn.com.bugmanager.log.aop;

import cn.com.bugmanager.log.model.Log;
import cn.com.bugmanager.log.service.LogService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    private Logger logger = LoggerFactory.getLogger(LogAop.class);
    @Autowired
    private LogService logService;

    @Pointcut("execution(* cn.com.bugmanager..*.*(..))")
    public void aspect() {
    }

    @AfterReturning(value = "aspect()", returning = "returnValue")
    public void afterReturning(JoinPoint jp, Object returnValue) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if(request.getRequestURI().contains(".jsp")){
            System.out.println("-------------------------------------------------------aop");
            return;
        }
        Subject user = SecurityUtils.getSubject();
        if (user != null && user.getPrincipal() != null) {
            StringBuilder params = new StringBuilder();
            int index = 0;
            for (String param : request.getParameterMap().keySet()) {
                params.append(index++ == 0 ? "" : "&").append(param).append("=").append(request.getParameter(param));
            }

            Log log = new Log();
            log.setUsername(user.getPrincipal().toString());
            log.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            log.setIp(getIp(request));
            log.setUserAgent(request.getHeader("user-agent"));
            log.setRequestUri(request.getRequestURI());
            log.setRequestMethod(request.getMethod());
            log.setRequestParams(params.toString());
            System.out.println(request.getRequestURI()+"-------------------------------------------");

           // logService.saveLog(log);

            logger.info("save log {loginName: {}, uri: {}}, ", user.getPrincipal(), log.getRequestUri());
        }
    }

    /**
     * 获取请求的ip地址
     *
     * @param request
     * @return 解析后的ip地址
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
