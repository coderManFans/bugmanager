package cn.com.bugmanager.project.model;

import cn.com.bugmanager.bugcontent.model.BugContent;
import cn.com.bugmanager.common.ajax.DataTablesPage;
import cn.com.bugmanager.security.model.User;

import java.util.List;

/**
 * Created by fan on 2015/7/4.
 */
public class Project extends DataTablesPage {
    private int projectid;
    private String projectname;    //项目名称
    private String language;       //使用语言
    private String createtime;     //创建时间
    private int  userid;           //作者
    private boolean isprivate;     //是否是私人项目
    private boolean createbugcollection;   //是否开启错误收录仓库
    private List<User> userList;    //项目成员
    private List<BugContent> bugContentList;

    public Project() {
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public boolean isprivate() {
        return isprivate;
    }

    public void setIsprivate(boolean isprivate) {
        this.isprivate = isprivate;
    }

    public boolean isCreatebugcollection() {
        return createbugcollection;
    }

    public void setCreatebugcollection(boolean createbugcollection) {
        this.createbugcollection = createbugcollection;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<BugContent> getBugContentList() {
        return bugContentList;
    }

    public void setBugContentList(List<BugContent> bugContentList) {
        this.bugContentList = bugContentList;
    }
}
