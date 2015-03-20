package cn.com.bugmanger.tag.service;

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
     * @param tagTypeId
     * @return
     */
    protected int getTagTypeByTagTypeId(int tagTypeId){
        int affectNum = tagTypeDao.getTagTypeById(tagTypeId);
        return  affectNum;
    }

    public  int addTagType(TagType tagType){
        int affectedNum = tagTypeDao.addTagType(tagType);
        return affectedNum;
    }
    /**
     * @param tagTypeId
     */
    public  void deleteTagTypeById(int tagTypeId){
        tagTypeDao.deleteTagTypeByTagId(tagTypeId);
    }

    /**
     * @param tagType
     * @return
     */
    public  int updateTagType(TagType tagType){
        return 0;
    }

    public  List<TagType> getTagTypeList(){
        return tagTypeDao.getTagTypeList();
    }

    public  List<BugType>  getBugTypeListByTagId(int tagId){
        return tagTypeDao.getBugTypeListByTagId(tagId);
    }

}
