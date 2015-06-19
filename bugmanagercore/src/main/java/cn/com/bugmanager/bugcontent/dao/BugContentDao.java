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

    /**
     * 添加错误信息
     * @param bugContent
     * @return 影响行数
     */
      int addBugContentWithAnswer(@Param("bugContent") BugContent bugContent);

    /**
     * 修改错误信息
     * @param bugContent
     * @return
     */
      int updateBugContent(@Param("bugContent") BugContent bugContent);

    /**
     * 根据错误id删除错误信息
     * @param bugContentId
     * @return
     */
      int deleteBugContentById(@Param("bugContentId") String bugContentId);

    /**
     * 获取错误信息总条数
     * @return
     */
      int getBugContentSize();

    /**
     * 根据错误id获取错误信息
     * @param bugContentId
     * @return
     */
      BugContent  getBugContentById(@Param("bugContentId") String bugContentId);

    /**
     * 根据错误信息，带条件的查询方式，使用分页实现
     * @param bugContent
     * @return
     */
      List<BugContent> getBugContentListPage(BugContent bugContent);

    /**
     * 无条件查询方式，使用分页，该方法没有使用
     * @return
     */
      List<BugContent> getBugContentListPageNoSearch();

    /**
     * 添加错误信息，没有解决方案的
     * @param bugContent
     * @return
     */
      int addBugContentNoAnswer(@Param("bugContent") BugContent bugContent);

      //bugtag ---bugcontent --- bugtype

    /**
     * 添加错误--错误类型关联关系
     * @param bugContentId
     * @param bugTypeArray
     * @return
     */
      int addbug_type(@Param("bugContentId") String bugContentId, @Param("bugTypeArray") String[] bugTypeArray);

    /**
     * 添加错误--错误标签关联关系
     * @param bugContentId
     * @param tagIdArray
     * @return
     */
      int addbug_tag(@Param("bugContentId") String bugContentId, @Param("tagIdArray") String[] tagIdArray);

    /**
     * 获取错误id 该方法没有使用，
     * @param bugcode
     * @param bugReason
     * @return
     */
      String getBugContentId(@Param("bugcode") String bugcode, @Param("bugReason") String bugReason);

    /**
     * 查询所有错误信息，无条件查询
     * @return
     */
      List<BugContent>  getBugContentListPage();


    /**
     * 根据起止时间，查询某一段时间内的错误信息
     * @param startTime
     * @param endTime
     * @return
     */
      List<BugContent> getBugContentListPageByTime(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 获取最近一周提交的错误信息
     * @return
     */
      List<BugContent> getBugContentListPageLaterWeek();


}
