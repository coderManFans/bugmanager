package cn.com.bugmanger.tag.dao;

import cn.com.bugmanger.mybatis.annotation.mybatisRepository;
import cn.com.bugmanger.tag.model.BugType;
import cn.com.bugmanger.tag.model.TagType;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
@mybatisRepository
public interface TagTypeDao {

    int getTagTypeById(int tagId);
    int addTagType(TagType tagType);
    void deleteTagTypeByTagId(int tagId);
    int updateTagType(TagType tagType);
    List<TagType> getTagTypeList();
    List<BugType> getBugTypeListByTagId(int tagId);
}
