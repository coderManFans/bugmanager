package cn.com.bugmanger.security.dao;

import cn.com.bugmanger.mybatis.annotation.mybatisRepository;
import cn.com.bugmanger.security.model.User;
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
    List<User> getUserListPage(User user);
    int getUserCount();
    int updateUserState(User user);

}
