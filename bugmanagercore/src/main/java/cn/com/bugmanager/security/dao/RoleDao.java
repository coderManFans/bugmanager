package cn.com.bugmanager.security.dao;


import cn.com.bugmanager.mybatis.annotation.mybatisRepository;
import cn.com.bugmanager.security.model.Role;
import cn.com.bugmanager.security.model.User;

import java.util.List;

@mybatisRepository
public interface RoleDao {

    List<String> getUsernameByRoleId(String roleId);

    List<User> getUserByRoleId(String roleId);

    List<Role> getRolesByUsername(String username);

    List<String> getRolePermTokensByUsername(String username);

    List<Role> getRoleList();

    List<Role> getRoleListPage(Role role);

    int addRole(Role role);

    Role getRoleByRoleName(String roleName);

    int addUserRole(Role role);

    int addRolePermission(Role role);

    int deleteUserRoleByRoleId(String roleId);

    int deleteRolePermissionByRoleId(String loginName);

    int deleteRole(String roleId);

    Role getRole(String roleId);

    int updateRole(Role role);

    List<String> getRoleNameByPermissionToken(String permissionToken);

}
