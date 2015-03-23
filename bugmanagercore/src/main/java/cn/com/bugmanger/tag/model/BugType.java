package cn.com.bugmanger.tag.model;

import cn.com.bugmanger.common.ajax.DataTablesPage;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
public class BugType extends DataTablesPage{
    private int bugTypeId;
    private String bugType;
    private String bugTypeIntroduce;
    private List<TagType> tagTypeList;

    public int getBugTypeId() {
        return bugTypeId;
    }

    public void setBugTypeId(int bugTypeId) {
        this.bugTypeId = bugTypeId;
    }

    public String getBugType() {
        return bugType;
    }

    public void setBugType(String bugType) {
        this.bugType = bugType;
    }

    public String getBugTypeIntroduce() {
        return bugTypeIntroduce;
    }

    public void setBugTypeIntroduce(String bugTypeIntroduce) {
        this.bugTypeIntroduce = bugTypeIntroduce;
    }

    public List<TagType> getTagTypeList() {
        return tagTypeList;
    }

    public void setTagTypeList(List<TagType> tagTypeList) {
        this.tagTypeList = tagTypeList;
    }
}
