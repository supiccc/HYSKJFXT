package com.scau.hyskjf.service;

public interface EmailService {
    /**
     * 发送简单邮件
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleEmail(String to, String subject, String content);
}
