package cn.com.bugmanager.tag.model;

import cn.com.bugmanager.common.ajax.DataTablesPage;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
public class TagType extends DataTablesPage {
    private int tagId;
    private String tagName;

    public TagType() {
    }

    public TagType(String tagName) {
        this.tagName = tagName;
    }

    public TagType(int tagId) {
        this.tagId = tagId;
    }

    public static TagType getInstanceOfTest() {
        return new TagType("_tagName");
    }


    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}
