package cn.com.bugmanager.develop.service;

import cn.com.bugmanager.constant.Constant;
import cn.com.bugmanager.develop.dao.MenuDao;
import cn.com.bugmanager.develop.dao.PermissionDao;
import cn.com.bugmanager.develop.model.Menu;
import cn.com.bugmanager.develop.model.Permission;
import cn.com.bugmanager.exception.ValidateErrorException;
import cn.com.bugmanager.security.dao.RoleDao;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("menuService")
public class MenuService {

    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RoleDao roleDao;

    @PostConstruct
    public void initMenuInContext() {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        if (webApplicationContext != null) {
            List<Menu> list = menuDao.getMenuList();
            Map<String, Menu> menuMap = new HashMap<String, Menu>();
            for (Menu menu : list) {
                menuMap.put(menu.getMenuId(), menu);
            }
            webApplicationContext.getServletContext().setAttribute("menuMap", menuMap);
        }
    }

    public void updateMenuOrder(List<Menu> menuList) {
        for (Menu menu : menuList) {
            //做这个更改的同时，如果permission中有记录，那么应当更改parentId
            menuDao.updateMenuOrder(menu);
        }
    }

    public void updateMenuInHttpSession(HttpServletRequest request) {
        HttpSession session = request.getSession();

        List<Menu> level0List = new ArrayList<Menu>();
        Subject currentUser = SecurityUtils.getSubject();
        for (Menu menu : menuDao.getMenuListByLevel("0")) {
            if (StringUtils.isBlank(menu.getPermToken()) || currentUser.isPermitted(menu.getPermToken())) {
                level0List.add(menuUrlHandle(menu));
            }
        }

        List<Menu> level1List = menuDao.getMenuListByLevel("1");
        Map<String, List<Menu>> level1Map = groupMenuList(level1List);

        List<Menu> level2List = menuDao.getMenuListByLevel("2");
        Map<String, List<Menu>> level2Map = groupMenuList(level2List);

        session.setAttribute("level0List", level0List);
        session.setAttribute("level1Map", level1Map);
        session.setAttribute("level2Map", level2Map);
    }

    private Map<String, List<Menu>> groupMenuList(List<Menu> menuList) {
        Subject currentUser = SecurityUtils.getSubject();
        Map<String, List<Menu>> map = new HashMap<String, List<Menu>>();
        for (Menu menu : menuList) {
            if (!map.containsKey(menu.getParentId())) {
                map.put(menu.getParentId(), new ArrayList<Menu>());
            }
            if ("".equals(menu.getPermToken()) || currentUser.isPermitted(menu.getPermToken())) {
                map.get(menu.getParentId()).add(menuUrlHandle(menu));
            }
        }
        return map;
    }

    private Menu menuUrlHandle(Menu menu) {
        String url = menu.getUrl();
        menu.setUrl(url + (url.contains("?") ? "&" : "?") + "menuId=" + menu.getMenuId());
        return menu;
    }


    public List<Map<String, String>> getMenuTreeList() {
        return menuDao.getMenuTreeList();
    }


    public Menu getMenu(String menuId) {
        return menuDao.getMenu(menuId);
    }


    public boolean addMenu(Menu menu) {
        validateMenu(menu);
        addPermissionByMenu(menu);
        return menuDao.addMenu(menu) == Constant.AFFECTED_LINE_1;
    }

    private void addPermissionByMenu(Menu menu) {
        if (menu.isLeaf() && permissionDao.getPermissionByPermToken(menu.getPermToken()) == null) {
            Permission permission = new Permission();
            permission.setPermToken(menu.getPermToken());
            permission.setParentId(menu.getParentId());
            permission.setDescription(menu.getMenuName());
            permissionDao.addPermission(permission);
        }
    }

    public boolean updateMenu(Menu menu) {
        validateMenu(menu);
        Menu originalMenu = getMenu(menu.getMenuId());
        validatePermissionTokenChange(originalMenu, menu);
        validateSubMenu(originalMenu, menu);

        permissionDao.deletePermission(originalMenu.getPermToken());
        addPermissionByMenu(menu);

        return menuDao.updateMenu(menu) == Constant.AFFECTED_LINE_1;
    }

    private void validateSubMenu(Menu originalMenu, Menu menu) {
        if (!originalMenu.isLeaf() && menu.isLeaf()) {
            List<Menu> subMenuList = menuDao.getSubMenuById(originalMenu.getMenuId());
            if (!subMenuList.isEmpty()) {
                throw new ValidateErrorException("该菜单下有子菜单，无法改为子菜单！");
            }
        }
    }

    private void validatePermissionTokenChange(Menu originalMenu, Menu newMenu) {
        if (!originalMenu.getPermToken().equals(newMenu.getPermToken())) {
            List<String> roleNameList = roleDao.getRoleNameByPermissionToken(originalMenu.getPermToken());
            if (!roleNameList.isEmpty()) {
                throw new ValidateErrorException("该菜单已被角色" + roleNameList + "使用,不能更改许可！");
            }
        }
    }

    public boolean deleteMenu(String menuId) {
        Menu menu = getMenu(menuId);
        if (!menu.isLeaf() && !menuDao.getSubMenuById(menu.getMenuId()).isEmpty()) {
            throw new ValidateErrorException("该菜单下有子菜单，无法删除！");
        }
        permissionDao.deletePermission(menu.getPermToken());
        permissionDao.deleteRolePermissionByPermToken(menu.getPermToken());

        return menuDao.deleteMenu(menuId) == Constant.AFFECTED_LINE_1;
    }


    private void validateMenu(Menu menu) {
        if (menu.isLeaf() && "".equals(menu.getPermToken())) {
            throw new ValidateErrorException("权限许可不能为空！");
        }
    }

    public List<Menu> getMenuLeafList() {
        return menuDao.getMenuLeafList();
    }
}
