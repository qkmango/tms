package cn.qkmango.tms.domain.entity;

import cn.qkmango.tms.common.validate.group.Query.login;
import cn.qkmango.tms.common.validate.group.Sys;
import cn.qkmango.tms.common.validate.group.Update;
import cn.qkmango.tms.domain.bind.PermissionType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.StringJoiner;

/**
 * 用户
 *
 * @author qkmango
 */
public class User implements Serializable {
    @NotNull(groups = {login.class, Sys.RetrievePasswordCaptcha.class})
    protected Integer id;

    @NotNull(groups = login.class)
    protected String password;

    protected String name;

    @NotBlank(groups = {Update.UpdateUserBasicInfo.class, Sys.RetrievePasswordCaptcha.class})
    @Email(message = "不是Email地址", groups = {Update.UpdateUserBasicInfo.class, Sys.RetrievePasswordCaptcha.class})
    private String email;

    @NotNull(groups = {login.class, Sys.RetrievePasswordCaptcha.class})
    protected PermissionType permissionType;

    public User() {
    }

    public User(Integer id, String password, String name, String email, PermissionType permissionType) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.permissionType = permissionType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PermissionType getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(PermissionType permissionType) {
        this.permissionType = permissionType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("password='" + password + "'")
                .add("name='" + name + "'")
                .add("email='" + email + "'")
                .add("permissionType=" + permissionType)
                .toString();
    }
}
