package cn.com.bugmanager.securityTest;

import cn.com.bugmanager.security.model.User;
import cn.com.bugmanager.security.service.UserService;
import cn.com.bugmanager.testcase.SpringTransactionalTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static  org.junit.Assert.assertTrue;
/**
 * Created by fcs on 2015/3/21.
 */
@ContextConfiguration("/applicationContext-test.xml")
public class UserServiceTest extends SpringTransactionalTestCase {
    @Autowired
    private UserService  userService;
    public User getUser(){
        User  user = new User();
        user.setEmail("239234@qq.com");
        user.setUserId(1);
        user.setUserName("zhangsan");
        user.setUserPass("12345");
        user.setUserState("unline");
        return user;
    }
    @Test
    public void testAddUser(){
        User user = getUser();
        System.out.println(user==null);
        boolean s = userService.addUser(user);
        System.out.println("s = "+s);
        assertTrue( userService.addUser(user));
    }

    @Sql("sql/TestAddUser.sql")
    @Test
    public void testGetUserById(){
        User user = userService.getUserById(1);
        assertTrue(user != null);
    }
    @Sql("sql/TestAddUser.sql")
    @Test
    public void testDelete(){
        boolean is = userService.deleteUserByUserId(1);
        assertTrue(is);
    }

    @Sql("sql/TestAddUser.sql")
    @Test
    public void testUpdate(){
        User user = getUser();
        boolean is =  userService.updateUser(user);
        assertTrue(is);
    }

    @Sql("sql/TestAddUser.sql")
    @Test
    public void testGetList(){
        List<User> userList = userService.getListUser();
        assertTrue(userList.size() == 1);
    }


    @Sql("sql/TestAddUser.sql")
    @Test
    public void testGetListPage(){
        testAddUser();
        User user = getUser();
        List<User> userListPage = userService.getListUserPage(user);
        assertTrue(userListPage.size() == 2);
    }
}
