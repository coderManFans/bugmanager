package cn.com.bugmanger.security.model;

import java.io.Serializable;

/**
 * Created by fcs on 2015/3/19.
 */
public class User implements Serializable{
    private String userName;
    private String userPass;
    private String userState;
    private int    userId;
    private String email;

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
}
