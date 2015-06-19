package cn.com.bugmanager.bugcontent.model;
import cn.com.bugmanager.common.ajax.DataTablesPage;
import cn.com.bugmanager.tag.model.BugType;
import cn.com.bugmanager.tag.model.TagType;

import  java.util.List;
/**
 * Created by fcs on 2015/3/20.
 */
public class BugContent extends DataTablesPage{

    private String bugcontentid;
    private int userId;           //提交用户Id
    private String bugReason;      //错误描述
    private String consoleError;   //控制台出现的错误
    private String bugCode;        //项目或者练习中的错误代码
    private boolean hasSolved;     //是否有解决方案
    private String addDate;          //提交时间
    private List<BugType>  bugTypeList;   //错误类型列表
    private List<TagType>  tagTypeList;   //错误标签列表
    private List<BugAnswer>  bugAnswerList; //解决方案列表



    public BugContent() {
    }

    public String getBugcontentid() {
        return bugcontentid;
    }

    public void setBugcontentid(String bugcontentid) {
        this.bugcontentid = bugcontentid;
    }

    public String getBugReason() {
        return bugReason;
    }

    public void setBugReason(String bugReason) {
        this.bugReason = bugReason;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getConsoleError() {
        return consoleError;
    }

    public void setConsoleError(String consoleError) {
        this.consoleError = consoleError;
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

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BugContent that = (BugContent) o;

        if (addDate != null ? !addDate.equals(that.addDate) : that.addDate != null) return false;
        if (bugCode != null ? !bugCode.equals(that.bugCode) : that.bugCode != null) return false;
        if (bugReason != null ? !bugReason.equals(that.bugReason) : that.bugReason != null) return false;
        if (bugcontentid != null ? !bugcontentid.equals(that.bugcontentid) : that.bugcontentid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bugcontentid != null ? bugcontentid.hashCode() : 0;
        result = 31 * result + (bugReason != null ? bugReason.hashCode() : 0);
        result = 31 * result + (bugCode != null ? bugCode.hashCode() : 0);
        result = 31 * result + (addDate != null ? addDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BugContent{" +
                "bugcontentid='" + bugcontentid + '\'' +
                ", userId=" + userId +
                ", bugReason='" + bugReason + '\'' +
                ", consoleError='" + consoleError + '\'' +
                ", bugCode='" + bugCode + '\'' +
                ", hasSolved=" + hasSolved +
                ", addDate='" + addDate + '\'' +
                ", bugTypeList=" + bugTypeList +
                ", tagTypeList=" + tagTypeList +
                ", bugAnswerList=" + bugAnswerList +
                '}';
    }
}
