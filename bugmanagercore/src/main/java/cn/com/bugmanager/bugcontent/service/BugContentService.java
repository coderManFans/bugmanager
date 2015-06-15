package cn.com.bugmanager.bugcontent.service;

import cn.com.bugmanager.bugcontent.dao.BugContentDao;
import cn.com.bugmanager.bugcontent.model.BugContent;
import cn.com.bugmanager.constant.Constant;
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
    public boolean addBugContentWithAnswer(BugContent bugContent){
        int affectNum = bugContentDao.addBugContentWithAnswer(bugContent);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }


    /**
     * @param bugContent
     * @return
     */
    public boolean addBugContentWithNoAnswer(BugContent bugContent){
        int affectNum = bugContentDao.addBugContentNoAnswer(bugContent);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }

    /**
     * @param bugContent
     * @return
     */
    public boolean updateBugContent(BugContent  bugContent){
        int affectNum = bugContentDao.updateBugContent(bugContent);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }

    /**
     * @param bugContentId
     * @return
     */
    public boolean deleteBugContentById(String bugContentId){
        int affectNum = bugContentDao.deleteBugContentById(bugContentId);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }

    /**
     * @return  为分页
     */
    public List<BugContent> getBugContentListPage(BugContent bugContent){
        List<BugContent>  bugContentList = bugContentDao.getBugContentListPage(bugContent);
        if(bugContentList != null){
            return  bugContentList;
        }
        return  null;
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
    public BugContent getBugContentById(String bugContentId){
        return bugContentDao.getBugContentById(bugContentId);
    }


    public String   getBugContentId(String bugCode,String bugReason){

       return  bugContentDao.getBugContentId(bugCode, bugReason);
    }


    public int addBug_Type(String bugContentId, String  [] bug_typeArray){
        return bugContentDao.addbug_type(bugContentId,bug_typeArray);
    }

    public int addBug_Tag(String bugContentId, String [] bug_tagArray){
        return bugContentDao.addbug_tag(bugContentId,bug_tagArray);
    }


    public List<BugContent> getBugContentListPageNoSearch(){
        return bugContentDao.getBugContentListPage();
    }
}
