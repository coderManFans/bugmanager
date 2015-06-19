package cn.com.bugmanager.develop.dao;

import cn.com.bugmanager.develop.model.Permission;
import cn.com.bugmanager.develop.model.PermissionTreeNode;
import cn.com.bugmanager.mybatis.annotation.mybatisRepository;

import java.util.List;

/**
 * Created by threegrand2 on 15-6-18.
 */
@mybatisRepository
public interface PermissionDao {
    List<PermissionTreeNode>  getPermissionTree();

    List<Permission> getPermissionListPage(Permission permission);

    Permission getPermissionByPermToken(String permToken);

    Permission getPermissionByDescription(String description);

    int addPermission(Permission permission);

    int deletePermission(String permToken);

    int deleteRolePermissionByPermToken(String permToken);

    int deletePermissionByParentId(String parentId);

    List<PermissionTreeNode> getPermissionTreeByRoleName(String roleId);

    int updatePermission(Permission permission);

    int updateRolePermissionPermToken(String oldPermToken, String newPermToken);

    int updatePermissionByChangePermToken(String oldPermToken, String newPermissionToken);

    int getPermissionUsedByMenu(String permToken);


}
