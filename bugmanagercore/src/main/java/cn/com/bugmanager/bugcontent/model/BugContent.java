package cn.com.bugmanager.bugcontent.model;
import cn.com.bugmanager.common.ajax.DataTablesPage;
import cn.com.bugmanager.tag.model.BugType;
import cn.com.bugmanager.tag.model.TagType;

import  java.util.List;
/**
 * Created by fcs on 2015/3/20.
 */
public class BugContent extends DataTablesPage{

    private int bugContentId;
    private String bugReason;      //错误描述
    private String consoleError;   //控制台出现的错误
    private String bugCode;        //项目或者练习中的错误代码
    private boolean hasSolved;     //是否有解决方案
    private String upDate;          //提交时间
    private List<BugType>  bugTypeList;  //错误类型列表
    private List<TagType>  tagTypeList; //错误标签列表
    private List<BugAnswer>  bugAnswerList; //解决方案列表

    public BugContent() {
    }

    public BugContent(int bugContentId) {
        this.bugContentId = bugContentId;
    }

    public int getBugContentId() {
        return bugContentId;
    }

    public void setBugContentId(int bugContentId) {
        this.bugContentId = bugContentId;
    }

    public String getConsoleError() {
        return consoleError;
    }

    public void setConsoleError(String consoleError) {
        this.consoleError = consoleError;
    }

    public String getBugReason() {
        return bugReason;
    }

    public void setBugReason(String bugReason) {
        this.bugReason = bugReason;
    }

    public String getBugCode() {
        return bugCode;
    }

    public void setBugCode(String bugCode) {
        this.bugCode = bugCode;
    }

    public boolean isHasSolved() {
        return hasSolved;
    }

    public void setHasSolved(boolean hasSolved) {
        this.hasSolved = hasSolved;
    }

    public List<BugType> getBugTypeList() {
        return bugTypeList;
    }

    public void setBugTypeList(List<BugType> bugTypeList) {
        this.bugTypeList = bugTypeList;
    }

    public List<TagType> getTagTypeList() {
        return tagTypeList;
    }

    public void setTagTypeList(List<TagType> tagTypeList) {
        this.tagTypeList = tagTypeList;
    }

    public List<BugAnswer> getBugAnswerList() {
        return bugAnswerList;
    }

    public void setBugAnswerList(List<BugAnswer> bugAnswerList) {
        this.bugAnswerList = bugAnswerList;
    }

    public String getUpDate() {
        return upDate;
    }

    public void setUpDate(String upDate) {
        this.upDate = upDate;
    }

    @Override
    public String toString() {
        return "BugContent{" +
                "bugContentId=" + bugContentId +
                ", bugReason='" + bugReason + '\'' +
                ", consoleError='" + consoleError + '\'' +
                ", bugCode='" + bugCode + '\'' +
                ", hasSolved=" + hasSolved +
                ", upDate='" + upDate + '\'' +
                ", bugTypeList=" + bugTypeList +
                ", tagTypeList=" + tagTypeList +
                ", bugAnswerList=" + bugAnswerList +
                '}';
    }
}
