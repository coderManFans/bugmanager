package cn.com.bugmanger.bugcontent.model;

/**
 * Created by fcs on 2015/3/21.
 */
public class BugAnswer {
    private int bugAnswerId;
    private String answerInfo;
    private String answerTime;
    private int answerUserId;

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
}
