package cn.qkmango.tms.domain.query;

import cn.qkmango.tms.domain.orm.User;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.StringJoiner;

/**
 * @author qkmango
 * @version 1.0
 * @className RetrievePasswordQuery
 * @Description 找回密码 查询参数类
 * @date 2022-08-02 20:54
 */
public class RetrievePasswordQuery {

    @Valid
    private User user;
    //验证码
    @NotBlank(message = "{}")
    private String code;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RetrievePasswordQuery.class.getSimpleName() + "[", "]")
                .add("user=" + user)
                .add("code='" + code + "'")
                .toString();
    }
}
