package cn.qkmango.tms.common.enumerate;

/**
 * redis中的key
 *
 * @author qkmango
 * @version 1.0
 * @date 2022-08-19 12:32
 */
public enum RedisKey {

    /**
     * 找回密码验证码前缀
     */
    RETRIEVE_PASSWORD_CAPTCHA_PREFIX("RPC");

    public final String key;

    RedisKey(String key) {
        this.key = key;
    }

}
