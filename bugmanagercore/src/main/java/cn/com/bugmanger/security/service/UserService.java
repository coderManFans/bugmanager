package cn.com.bugmanger.security.service;

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


    private User getUserById(final  int userId){
        return userDao.getUserById(userId);
    }

    private int updateUser(){
        return 0;
    }

    private List<User> getListUser(){
        List<User>  userList = userDao.getListUser();
        return   userList == null ? null : userList ;
    }

    private int deleteUserByUserId(final int userId){

        return  0;
    }
}
