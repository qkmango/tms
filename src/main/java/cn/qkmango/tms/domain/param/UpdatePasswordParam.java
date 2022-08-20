package cn.qkmango.tms.domain.param;

import cn.qkmango.tms.domain.bind.PermissionType;

/**
 * @className: UpdatePasswordParam
 * @Description: 更新密码查询参数类
 * @author: qkmango
 * @date: 2021-07-23 17:20
 * @version: 1.0
 */
public class UpdatePasswordParam {
    private String oldPassword;
    private String newPassword;
    private Integer id;
    private PermissionType permissionType;

    public UpdatePasswordParam() {
    }

    public UpdatePasswordParam(String oldPassword, String newPassword, Integer id, PermissionType permissionType) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.id = id;
        this.permissionType = permissionType;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PermissionType getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(PermissionType permissionType) {
        this.permissionType = permissionType;
    }

    @Override
    public String toString() {
        return "UpdatePasswordParam{" +
                "oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", id=" + id +
                ", permissionType=" + permissionType +
                '}';
    }
}
