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
    /**
     * 添加解决方法
     * @param bugAnswer
     * @return sql影响条数
     */
    int addAnswer(@Param("bugAnswer") BugAnswer bugAnswer);

    /**
     * 修改解决方法
     * @param bugAnswer
     * @return
     */
    int updateAnswer(@Param("bugAnswer") BugAnswer bugAnswer);

    /**
     * 根据解决方法id删除解决方法
     * @param bugAnswerId
     * @return
     */
    int deleteAnswerById(@Param("bugAnswerId") int bugAnswerId);

    /**
     * 根据解决方法id获取解决方法
     * @param bugAnswerId
     * @return
     */
    BugAnswer  getAnswerById(@Param("bugAnswerId") int bugAnswerId);

    /**
     * 根据错误id获取该错误的所有解决方法
     * @param bugContentId
     * @return
     */
    List<BugAnswer> getAnswerListByBugId(@Param("bugContentId") String bugContentId);
}
