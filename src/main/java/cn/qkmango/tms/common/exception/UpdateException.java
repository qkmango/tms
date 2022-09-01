package cn.qkmango.tms.common.exception;

/**
 * 更新异常
 * @author qkmagno
 */
public class UpdateException extends Exception{
    public UpdateException() {
        super("更新信息失败");
    }

    public UpdateException(String message) {
        super(message);
    }
}
