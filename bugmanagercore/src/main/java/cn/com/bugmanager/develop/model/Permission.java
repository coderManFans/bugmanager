package cn.com.bugmanager.develop.model;

import cn.com.bugmanager.common.ajax.DataTablesPage;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by threegrand2 on 15-6-18.
 */

public class Permission extends DataTablesPage {
    @NotBlank(message = "权限标示不能为空")
    private String permToken;

    @NotBlank(message = "权限描述不能为空")
    private String description;

    private String parentId;

    public String getPermToken() {
        return permToken;
    }

    public void setPermToken(String permToken) {
        this.permToken = permToken;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permToken='" + permToken + '\'' +
                ", description='" + description + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
