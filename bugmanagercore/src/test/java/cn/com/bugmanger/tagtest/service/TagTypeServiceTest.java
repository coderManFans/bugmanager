package cn.com.bugmanger.tagtest.service;

/**
 * Created by fcs on 2015/3/20.
 */

import cn.com.bugmanger.tag.model.TagType;
import cn.com.bugmanger.tag.service.TagTypeService;
import cn.com.bugmanger.testcase.SpringTransactionalTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static  org.junit.Assert.assertTrue;
@ContextConfiguration("/applicationContext-test.xml")
public class TagTypeServiceTest extends SpringTransactionalTestCase {

    @Autowired
    private TagTypeService  tagTypeService;

    private TagType getTagType(){
        TagType tagType = new TagType();
       // tagType.setTagId(1);
        tagType.setTagName("java");
        return tagType;
    }

    @Test
    public void testAddTagType(){
        TagType  tagType = getTagType();
        int a=  tagTypeService.addTagType(tagType);
        System.out.println("at = "+a);
    }





}
