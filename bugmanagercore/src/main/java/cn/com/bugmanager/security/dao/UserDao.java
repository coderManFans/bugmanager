package cn.com.bugmanager.security.dao;

import cn.com.bugmanager.mybatis.annotation.mybatisRepository;
import cn.com.bugmanager.security.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
@mybatisRepository
public interface UserDao {

    User getUserById(@Param("userId") int userId);
    List<User> getUserList();
    int  deleteUserById(@Param("userId") int userId);
    int  updateUser(@Param("user") User user);
    List<User> getUserListPage(@Param("user") User user);
    int getUserCount();
    int updateUserState(User user);
    int addUser(@Param("user") User user );

}
