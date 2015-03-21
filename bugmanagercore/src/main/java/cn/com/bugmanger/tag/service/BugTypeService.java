package cn.com.bugmanger.tag.service;

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
        return affectNum == 1;
    }

    /**
     * @param bugType
     * @param oldBugtype
     * @return
     */
    public  boolean updateBugType(BugType bugType,String oldBugtype){

        int affectNum = bugTypeDao.updateBugType(bugType,oldBugtype);
        return  affectNum == 1;
    }

    /**
     * @param bugTypeid
     */
    public  boolean deleteBugType(final int bugTypeid){
        int affectNum = bugTypeDao.deleteBugTypeById(bugTypeid);
        return affectNum == 1;
    }

    public  List<BugType> getBugTypeList(BugType bugType){
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
