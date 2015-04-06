package cn.com.bugmanager.bugcontenttest.service;

import cn.com.bugmanager.bugcontent.model.BugContent;
import cn.com.bugmanager.bugcontent.service.BugContentService;
import cn.com.bugmanager.testcase.SpringTransactionalTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;


import static org.junit.Assert.assertEquals;
import static  org.junit.Assert.assertTrue;
/**
 * Created by fcs on 2015/3/20.
 */
@ContextConfiguration("/applicationContext-test.xml")
public class BugContentServiceTest extends SpringTransactionalTestCase {
    @Autowired
    private BugContentService  bugContentService;

    private BugContent getBugContent(){
        BugContent bugContent = new BugContent();
        bugContent.setBugCode("_bugcode");
        bugContent.setBugReason("_bugreason");
        bugContent.setConsoleError("_consoleerror");
        return  bugContent;
    }
    @Test
    public void testAddBugContent(){
        BugContent bugContent = getBugContent();
        assertTrue(bugContentService.addBugContentWithAnswer(bugContent));
    }

    @Sql("sql/TestAddBugContent.sql")
    @Test
    public void testGetBugContent(){
        BugContent bugContent = bugContentService.getBugContentById(1+"");
        assertTrue(bugContent.getBugcontentid() == (""+1));
    }

    @Sql("sql/TestAddBugContent.sql")
    @Test
    public void testDeleteBugContent(){
       assertTrue(bugContentService.deleteBugContentById(""+1));
    }

    @Sql("sql/TestAddBugContent.sql")
    @Test
    public void testUpdateBugContent(){
        BugContent  bugContent = new BugContent();
        bugContent.setBugReason("reason");
        bugContent.setConsoleError("console_error");
        bugContent.setBugcontentid(1+"");
        bugContent.setBugCode("bug_code");
        bugContentService.updateBugContent(bugContent);
        bugContent = bugContentService.getBugContentById(""+1);
        assertTrue(bugContent.getBugReason().equals("reason"));
    }

    @Sql("sql/TestAddBugContent.sql")
    @Test
    public void testGetBugContentSize(){
        int num =bugContentService.getBugContentListSize();
        assertTrue(num == 1);
    }

    @Sql("sql/TestAddBugContent.sql")
    @Test
    public void testGetBugContentList(){
        int size = bugContentService.getBugContentListPage().size();
        assertTrue(size == 1);
    }
}
