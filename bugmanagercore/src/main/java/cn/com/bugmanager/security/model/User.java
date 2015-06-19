package cn.com.bugmanager.security.model;

import cn.com.bugmanager.common.ajax.DataTablesPage;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
public class User extends DataTablesPage{
    private String organizationId;
    @NotBlank(message = "用户名不能为空")
    private String userName;
    private String nickname;
    private String userPass;
    private String userState;
    private int    userId;
    private String email;
    private boolean remenberMe;
    private List<Role> roleList;

    public User(){

    }
    public User(int userId){
        this.userId = userId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRemenberMe() {
        return remenberMe;
    }

    public void setRemenberMe(boolean remenberMe) {
        this.remenberMe = remenberMe;
    }
}
