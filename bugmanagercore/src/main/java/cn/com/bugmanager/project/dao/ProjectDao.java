package cn.com.bugmanager.project.dao;

import cn.com.bugmanager.mybatis.annotation.mybatisRepository;
import cn.com.bugmanager.project.model.Project;

import java.util.List;

/**
 * Created by fan on 2015/7/7.
 */
@mybatisRepository
public interface ProjectDao {
    int addProject(Project project);
    int updateProject(Project project);
    int deleteProjectById(int projectId);
    Project getProjectById(int projectId);
    List<Project> getProjectListPage(Project project);
    List<Project> getProjectList();
    int getProjectListSize();

}
