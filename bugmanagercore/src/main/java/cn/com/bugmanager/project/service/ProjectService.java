package cn.com.bugmanager.project.service;

import cn.com.bugmanager.project.dao.ProjectDao;
import cn.com.bugmanager.project.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fan on 2015/7/8.
 */
@Service("projectService")
public class ProjectService {
    @Autowired
    private ProjectDao projectDao;

    public int addProject(Project project){
        return    projectDao.addProject(project);
    }

    public int updateProject(Project project){
        return    projectDao.updateProject(project);
    }

    public int deleteProject(int projectId){
        return    projectDao.deleteProjectById(projectId);
    }


    public List<Project> getProjectList(){
        return projectDao.getProjectList();
    }

    public int getProjectListSize(){
        return projectDao.getProjectListSize();
    }




}
