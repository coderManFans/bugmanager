package cn.com.bugmanager.security.model;

import cn.com.bugmanager.common.ajax.DataTablesPage;

/**
 * Created by fcs on 2015/3/19.
 */
public class User extends DataTablesPage{
    private String userName;
    private String userPass;
    private String userState;
    private int    userId;
    private String email;
    private boolean remenberMe;

    public User(){

    }
    public User(int userId){
        this.userId = userId;
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
