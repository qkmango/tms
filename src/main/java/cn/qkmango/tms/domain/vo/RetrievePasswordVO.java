package cn.qkmango.tms.domain.vo;

import cn.qkmango.tms.domain.orm.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.StringJoiner;

/**
 * @author qkmango
 * @version 1.0
 * @className RetrievePasswordVO
 * @Description 找回密码VO
 * @date 2022-08-02 20:54
 */
public class RetrievePasswordVO {

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
        return new StringJoiner(", ", RetrievePasswordVO.class.getSimpleName() + "[", "]")
                .add("user=" + user)
                .add("code='" + code + "'")
                .toString();
    }
}
