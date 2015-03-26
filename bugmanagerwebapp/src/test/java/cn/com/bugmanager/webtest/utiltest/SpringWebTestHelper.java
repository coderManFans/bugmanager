package cn.com.bugmanager.webtest.utiltest;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


//xml风格
@RunWith(SpringJUnit4ClassRunner.class)
//测试环境使用，用来表示测试环境使用的ApplicationContext将是WebApplicationContext类型的，value指定应用的根
@WebAppConfiguration(value = "src/main/webapp")
//指定容器的层次，spring 上下文具有继承关系
@ContextHierarchy({
        @ContextConfiguration(name = "parent",locations = "classpath:applicationContext.xml"),
        @ContextConfiguration(name = "child",locations = "classpath:spring-mvc.xml")
})
//声明事务管理，每一个单元测试都进行事务回滚，无论成功与否
@TransactionConfiguration(defaultRollback = true)
public class SpringWebTestHelper extends AbstractTransactionalJUnit4SpringContextTests{

    @Autowired
    protected WebApplicationContext webApplicationContext;

    protected MockMvc  mockMvc;
    @Before
    public void setup(){
        //通过webAppContextSetup().build()，创建一个MockMvc的测试
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


}
