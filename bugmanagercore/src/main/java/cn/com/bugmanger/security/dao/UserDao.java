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

    /**
     * @param userId
     * @return
     */
   User getUserById(@Param("userId") int userId);
   List<User> getListUser();
   int  deleteUserById(int userId);
   int  updateUser(User user);
}
