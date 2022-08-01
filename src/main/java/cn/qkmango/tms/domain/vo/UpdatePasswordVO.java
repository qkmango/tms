package cn.qkmango.tms.domain.vo;

import cn.qkmango.tms.domain.bind.PermissionType;

/**
 * @className: UpdatePasswordVO
 * @Description:TODO
 * @author: qkmango
 * @date: 2021-07-23 17:20
 * @version: 1.0
 */
public class UpdatePasswordVO {
    private String oldPassword;
    private String newPassword;
    private Integer id;
    private PermissionType permissionType;

    public UpdatePasswordVO() {
    }

    public UpdatePasswordVO(String oldPassword, String newPassword, Integer id, PermissionType permissionType) {
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
        return "UpdatePasswordVO{" +
                "oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", id=" + id +
                ", permissionType=" + permissionType +
                '}';
    }
}
