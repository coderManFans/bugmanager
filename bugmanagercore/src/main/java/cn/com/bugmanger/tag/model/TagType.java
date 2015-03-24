package cn.com.bugmanger.tag.model;

import cn.com.bugmanger.common.ajax.DataTablesPage;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
public class TagType extends DataTablesPage{
    private int tagId;
    private String tagName;
    private List<BugType> bugTypeList;


    public TagType() {
    }

    public TagType(int tagId) {
        this.tagId = tagId;
    }

    public static TagType getInstanceOfTest(){
        return new TagType();
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

    public List<BugType> getBugTypeList() {
        return bugTypeList;
    }

    public void setBugTypeList(List<BugType> bugTypeList) {
        this.bugTypeList = bugTypeList;
    }
}
