package cn.com.bugmanager.bugcontenttest.service;

import cn.com.bugmanager.bugcontent.dao.BugAnswerDao;
import cn.com.bugmanager.bugcontent.model.BugAnswer;
import cn.com.bugmanager.bugcontent.model.BugContent;
import cn.com.bugmanager.bugcontent.service.BugContentService;
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
public class BugAnswerServiceTest extends SpringTransactionalTestCase{
    @Autowired
    private BugAnswerDao  bugAnswerDao;

    @Autowired
    private BugContentService bugContentService;

    private BugAnswer getBugAnswer(){
        BugAnswer  bugAnswer = new BugAnswer();
        bugAnswer.setAnswerInfo("properties is null");
        bugAnswer.setAnswerTime("2014-11-04 09:23:34");
        bugAnswer.setAnswerUserId(1);
        bugAnswer.setRight(false);
        bugAnswer.setBugAnswerId(1);
        return  bugAnswer;
    }

    private BugContent  getBugContent(){
        BugContent bugContent = new BugContent();
        bugContent.setBugCode("bug_code");
        bugContent.setConsoleError("console_error");
        bugContent.setBugReason("bug_reason");
        bugContent.setBugContentId(1);
        return  bugContent;
    }

    @Test
    public void testAdd(){
        BugAnswer bugAnswer = getBugAnswer();
        int affectNum = bugAnswerDao.addAnswer(bugAnswer);
        assertTrue(affectNum == 1);
    }

    @Sql("sql/TestAddBugAnswer.sql")
    @Test
    public void testUpdate(){
        BugAnswer bugAnswer = getBugAnswer();
        int affectNum = bugAnswerDao.updateAnswer(bugAnswer);
        assertTrue(affectNum == 1);
    }

    @Sql("sql/TestAddBugAnswer.sql")
    @Test
    public void testDelete(){
        int affectNum = bugAnswerDao.deleteAnswerById(1);
        assertTrue(affectNum == 1);
    }
    @Sql("sql/TestAddBugAnswer.sql")
    @Test
    public void tesGetById(){
        BugAnswer bugAnswer = bugAnswerDao.getAnswerById(1);
        assertTrue(bugAnswer.getAnswerInfo().equals("add a maven dependency"));
    }

    @Sql("sql/TestAddBugAnswer.sql")
    @Test
    public void testGetList(){
        BugContent bugContent = getBugContent();
        bugContentService.addBugContentWithAnswer(bugContent);
        List<BugAnswer>  list = bugAnswerDao.getAnswerListByBugId(bugContent.getBugContentId());
        assertTrue(list.size() == 1);

    }
}
