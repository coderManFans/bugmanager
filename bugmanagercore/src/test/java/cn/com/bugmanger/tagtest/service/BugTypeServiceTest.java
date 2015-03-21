package cn.com.bugmanger.tagtest.service;

import cn.com.bugmanger.tag.model.BugType;
import cn.com.bugmanger.tag.service.BugTypeService;
import cn.com.bugmanger.testcase.SpringTransactionalTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static  org.junit.Assert.assertTrue;
/**
 * Created by fcs on 2015/3/20.
 */
@ContextConfiguration("/applicationContext-test.xml")
public class BugTypeServiceTest extends SpringTransactionalTestCase {

    @Autowired
    private BugTypeService  bugTypeService;

    public BugType getBugType(){
        BugType  bugType = new BugType();
        bugType.setBugType("运行时错误");
        bugType.setBugTypeIntroduce("java虚拟机在运行java字节码文件的时候出现的错误，在编译的时候并不能发现");
        //bugType.setBugTypeId(1);
        return bugType;
    }
    @Test
    public void testAddBugType(){
        BugType bugType = getBugType();
        assertTrue(bugTypeService.addBugType(bugType));
    }
    @Sql("sql/TestAddBugType.sql")

    @Test
    public void testGetBugTypebyId(){
        BugType  bugType = bugTypeService.getBugTypeById(1);
        assertTrue(bugType != null);
    }

    @Sql("sql/TestAddBugType.sql")
    @Test  //出现乱码
    public void testUpdateByName(){
        BugType  bugType = new BugType();
        bugType.setBugType("运行时错误");
        bugType.setBugTypeIntroduce("运行韩版");
        boolean b = bugTypeService.updateBugType(bugType,"编译错误");
        bugType = bugTypeService.getBugTypeById(1);
        System.out.println(bugType.getBugType().toString()+"---");
    }

    @Sql("sql/TestAddBugType.sql")
    @Test
    public void testDelete(){
        assertTrue(bugTypeService.deleteBugType(1));
    }

    @Sql("sql/TestAddBugType.sql")
    @Test
    public void testGetList(){
        BugType bugType = getBugType();
        List<BugType> list = bugTypeService.getBugTypeList(bugType);
        assertTrue(list.size() == 1);
    }
}