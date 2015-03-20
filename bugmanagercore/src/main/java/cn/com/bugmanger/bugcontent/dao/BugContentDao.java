package cn.com.bugmanger.bugcontent.dao;

import cn.com.bugmanger.bugcontent.model.BugContent;
import cn.com.bugmanger.mybatis.annotation.mybatisRepository;

import java.util.List;

/**
 * Created by fcs on 2015/3/20.
 */
@mybatisRepository
public interface BugContentDao {
    public  int addBugContent(BugContent  bugContent);
    public  int updateBugContent(BugContent bugContent,int bugContentId);
    public  int deleteBugContentById(int bugContentId);
    public  List<BugContent> getBugContentList();
    public  int getBugContentSize();

}
