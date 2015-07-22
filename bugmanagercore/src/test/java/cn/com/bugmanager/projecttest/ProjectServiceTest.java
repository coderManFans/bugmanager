package cn.com.bugmanager.projecttest;

import cn.com.bugmanager.project.model.Project;
import cn.com.bugmanager.project.service.ProjectService;
import cn.com.bugmanager.testcase.SpringTransactionalTestCase;
import cn.com.bugmanager.util.CalendarUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

/**
 * Created by fan on 2015/7/8.
 */
@ContextConfiguration("/applicationContext-test.xml")
public class ProjectServiceTest extends SpringTransactionalTestCase {
    @Autowired
    private ProjectService projectService;

    public Project getProject(){
        Project project = new Project();
        project.setCreatetime(CalendarUtils.getDateTime());
        project.setLanguage("java");
        project.setIsprivate(false);
        project.setUserid(5);
        project.setUserList(null);
        project.setBugContentList(null);
        project.setProjectname("buginfocollection");
        project.setCreatebugcollection(false);
        return project;
    }


    @Test
    public void testAdd(){
        Project project = getProject();
        projectService.addProject(project);
        System.out.println(projectService.getProjectListSize());
    }

    @Sql("sql/TestAddProject.sql")
    @Test
    public void testGetList(){
        List<Project> projectList = projectService.getProjectList();
        System.out.println(projectList.size());
    }

    @Sql("sql/TestAddProject.sql")
    @Test
    public void testGetSize(){
        int size = projectService.getProjectListSize();
        System.out.println("size = "+size);
    }

}
