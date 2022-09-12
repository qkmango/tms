package cn.qkmango.tms.domain.param;

import cn.qkmango.tms.domain.entity.User;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.StringJoiner;

/**
 * 找回密码 查询参数类
 *
 * @author qkmango
 * @version 1.0
 * @date 2022-08-02 20:54
 */
public class RetrievePasswordParam {

    @Valid
    private User user;
    /**
     * 验证码
     */
    @NotBlank
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
        return new StringJoiner(", ", RetrievePasswordParam.class.getSimpleName() + "[", "]")
                .add("user=" + user)
                .add("code='" + code + "'")
                .toString();
    }
}
