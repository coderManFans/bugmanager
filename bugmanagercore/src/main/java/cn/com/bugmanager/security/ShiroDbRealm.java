package cn.com.bugmanager.security;


import cn.com.bugmanager.security.model.Role;
import cn.com.bugmanager.security.model.User;
import cn.com.bugmanager.security.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShiroDbRealm extends AuthorizingRealm {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String username = (String) getAvailablePrincipal(principals); // 使用Shiro提供的方法获取用户名称
        if (username != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            List<Role> roles = userService.getRolesByUsername(username);
            if (roles != null) {
                // 加入用户角色
                for (Role role : roles) {
                    info.addRole(role.getRoleName());
                }
            }
            List<String> permTokens = userService.getPermTokensByUsername(username);
            if (permTokens != null) {
                // 加入用户许可标记
                info.addStringPermissions(permTokens);
            }
            return info;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String userName = token.getUsername();
        if (userName != null && !"".equals(userName)) {
            User user = userService.getUserByUsername(userName);
            if (user != null) {
                return new SimpleAuthenticationInfo(user.getUserName(), user.getUserPass(), getName());
            }
        }
        return null;
    }

}
