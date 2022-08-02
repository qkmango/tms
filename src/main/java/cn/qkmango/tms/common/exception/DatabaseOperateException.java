package cn.qkmango.tms.common.exception;

/**
 * @author qkmango
 * @version 1.0
 * @className DatabaseOperateException
 * @Description 数据库操作异常
 * @date 2022-08-02 17:52
 */
public class DatabaseOperateException extends Exception {
    public DatabaseOperateException() {
    }

    public DatabaseOperateException(String message) {
        super(message);
    }

    /**
     * 默认的模版
     * @param theory 理论影响行数
     * @param actual 实际影响行数
     */
    public DatabaseOperateException(int theory, int actual) {
        super("数据库查询异常，应影响行数:"+theory+"，实际影响行数:"+actual);
    }
}
