package cn.com.bugmanager.webtest.TagTypeControllerTest;

import cn.com.bugmanager.webtest.utiltest.SpringWebTestHelper;
import cn.com.bugmanger.tag.model.TagType;
import cn.com.bugmanger.tag.service.TagTypeService;
import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.Assert.assertEquals;
import static  org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by fcs on 2015/3/23.
 */
public class TagTypeControllerTest extends SpringWebTestHelper {
    private TagType tagType;
    @Autowired
    private TagTypeService  tagTypeService;

    @Before
    public void  initData(){
        tagType = TagType.getInstanceOfTest();
        assertTrue(tagTypeService.addTagType(tagType));
    }

    @Test
    public void testAddTagType(){
        String requestParam = JSON.toJSONString(tagType);   //使用阿里的fastjson
        System.out.println("requestParam = "+requestParam);
        try {
            MvcResult  mvcResult = mockMvc.perform(MockMvcRequestBuilders
                    .post("tag/tagtype").sessionAttr("tagType",requestParam)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestParam)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.returnState").value("OK")).andDo(print()).andReturn();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
