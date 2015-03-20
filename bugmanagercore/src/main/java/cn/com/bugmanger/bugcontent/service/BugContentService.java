package cn.com.bugmanger.bugcontent.service;

import cn.com.bugmanger.bugcontent.dao.BugContentDao;
import cn.com.bugmanger.bugcontent.model.BugContent;
import cn.com.bugmanger.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean updateBugContent(BugContent  bugContent){
        int affectNum = bugContentDao.updateBugContent(bugContent,1);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }


}
