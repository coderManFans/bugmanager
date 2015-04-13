package cn.com.bugmanager.tag.model;

import cn.com.bugmanager.common.ajax.DataTablesPage;

import java.util.List;

/**
 * Created by fcs on 2015/3/19.
 */
public class BugType extends DataTablesPage{
    private int bugTypeId;
    private String bugType;
    private String bugintroduce;

    public BugType(){}

    public BugType(int bugTypeId) {
        this.bugTypeId = bugTypeId;
    }


    public String getBugintroduce() {
        return bugintroduce;
    }

    public void setBugintroduce(String bugintroduce) {
        this.bugintroduce = bugintroduce;
    }

    public String getBugType() {
        return bugType;
    }

    public void setBugType(String bugType) {
        this.bugType = bugType;
    }

    public int getBugTypeId() {
        return bugTypeId;
    }

    public void setBugTypeId(int bugTypeId) {
        this.bugTypeId = bugTypeId;
    }

    @Override
    public String toString() {
        return "BugType{" +
                "bugTypeId=" + bugTypeId +
                ", bugType='" + bugType + '\'' +
                ", bugintroduce='" + bugintroduce + '\'' +
                '}';
    }
}
