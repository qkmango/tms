package cn.qkmango.tms.common.exception;

/**
 * 当年龄有问题时抛出异常
 */
public class SystemException extends Exception{
    public SystemException() {
        super();
    }

    public SystemException(String message) {
        super(message);
    }
}
