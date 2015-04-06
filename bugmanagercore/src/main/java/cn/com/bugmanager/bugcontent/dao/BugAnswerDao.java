package cn.com.bugmanager.bugcontent.dao;

import cn.com.bugmanager.bugcontent.model.BugAnswer;
import cn.com.bugmanager.mybatis.annotation.mybatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * Created by fcs on 2015/3/21.
 */
@mybatisRepository
public interface BugAnswerDao {
    int addAnswer(@Param("bugAnswer") BugAnswer bugAnswer);
    int updateAnswer(@Param("bugAnswer") BugAnswer bugAnswer);
    int deleteAnswerById(@Param("bugAnswerId") int bugAnswerId);
    BugAnswer  getAnswerById(@Param("bugAnswerId") int bugAnswerId);
    List<BugAnswer> getAnswerListByBugId(@Param("bugContentId") String bugContentId);
}
