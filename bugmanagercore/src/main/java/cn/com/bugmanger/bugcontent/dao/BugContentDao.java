package cn.com.bugmanger.bugcontent.dao;

import cn.com.bugmanger.bugcontent.model.BugContent;
import cn.com.bugmanger.mybatis.annotation.mybatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fcs on 2015/3/20.
 */
@mybatisRepository
public interface BugContentDao {


    public  int addBugContent(@Param("bugContent") BugContent  bugContent);
    public  int updateBugContent(@Param("bugContent") BugContent bugContent, @Param("bugContentId") int bugContentId);
    public  int deleteBugContentById(@Param("bugContentId") int bugContentId);
    public  List<BugContent> getBugContentList();
    public  int getBugContentSize();
    public  BugContent  getBugContentById(int bugContentId);
}
