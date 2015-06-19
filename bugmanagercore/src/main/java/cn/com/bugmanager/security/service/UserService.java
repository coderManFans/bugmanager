package cn.com.bugmanager.security.service;

import cn.com.bugmanager.constant.Constant;
import cn.com.bugmanager.security.dao.RoleDao;
import cn.com.bugmanager.security.dao.UserDao;
import cn.com.bugmanager.security.model.Role;
import cn.com.bugmanager.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public User getUserById(final  int userId){
        return userDao.getUserById(userId);
    }

    public  boolean updateUser(User user){
        int affectNum = userDao.updateUser(user);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }

    /**
     * @return
     */
    public List<User> getListUser(){
        List<User>  userList = userDao.getUserList();
        return   userList == null ? null : userList ;
    }

    public List<User> getListUserPage(User user){
        List<User> userListPage = userDao.getUserPageList(user);
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

    /**
     *
     * @param loginUser
     * @return
     */
    public User  loginAuth(User loginUser){
       User user  = userDao.loginAuth(loginUser);
       return user == null ? null : user;
    }

    public List<Role> getRolesByUsername(String username){
        List<Role> roleList = roleDao.getRolesByUsername(username);
        return roleList;
    }

    public List<String> getPermTokensByUsername(String username){
        List<String> permTokenList = roleDao.getRolePermTokensByUsername(username);
        return  permTokenList;
    }

    public User getUserByUsername(String username){
        User user = userDao.getUserByUsername(username);
        return user;
    }













}
