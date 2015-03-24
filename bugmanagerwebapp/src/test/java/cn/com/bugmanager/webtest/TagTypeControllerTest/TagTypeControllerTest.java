package cn.com.bugmanager.webtest.TagTypeControllerTest;

import cn.com.bugmanager.webtest.utiltest.SpringWebTestHelper;
import cn.com.bugmanger.tag.model.TagType;
import cn.com.bugmanger.tag.service.TagTypeService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.Assert.assertEquals;
import static  org.junit.Assert.assertTrue;
/**
 * Created by fcs on 2015/3/23.
 */
public class TagTypeControllerTest extends SpringWebTestHelper {
    private TagType tagType;
    @Autowired
    private TagTypeService  tagTypeService;

    @Before
    public void  initData(){
        TagType  tagType = TagType.getInstanceOfTest();
        assertTrue(tagTypeService.addTagType(tagType));
    }


    @Test
    public void testAdd(){


        MvcResult  mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("").contentType(MediaType.APPLICATION_JSON).)
    }



}
