package cn.com.bugmanager.bugcontent.service;

import cn.com.bugmanager.bugcontent.dao.BugAnswerDao;
import cn.com.bugmanager.bugcontent.model.BugAnswer;
import cn.com.bugmanager.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by fcs on 2015/3/21.
 */
@Service
public class BugAnswerService {
    @Autowired
    private BugAnswerDao bugAnswerDao;
    /**
     * @param bugAnswer
     * @return
     */
    public boolean addBugAnswer(BugAnswer bugAnswer){
        int affectNum = bugAnswerDao.addAnswer(bugAnswer);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }

    /**
     * @param bugAnswerId
     * @return
     */
    public boolean deleteBugAnswer(int bugAnswerId){
        int affectNum = bugAnswerDao.deleteAnswerById(bugAnswerId);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }

    /**
     * @param bugAnswer
     * @return
     */
    public int updateBugAnswer(BugAnswer  bugAnswer){
        return  bugAnswerDao.updateAnswer(bugAnswer);
    }

    /**
     * @param bugContentId
     * @return
     */
    public List<BugAnswer> getBugAnswerList(int bugContentId){
        List<BugAnswer>  bugAnswerList = bugAnswerDao.getAnswerListByBugId(bugContentId);
        if(bugAnswerList != null && bugAnswerList.size() == 0){
            return bugAnswerList;
        }
        return  null;
    }


}

