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

    /**
     * 通过id获取错误标签信息
     * @param tagId
     * @return
     */
    TagType getTagTypeById(@Param("tagId") int tagId);

    /**
     * 添加错误标签
     * @param tagType
     * @return
     */
    int addTagType(@Param("tagType") TagType tagType);

    /**
     * 通过id删除错误标签
     * @param tagId
     * @return
     */
    int deleteTagTypeByTagId(@Param("tagId") int tagId);

    /**
     * 修改错误标签
     * @param tagType
     * @return
     */
    int updateTagType(@Param("tagType") TagType tagType);

    /**
     * 带条件的查询错误标签，分页显示
     * @param tagType
     * @return
     */
    List<TagType> getTagTypeListPage(TagType tagType);

    /**
     * 通过错误标签id获取错误类型，该方法不对
     * @param tagId
     * @return
     */
    List<BugType> getBugTypePageListByTagId(@Param("tagId") int tagId);

    /**
     * 获取错误标签总记录数
     * @return
     */
    int getTagTypeSize();

    /**
     * 查询所有错误标签信息，无分页，该方法没有使用
     * @return
     */
    List<TagType> getTagTypeList();

    /**
     * 通过标签id，获取有该标签的所有错误信息
     * @param tagId
     * @return
     */
    List<BugContent>  getBugContentBytagId(@Param("tagId") int tagId);

    /**
     * 通过错误信息id，获取该错误有多少标签
     * @param bugContentId
     * @return
     */
    List<TagType> getTagTypeByBugcontentId(@Param("bugContentId") String bugContentId);
}
