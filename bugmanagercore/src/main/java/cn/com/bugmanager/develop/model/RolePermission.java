package cn.com.bugmanager.develop.model;

/**
 * Created by threegrand2 on 15-6-18.
 */
public class RolePermission {
    private String roleName;
    private String permToken;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermToken() {
        return permToken;
    }

    public void setPermToken(String permToken) {
        this.permToken = permToken;
    }
}
