package cn.com.bugmanager.tag.service;

import cn.com.bugmanager.constant.Constant;
import cn.com.bugmanager.tag.dao.BugTypeDao;
import cn.com.bugmanager.tag.model.BugType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
@Service
public class BugTypeService {

    @Autowired
    private BugTypeDao bugTypeDao;

    public void setBugTypeDao(BugTypeDao bugTypeDao) {
        this.bugTypeDao = bugTypeDao;
    }

    /**
     * @param bugType
     * @return
     */
    public   boolean  addBugType(BugType bugType){
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

    public List<BugType> getBugTypeListPage(BugType bugType){
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
