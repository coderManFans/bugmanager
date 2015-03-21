package cn.com.bugmanger.tag.service;

import cn.com.bugmanger.constant.Constant;
import cn.com.bugmanger.tag.dao.TagTypeDao;
import cn.com.bugmanger.tag.model.BugType;
import cn.com.bugmanger.tag.model.TagType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
@Service("tagTypeService")
public class TagTypeService {
    @Autowired
    private TagTypeDao tagTypeDao;


    /**
     * @param tagType
     * @return
     */
    public  boolean addTagType(TagType tagType){
       int affectNUm = tagTypeDao.addTagType(tagType);
        return Constant.AFFECTED_LINE_1 == affectNUm;
    }
    /**
     * @param tagTypeId
     */
    public  boolean deleteTagTypeById(int tagTypeId){
        int affectNUm = tagTypeDao.deleteTagTypeByTagId(tagTypeId);
        System.out.println("a = "+affectNUm);
        return  Constant.AFFECTED_LINE_1 == affectNUm;
    }

    /**
     * @param tagType
     * @return
     */
    public  boolean updateTagType(TagType tagType){
        int affectNum = tagTypeDao.updateTagType(tagType);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }

    public  List<TagType> getTagTypeList(){
        return tagTypeDao.getTagTypeListPage();
    }

    public  List<BugType>  getBugTypeListByTagId(int tagId){
        return tagTypeDao.getBugTypeListByTagId(tagId);
    }

    /**
     * @param tagId
     * @return TagType
     */
    public TagType getTagTypeById(int tagId){
        return tagTypeDao.getTagTypeById(tagId);
    }


    public int getTagTypeListSize(){
        return tagTypeDao.getTagTypeSize();
    }
}
