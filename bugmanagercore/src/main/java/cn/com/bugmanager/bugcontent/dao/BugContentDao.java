package cn.com.bugmanager.bugcontent.dao;

import cn.com.bugmanager.bugcontent.model.BugContent;
import cn.com.bugmanager.mybatis.annotation.mybatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fcs on 2015/3/20.
 */
@mybatisRepository
public interface BugContentDao {

      int addBugContentWithAnswer(@Param("bugContent") BugContent  bugContent);
      int updateBugContent(@Param("bugContent") BugContent bugContent);
      int deleteBugContentById(@Param("bugContentId") int bugContentId);
      List<BugContent> getBugContentList();
      int getBugContentSize();
      BugContent  getBugContentById(@Param("bugContentId") int bugContentId);
      List<BugContent> getBugContentListPage(@Param("bugContent") BugContent bugContent);
      int addBugContentNoAnswer(@Param("bugContent") BugContent bugContent);


}
