package cn.qkmango.tms.mvc.common.service;

import org.springframework.mail.MailException;

import java.io.File;

/**
 * @author qkmango
 * @version 1.0
 * @className EmailService
 * @Description Email服务接口
 * @date 2022-08-02 14:52
 */
public interface EmailService {

    public void sendMessage(String to, String subject, String content) throws MailException;

    public void sendMessageCarryFiles(String to, String subject, String content, File[] files);

    public void sendMessageCarryFile(String to, String subject, String content, File file);
}
