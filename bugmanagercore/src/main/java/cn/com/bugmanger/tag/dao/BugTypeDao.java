package cn.com.bugmanger.tag.dao;

import cn.com.bugmanger.mybatis.annotation.mybatisRepository;
import cn.com.bugmanger.tag.model.BugType;
import cn.com.bugmanger.tag.model.TagType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
@mybatisRepository
public interface BugTypeDao {
    int addBugType(@Param("bugType") BugType  bugType);
    int updateBugType(@Param("bugType") BugType bugType, @Param("oldbugType") String oldbugType);
    int deleteBugTypeById(@Param("bugTypId") int bugTypId);
    BugType getBugTypeById(@Param("bugTypeId") int bugTypeId);
    List<BugType> getBugTypeListPage();
    int getBugTypeSize();
}
