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
    private  int getTagTypeByTagTypeId(int tagTypeId){
        int affectNum = tagTypeDao.getTagTypeById(tagTypeId);
        return  affectNum;
    }

    /**
     * @param tagTypeId
     */
    private void deleteTagTypeById(int tagTypeId){
        tagTypeDao.deleteTagTypeByTagId(tagTypeId);
    }

    /**
     * @param tagType
     * @return
     */
    private int updateTagType(TagType tagType){
        return 0;
    }

    private List<TagType> getTagTypeList(){
        return tagTypeDao.getTagTypeList();
    }

    private List<BugType>  getBugTypeListByTagId(int tagId){
        return tagTypeDao.getBugTypeListByTagId(tagId);
    }

}
