package cn.com.bugmanager.develop.service;


import cn.com.bugmanager.constant.Constant;
import cn.com.bugmanager.develop.dao.PermissionDao;
import cn.com.bugmanager.develop.model.Permission;
import cn.com.bugmanager.develop.model.PermissionTreeNode;
import cn.com.bugmanager.exception.ValidateErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("permissionService")
public class PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    public List<PermissionTreeNode> getPermissionTree() {
        return permissionDao.getPermissionTree();
    }

    public List<Permission> getPermissionListPage(Permission permission) {
        return permissionDao.getPermissionListPage(permission);
    }

    public boolean addPermission(Permission permission) {
        if (permissionDao.getPermissionByPermToken(permission.getPermToken()) != null) {
            throw new ValidateErrorException("权限已存在！");
        }
        if (permissionDao.getPermissionByDescription(permission.getDescription()) != null) {
            throw new ValidateErrorException("权限描述已存在！");
        }
        return permissionDao.addPermission(permission) == Constant.AFFECTED_LINE_1;
    }


    public boolean deletePermission(String permToken) {
        return permissionDao.deletePermission(permToken) == Constant.AFFECTED_LINE_1;
    }


    public List<PermissionTreeNode> getPermissionTreeByRoleName(String roleId) {
        return permissionDao.getPermissionTreeByRoleName(roleId);
    }


    public Permission getPermissionByPermToken(String permToken) {
        return permissionDao.getPermissionByPermToken(permToken);
    }


    public boolean updatePermission(Permission permission) {
        return permissionDao.updatePermission(permission) == Constant.AFFECTED_LINE_1;
    }


    public boolean getPermissionUsedByMenu(String permToken) {
        return permissionDao.getPermissionUsedByMenu(permToken) > Constant.ZERO;
    }

}
