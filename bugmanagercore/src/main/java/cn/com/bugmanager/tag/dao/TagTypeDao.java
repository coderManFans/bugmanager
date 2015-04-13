package cn.com.bugmanager.tag.dao;

import cn.com.bugmanager.bugcontent.model.BugContent;
import cn.com.bugmanager.mybatis.annotation.mybatisRepository;
import cn.com.bugmanager.tag.model.BugType;
import cn.com.bugmanager.tag.model.TagType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
@mybatisRepository
public interface TagTypeDao {

    //方法参数中加入@Param注解可以在mybatis中不用设置方法参数类型
    TagType getTagTypeById(@Param("tagId") int tagId);
    int addTagType(@Param("tagType") TagType tagType);
    int deleteTagTypeByTagId(@Param("tagId") int tagId);
    int updateTagType(@Param("tagType") TagType  tagType);
    List<TagType> getTagTypeListPage(@Param("tagType") TagType tagType);
    List<BugType> getBugTypeListByTagId(@Param("tagId") int tagId);
    int getTagTypeSize();
    List<TagType> getTagTypeList();

    List<BugContent>  getBugContentBytagId(@Param("tagId") int tagId);
}
