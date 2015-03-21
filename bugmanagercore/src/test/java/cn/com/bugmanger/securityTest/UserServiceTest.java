package cn.com.bugmanger.securityTest;

import cn.com.bugmanger.security.model.User;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by fcs on 2015/3/21.
 */
@ContextConfiguration("/applicationContext-test.xml")
public class UserServiceTest {
    public User getUser(){
        User  user = new User();
        user.setEmail("239234@qq.com");
        return user;
    }
    @Test
    public void testAddUser(){

    }

    @Test
    public void testGetUserById(){

    }

    @Test
    public void testDelete(){

    }
}
