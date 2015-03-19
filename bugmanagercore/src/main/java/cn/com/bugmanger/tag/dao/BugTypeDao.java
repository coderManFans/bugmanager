package cn.com.bugmanger.tag.dao;

import cn.com.bugmanger.mybatis.annotation.mybatisRepository;
import cn.com.bugmanger.tag.model.BugType;
import cn.com.bugmanger.tag.model.TagType;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
@mybatisRepository
public interface BugTypeDao {
    int addBugType(BugType  bugType);
    int updateBugType(BugType bugType);
    void deleteBugTypeById(int bugTypId);
    void deleteBugTypeByTagName(String tagName);
    BugType getBugTypeById(int bugTypeId);
    List<BugType> getBugTypeList();
    List<TagType> getTagTypeListByTagId(int tagId);
}
