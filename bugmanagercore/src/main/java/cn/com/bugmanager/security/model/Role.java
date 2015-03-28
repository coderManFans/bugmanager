package cn.com.bugmanager.security.model;
import cn.com.bugmanager.common.ajax.DataTablesPage;

import java.util.List;
/**
 * Created by fcs on 2015/3/21.
 */
public class Role extends DataTablesPage{
    private int roleId;
    private String roleName;   //目前只有超级管理员和系统用户
    private String description;
    private List<User>  userList;
    public Role(){

    }
    public Role(int roleId ){
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
