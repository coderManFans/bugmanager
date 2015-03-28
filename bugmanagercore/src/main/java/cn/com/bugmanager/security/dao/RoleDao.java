package cn.com.bugmanager.security.dao;

import cn.com.bugmanager.mybatis.annotation.mybatisRepository;
import cn.com.bugmanager.security.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * Created by fcs on 2015/3/21.
 */
@mybatisRepository
public interface RoleDao {
    int addRole(@Param("role") Role role);
    int updateRole(@Param("role") Role role);
    List<Role>  getRoleList();
    int deleteRoleById(@Param("roleId") int roleId);

}
