package com.lookthings.core.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * Created by Fantasy on 2018/5/24.
 *
 * @author Fantasy
 */
public final class EmailUtils {

    private final static String EMAIL_HOST = "smtp.qq.com";
    private final static String FROM_EMAIL = "805841483@qq.com";
    private final static String EMAIL_PASSWORD = "dcrthodqoywsbbib";

    public static String emailUrl = "";

    public static String subjectTitle = "";

    public static String subjectContent = "";

    /**
     * Sets prop.
     *
     * @return the prop
     */
    private static Properties setProp() {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", EMAIL_HOST);
        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        return properties;
    }

    private static Session createdEmailSession() {
        Properties properties = setProp();
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名、密码
                return new PasswordAuthentication(FROM_EMAIL, EMAIL_PASSWORD);
            }
        });
        return session;
    }

    public static Boolean sendEmail() {
        Boolean isSendStatus;
        Session session = createdEmailSession();
        MimeMessage message = new MimeMessage(session);
        try {
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(FROM_EMAIL));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailUrl));
            // Set Subject: 头部头字段
            message.setSubject(subjectTitle);
            // 设置消息体
            message.setText(subjectContent);
            // 发送消息
            Transport.send(message);
            isSendStatus = true;
        } catch (MessagingException e) {
            e.printStackTrace();
            isSendStatus = false;
        }
        return isSendStatus;
    }


}
