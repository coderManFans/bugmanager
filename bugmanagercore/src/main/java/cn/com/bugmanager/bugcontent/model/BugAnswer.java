package cn.com.bugmanager.bugcontent.model;

import cn.com.bugmanager.common.ajax.DataTablesPage;

/**
 * Created by fcs on 2015/3/21.
 */
public class BugAnswer extends DataTablesPage{
    private int bugAnswerId;
    private String answerInfo;
    private String answerTime;
    private int answerUserId;
    private boolean isRight;

    public BugAnswer() {
    }

    public BugAnswer(int bugAnswerId) {
        this.bugAnswerId = bugAnswerId;
    }

    public BugAnswer(String answerInfo, String answerTime, int answerUserId, boolean isRight) {
        this.answerInfo = answerInfo;
        this.answerTime = answerTime;
        this.answerUserId = answerUserId;
        this.isRight = isRight;
    }

    public static BugAnswer  getBugAnswerTestOfInstance(){
        return new BugAnswer("_answerinfo","_answertime",2,false);
    }

    public int getBugAnswerId() {
        return bugAnswerId;
    }

    public void setBugAnswerId(int bugAnswerId) {
        this.bugAnswerId = bugAnswerId;
    }

    public String getAnswerInfo() {
        return answerInfo;
    }

    public void setAnswerInfo(String answerInfo) {
        this.answerInfo = answerInfo;
    }

    public String getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
    }

    public int getAnswerUserId() {
        return answerUserId;
    }

    public void setAnswerUserId(int answerUserId) {
        this.answerUserId = answerUserId;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean isRight) {
        this.isRight = isRight;
    }

    @Override
    public String toString() {
        return "BugAnswer{" +
                "bugAnswerId=" + bugAnswerId +
                ", answerInfo='" + answerInfo + '\'' +
                ", answerTime='" + answerTime + '\'' +
                ", answerUserId=" + answerUserId +
                ", isRight=" + isRight +
                '}';
    }
}
