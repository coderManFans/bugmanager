package cn.com.bugmanger.bugcontent.model;
import cn.com.bugmanger.common.ajax.DataTablesPage;

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
}
