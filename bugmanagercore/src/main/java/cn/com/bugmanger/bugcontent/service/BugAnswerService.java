package cn.com.bugmanger.bugcontent.service;

import cn.com.bugmanger.bugcontent.dao.BugAnswerDao;
import cn.com.bugmanger.bugcontent.model.BugAnswer;
import cn.com.bugmanger.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by fcs on 2015/3/21.
 */
@Service("bugAnswerService")
public class BugAnswerService {
    @Autowired
    private BugAnswerDao bugAnswerDao;

    /**
     * @param bugAnswer
     * @return
     */
    public boolean addBugAnswer(BugAnswer bugAnswer){
       int affectNum = bugAnswerDao.addBugAnswer(bugAnswer);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }

    /**
     * @param bugAnswerId
     * @return
     */
    public int deleteBugAnswer(int bugAnswerId){
        return   bugAnswerDao.deleteBugAnswerById(bugAnswerId);

    }

    /**
     * @param bugAnswer
     * @return
     */
    public int updateBugAnswer(BugAnswer  bugAnswer){
        return  bugAnswerDao.updateBugAnswer(bugAnswer);
    }

    /**
     * @param bugContentId
     * @return
     */
    public List<BugAnswer> getBugAnswerList(int bugContentId){
        List<BugAnswer>  bugAnswerList = bugAnswerDao.getBugAnswerByBugId(bugContentId);
       if(bugAnswerList != null && bugAnswerList.size() == 0){
           return bugAnswerList;
       }
        return  null;
    }



}

