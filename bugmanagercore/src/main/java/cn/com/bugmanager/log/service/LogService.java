package cn.com.bugmanager.log.service;


import cn.com.bugmanager.log.dao.LogDao;
import cn.com.bugmanager.log.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by threegrand2 on 15-1-9.
 */
@Service("logService")
public class LogService {
    @Autowired
    private LogDao logDao;
    public int saveLog(Log log){
       return logDao.save(log);
    }

    public int deleteLog(String logId){
        return logDao.delete(logId);
    }

    public List<Log>   getLogPageList(){
        return logDao.getLogPageList();
    }
}
