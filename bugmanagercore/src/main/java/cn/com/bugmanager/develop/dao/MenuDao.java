package cn.com.bugmanager.develop.dao;

import cn.com.bugmanager.develop.model.Menu;
import cn.com.bugmanager.mybatis.annotation.mybatisRepository;

import java.util.List;
import java.util.Map;

@mybatisRepository
public interface MenuDao {
    List<Menu> getMenuListByLevel(String level);

    List<Map<String, String>> getMenuTreeList();

    List<Menu> getMenuList();

    List<Menu> getMenuLeafList();

    Menu getMenu(String menuId);

    List<Menu> getSubMenuById(String menuId);

    int addMenu(Menu menu);

    int updateMenu(Menu menu);

    int deleteMenu(String menuId);

    int deleteMenuByParentId(String parentId);

    void updateMenuOrder(Menu menu);

    Menu getNewsMenu();

    List<Menu> getMenusByPermToken(String permToken);

}
