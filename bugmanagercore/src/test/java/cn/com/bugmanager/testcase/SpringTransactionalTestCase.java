package cn.com.bugmanager.testcase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.sql.DataSource;


/**
 * spring 测试用例抽象类
 */
public abstract class SpringTransactionalTestCase extends AbstractTransactionalJUnit4SpringContextTests {
    protected DataSource dataSource;

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
        this.dataSource = dataSource;
    }
}
