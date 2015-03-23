package cn.com.bugmanger.security.service;

import cn.com.bugmanger.constant.Constant;
import cn.com.bugmanger.security.dao.UserDao;
import cn.com.bugmanger.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
@Service("userService")
public class UserService {
    @Autowired
    private UserDao  userDao;

    public  User getUserById(final  int userId){
        return userDao.getUserById(userId);
    }


    /**
     * @param user
     * @return
     */
    public  boolean updateUser(User user){
        int affectNum = userDao.updateUser(user);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }

    /**
     * @return
     */
    public  List<User> getListUser(){
        List<User>  userList = userDao.getUserList();
        return   userList == null ? null : userList ;
    }

    public List<User> getListUserPage(User user){
        List<User> userListPage = userDao.getUserListPage(user);
        return userListPage;
    }

    /**
     * @param userId
     * @return
     */
    public boolean deleteUserByUserId(final int userId){
        int affectNum = userDao.deleteUserById(userId);
        return  Constant.AFFECTED_LINE_1 == affectNum;
    }

    /**
     * @param user
     * @return
     */
    public  boolean addUser(User user){
        int affectNum = userDao.addUser(user);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }


}
