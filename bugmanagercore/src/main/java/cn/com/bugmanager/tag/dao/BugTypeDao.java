package cn.com.bugmanager.tag.dao;

import cn.com.bugmanager.bugcontent.model.BugContent;
import cn.com.bugmanager.mybatis.annotation.mybatisRepository;
import cn.com.bugmanager.tag.model.BugType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
@mybatisRepository
public interface BugTypeDao {
    int addBugType(@Param("bugType") BugType  bugType);
    int updateBugType(@Param("bugType") BugType bugType);
    int deleteBugTypeById(@Param("bugTypId") int bugTypId);
    BugType getBugTypeById(@Param("bugTypeId") int bugTypeId);
    List<BugType> getBugTypePageList(@Param("bugType") BugType bugType);
    int getBugTypeSize();
    List<BugType>  getBugTypeList();

    List<BugContent> getBugContentByTypeId(@Param("bugTypeId") int bugTypeId);

}
