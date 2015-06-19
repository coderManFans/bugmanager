package cn.com.bugmanager.log.dao;

import cn.com.bugmanager.log.model.Log;
import cn.com.bugmanager.mybatis.annotation.mybatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by threegrand2 on 15-1-9.
 */
@mybatisRepository
public interface LogDao {
    int save(Log log);
    int delete(@Param("logId") String logId);
    List<Log> getLogPageList();
}
