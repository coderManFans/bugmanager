package cn.com.bugmanager.security.service;

import cn.com.bugmanager.constant.Constant;
import cn.com.bugmanager.security.dao.RoleDao;
import cn.com.bugmanager.security.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fcs on 2015/3/21.
 */
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;
    public  boolean addRole(Role role){
        int affectNum = roleDao.addRole(role);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }

    public boolean updateRole(Role role){
        int affectNum = roleDao.updateRole(role);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }

    public boolean deleteRoleById(int roleId){
        int affectNum = roleDao.deleteRoleById(roleId);
        return Constant.AFFECTED_LINE_1 == affectNum;
    }
}
