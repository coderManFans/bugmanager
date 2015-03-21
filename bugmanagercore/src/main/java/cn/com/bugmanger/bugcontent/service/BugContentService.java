package cn.com.bugmanger.bugcontent.service;

import cn.com.bugmanger.bugcontent.dao.BugContentDao;
import cn.com.bugmanger.bugcontent.model.BugContent;
import cn.com.bugmanger.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fcs on 2015/3/20.
 */
@Service("bugContentService")
public class BugContentService {
    @Autowired
   private BugContentDao bugContentDao;

    /**
     * @param bugContent
     * @return
     */
    public boolean addBugContent(BugContent  bugContent){
        int affectNum = bugContentDao.addBugContent(bugContent);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }


    /**
     * @param bugContent
     * @return
     */
    public boolean updateBugContent(BugContent  bugContent){
        int affectNum = bugContentDao.updateBugContent(bugContent,1);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }

    /**
     * @param bugContentId
     * @return
     */
    public boolean deleteBugContentById(int bugContentId){
        int affectNum = bugContentDao.deleteBugContentById(bugContentId);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }

    /**
     * @return  为分页
     */
    public List<BugContent> getBugContentList(){
        return null;
    }

    /**
     * @return
     */
    public int getBugContentListSize(){
        return bugContentDao.getBugContentSize();
    }

    /**
     * @param bugContentId
     * @return
     */
    public BugContent getBugContentById(int bugContentId){
        return bugContentDao.getBugContentById(bugContentId);
    }


}
