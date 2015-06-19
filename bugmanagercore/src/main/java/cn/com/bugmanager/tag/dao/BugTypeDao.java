package cn.com.bugmanager.tag.dao;

import cn.com.bugmanager.bugcontent.model.BugContent;
import cn.com.bugmanager.mybatis.annotation.mybatisRepository;
import cn.com.bugmanager.tag.model.BugType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
@mybatisRepository
public interface BugTypeDao {
    /**
     * 添加错误类型
     * @param bugType
     * @return
     */
    int addBugType(@Param("bugType") BugType bugType);

    /**
     * 修改错误类型
     * @param bugType
     * @return
     */
    int updateBugType(@Param("bugType") BugType bugType);

    /**
     * 根据id删除错误类型
     * @param bugTypId
     * @return
     */
    int deleteBugTypeById(@Param("bugTypId") int bugTypId);

    /**
     * 根据id获取错误类型
     * @param bugTypeId
     * @return
     */
    BugType getBugTypeById(@Param("bugTypeId") int bugTypeId);

    /**
     * 条件查询错误类型，使用分页
     * @param bugType
     * @return
     */
    List<BugType> getBugTypeListPage(BugType bugType);

    /**
     * 获取错误类型记录数
     * @return
     */
    int getBugTypeSize();

    /**
     * 获取所有错误类型，无分页，无条件查询，该方法注意是否使用
     * @return
     */
    List<BugType>  getBugTypeList();

    /**
     * 通过错误类型id获取所有错误信息
     * @param bugTypeId
     * @return
     */
    List<BugContent> getBugContentByTypeId(@Param("bugTypeId") int bugTypeId);

    /**
     * 根据错误id获取该错误所有的错误类型
     * @param bugContentId
     * @return
     */
    List<BugType> getBugTypeByBugcontentId(@Param("bugContentId") String bugContentId);

}
