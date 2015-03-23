package cn.com.bugmanger.tag.service;

import cn.com.bugmanger.constant.Constant;
import cn.com.bugmanger.tag.dao.BugTypeDao;
import cn.com.bugmanger.tag.model.BugType;
import cn.com.bugmanger.tag.model.TagType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
@Service("bugTypeService")
public class BugTypeService {
    @Autowired
    private BugTypeDao bugTypeDao;

    /**
     * @param bugType
     * @return
     */
    public   boolean  addBugType(BugType  bugType){
        int affectNum = bugTypeDao.addBugType(bugType);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }

    /**
     * @param bugType
     * @return
     */
    public  boolean updateBugType(BugType bugType){

        int affectNum = bugTypeDao.updateBugType(bugType);
        return  Constant.AFFECTED_LINE_1 == affectNum;
    }

    /**
     * @param bugTypeid
     */
    public  boolean deleteBugType(final int bugTypeid){
        int affectNum = bugTypeDao.deleteBugTypeById(bugTypeid);
        return affectNum == 1;
    }

    public  List<BugType> getBugTypeListPage(BugType bugType){
        return bugTypeDao.getBugTypeListPage(bugType);
    }


    /**
     * @param bugTypeId
     * @return
     */
    public BugType  getBugTypeById(int bugTypeId){
        return  bugTypeDao.getBugTypeById(bugTypeId);
    }
}
