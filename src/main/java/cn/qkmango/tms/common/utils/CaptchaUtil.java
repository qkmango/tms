package cn.qkmango.tms.common.utils;

import java.util.Random;

/**
 * 验证码工具类
 *
 * @author qkmango
 * @version 1.0
 * @date 2022-08-02 15:50
 */
public class CaptchaUtil {

    private static final Random random = new Random();

    /**
     * 验证码所用的字符集
     */
    private static final char[] codes = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'J', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    /**
     * 获取验证码
     *
     * @return
     */
    public static String getCode() {
        char[] chars = new char[5];
        for (int i = 0; i < 5; i++) {
            chars[i] = codes[random.nextInt(codes.length)];
        }
        return new String(chars);
    }
}
