package cn.com.bugmanager.security.model;

/**
 * Created by fcs on 2015/3/30.
 * 用户状态常量
 */
public interface UserState {
    public static final int UNREGISTE = 0;    //未注册状态，相当于游客访问
    public static final int HASREGISTED = 1;   //已经注册状态，但是没有登陆
    public static final int LOGIN = 2;         //已经登陆状态，在线状态
    public static final int LOGOUT = 3;        //未登陆状态，下线状态
    public static final int CLOSE = 4;         //账号已被注销

}
