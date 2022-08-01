package cn.qkmango.tms.common.exception;

public class DeleteException extends Exception{
    public DeleteException() {
    }

    public DeleteException(String message) {
        super(message);
    }

    /**
     * 默认的模版
     * @param theory 理论影响行数
     * @param actual 实际影响行数
     */
    public DeleteException(int theory, int actual) {
        super("删除记录异常，应影响行数:"+theory+"，实际影响行数:"+actual);
    }
}
