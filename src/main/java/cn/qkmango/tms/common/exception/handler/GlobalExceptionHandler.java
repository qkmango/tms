package cn.qkmango.tms.common.exception.handler;

import cn.qkmango.tms.common.exception.*;
import cn.qkmango.tms.common.map.ResponseMap;
import org.apache.log4j.Logger;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.Map;


/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    // SQLException
    @ResponseBody
    @ExceptionHandler
    public Map<String, Object> SQLExceptionHandler(SQLException e) {
        ResponseMap map = new ResponseMap(2);
        e.printStackTrace();
        logger.warn(e.getMessage());
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

    //处理 登陆 的异常
    @ResponseBody
    @ExceptionHandler
    public Map<String, Object> loginExceptionHandler(LoginException e) {
        logger.warn(e.getMessage());
        ResponseMap map = new ResponseMap(2);
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

    //处理 系统 的异常
    @ResponseBody
    @ExceptionHandler
    public Map<String, Object> systemExceptionHandler(SystemException e) {
        logger.warn(e.getMessage());
        ResponseMap map = new ResponseMap(2);
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

    //处理 用户权限 的异常
    @ResponseBody
    @ExceptionHandler
    public Map<String, Object> permissionExceptionHandler(PermissionException e) {
        logger.warn(e.getMessage());
        ResponseMap map = new ResponseMap(2);
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

    //处理 更新数据 的异常
    @ResponseBody
    @ExceptionHandler
    public Map<String, Object> updateExceptionHandler(UpdateException e) {
        logger.warn(e.getMessage());
        ResponseMap map = new ResponseMap(2);
        map.setSuccess(false);
        map.setMessage("更新数据失败");
        return map;
    }

    //处理 插入数据 的异常
    @ResponseBody
    @ExceptionHandler
    public Map<String, Object> insertExceptionHandler(InsertException e) {
        logger.warn(e.getMessage());
        ResponseMap map = new ResponseMap(2);
        map.setSuccess(false);
        map.setMessage("插入数据失败");
        return map;
    }

    //处理 删除数据 的异常
    @ResponseBody
    @ExceptionHandler
    public Map<String, Object> deleteExceptionHandler(DeleteException e) {
        logger.warn(e.getMessage());
        e.printStackTrace();
        ResponseMap map = new ResponseMap(2);
        map.setSuccess(false);
        map.setMessage("删除数据失败");
        return map;
    }

    //处理 请求参数 的异常
    @ResponseBody
    @ExceptionHandler
    public Map<String, Object> paramVerifyErrorHandler(ParamVerifyException e) {
        logger.warn(e.getMessage());
        ResponseMap map = new ResponseMap(2);
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

    //处理 邮件发送 的异常
    @ResponseBody
    @ExceptionHandler
    public Map<String, Object> MailExceptionHandler(MailException e) {
        logger.warn(e.getMessage());
        ResponseMap map = new ResponseMap(2);
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

    //处理 DatabaseOperateException
    @ResponseBody
    @ExceptionHandler
    public Map<String, Object> DatabaseOperateExceptionHandler(DatabaseOperateException e) {
        logger.warn(e.getMessage());
        ResponseMap map = new ResponseMap(2);
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

    @ResponseBody
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Map<String, Object> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        System.out.println(e);
        System.out.println(e.getLocalizedMessage());
        logger.warn(e.getMessage());
        ResponseMap map = new ResponseMap(2);
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

}
