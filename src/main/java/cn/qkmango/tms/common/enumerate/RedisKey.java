package cn.qkmango.tms.common.enumerate;

/**
 * @author qkmango
 * @version 1.0
 * @className RedisKey
 * @Description redis中的key
 * @date 2022-08-19 12:32
 */
public enum RedisKey {

    /**
     *
     */
    RETRIEVE_PASSWORD_CAPTCHA_PREFIX("RPC");

    public final String key;

    RedisKey(String key) {
        this.key = key;
    }

}
