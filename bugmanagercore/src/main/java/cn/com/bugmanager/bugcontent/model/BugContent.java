package cn.com.bugmanager.bugcontent.model;
import cn.com.bugmanager.common.ajax.DataTablesPage;

import  java.util.List;
/**
 * Created by fcs on 2015/3/20.
 */
public class BugContent extends DataTablesPage{

    private int bugContentId;
    private String bugReason;      //错误描述
    private String consoleError;   //控制台出现的错误
    private String bugCode;        //项目或者练习中的错误代码
    private int bugTypeId;
    private int bugSolutionId;
    private List<BugAnswer>  bugAnswerList;

    public BugContent() {
    }

    public BugContent(String bugReason, String consoleError, String bugCode, int bugTypeId, int bugSolutionId) {
        this.bugReason = bugReason;
        this.consoleError = consoleError;
        this.bugCode = bugCode;
        this.bugTypeId = bugTypeId;
        this.bugSolutionId = bugSolutionId;
    }


    public BugContent(String bugReason, String consoleError, String bugCode, int bugTypeId) {
        this.bugReason = bugReason;
        this.consoleError = consoleError;
        this.bugCode = bugCode;
        this.bugTypeId = bugTypeId;
    }
    public static BugContent  getBugcontentTestOfInstance(){
        return new BugContent("_bugreason","consoleError","_bugconde",1);
    }




    public int getBugContentId() {
        return bugContentId;
    }

    public void setBugContentId(int bugContentId) {
        this.bugContentId = bugContentId;
    }

    public String getBugReason() {
        return bugReason;
    }

    public void setBugReason(String bugReason) {
        this.bugReason = bugReason;
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

    public int getBugTypeId() {
        return bugTypeId;
    }

    public void setBugTypeId(int bugTypeId) {
        this.bugTypeId = bugTypeId;
    }

    public int getBugSolutionId() {
        return bugSolutionId;
    }

    public void setBugSolutionId(int bugSolutionId) {
        this.bugSolutionId = bugSolutionId;
    }

    public List<BugAnswer> getBugAnswerList() {
        return bugAnswerList;
    }

    public void setBugAnswerList(List<BugAnswer> bugAnswerList) {
        this.bugAnswerList = bugAnswerList;
    }

    @Override
    public String toString() {
        return "BugContent{" +
                "bugContentId=" + bugContentId +
                ", bugReason='" + bugReason + '\'' +
                ", consoleError='" + consoleError + '\'' +
                ", bugCode='" + bugCode + '\'' +
                ", bugTypeId=" + bugTypeId +
                ", bugSolutionId=" + bugSolutionId +
                ", bugAnswerList=" + bugAnswerList +
                '}';
    }
}
