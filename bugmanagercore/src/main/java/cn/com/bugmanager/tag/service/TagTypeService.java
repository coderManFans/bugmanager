package cn.com.bugmanager.tag.service;

import cn.com.bugmanager.constant.Constant;
import cn.com.bugmanager.tag.dao.TagTypeDao;
import cn.com.bugmanager.tag.model.BugType;
import cn.com.bugmanager.tag.model.TagType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
@Service
public class TagTypeService {

    @Autowired
    private TagTypeDao tagTypeDao;

    public  boolean addTagType(TagType tagType){
        int affectNUm = tagTypeDao.addTagType(tagType);
        return Constant.AFFECTED_LINE_1 == affectNUm;
    }

    public  boolean deleteTagTypeById(int tagTypeId){
        int affectNUm = tagTypeDao.deleteTagTypeByTagId(tagTypeId);
        System.out.println("a = "+affectNUm);
        return  Constant.AFFECTED_LINE_1 == affectNUm;
    }

    public  boolean updateTagType(TagType tagType){
        int affectNum = tagTypeDao.updateTagType(tagType);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }

    public List<TagType> getTagTypeList(TagType tagType){
        return tagTypeDao.getTagTypePageList(tagType);
    }

    public  List<BugType>  getBugTypeListByTagId(int tagId){
        return tagTypeDao.getBugTypePageListByTagId(tagId);
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
