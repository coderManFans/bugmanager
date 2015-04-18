package cn.com.bugmanager.tagtest.service;

/**
 * Created by fcs on 2015/3/20.
 */

import cn.com.bugmanager.tag.model.TagType;
import cn.com.bugmanager.tag.service.TagTypeService;
import cn.com.bugmanager.testcase.SpringTransactionalTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static  org.junit.Assert.assertTrue;
@ContextConfiguration("/applicationContext-test.xml")
public class TagTypeServiceTest extends SpringTransactionalTestCase {

    @Autowired
    private TagTypeService  tagTypeService;

    private TagType getTagType(){
        TagType tagType = new TagType();
        tagType.setTagId(1);
        tagType.setTagName("java");
        return tagType;
    }

    @Test
    public void testAddTagType(){
        TagType  tagType = getTagType();
        boolean is = tagTypeService.addTagType(tagType);
        assertTrue(is);
    }

    @Sql("sql/TestAddTagType.sql")
    @Test
    public void testDeleteTagType(){
        testAddTagType();
        assertTrue(tagTypeService.deleteTagTypeById(2));
    }
    @Test
    public void testGettagtypeList(){
        testAddTagType();
    }
    @Sql("sql/TestAddTagType.sql")
    @Test
    public void testGetTagTypeByTagId(){
        testAddTagType();
        TagType tagType = tagTypeService.getTagTypeById(2);
        System.out.println("tag = "+tagType.getTagName());
        assertTrue(tagType.getTagId() == 2);
    }

    @Sql("sql/TestAddTagType.sql")
    @Test
    public void testUpdateTagTypeByTagName(){
        TagType tagType = tagTypeService.getTagTypeById(2);
        tagType.setTagName("python");
        tagTypeService.updateTagType(tagType);
        tagType = tagTypeService.getTagTypeById(2);
        assertTrue(tagType.getTagName().equals("python"));
    }

    @Sql("sql/TestAddTagType.sql")
    @Test
    public void testGetTagListSize(){
        int size = tagTypeService.getTagTypeListSize();
        assertTrue(size == 1);
    }

    @Sql("sql/TestAddTagType.sql")
    @Test
    public void testGetTagList(){
        TagType tagType = getTagType();
        List<TagType> tagList = tagTypeService.getTagTypeList(tagType);
        assertTrue(tagList.size() == 1);
    }

}
