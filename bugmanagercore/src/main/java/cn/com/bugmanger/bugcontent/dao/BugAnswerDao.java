package cn.com.bugmanger.bugcontent.dao;

import cn.com.bugmanger.bugcontent.model.BugAnswer;
import cn.com.bugmanger.mybatis.annotation.mybatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * Created by fcs on 2015/3/21.
 */
@mybatisRepository
public interface BugAnswerDao {
    int addBugAnswer(@Param("bugAnswer") BugAnswer bugAnswer);
    int updateBugAnswer(@Param("bugAnswer") BugAnswer bugAnswer);
    int deleteBugAnswerById(@Param("bugAnswerId") int bugAnswerId);
    BugAnswer  getBugAnswerById(@Param("bugAnswerId") int bugAnswerId);
    List<BugAnswer> getBugAnswerByBugId(@Param("bugContentId") int bugContentId);
}
