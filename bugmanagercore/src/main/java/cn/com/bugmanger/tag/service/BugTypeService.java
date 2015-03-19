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
    private  int addBugType(BugType  bugType){
        int affectNum = bugTypeDao.addBugType(bugType);
        return affectNum;
    }

    private int updateBugType(BugType bugType){
        int affectNum = bugTypeDao.updateBugType(bugType);
        return 0;
    }

    private void deleteBugType(final int bugTypeid){
        bugTypeDao.deleteBugTypeById(bugTypeid);
    }

    private List<BugType> getBugTypeList(){
        return bugTypeDao.getBugTypeList();
    }

    private List<TagType> getTagTypeListByBugid(int bugTypeId){
        return bugTypeDao.getTagTypeListByTagId(bugTypeId);
    }




}
