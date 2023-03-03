package com.kuang;

import org.apache.logging.log4j.message.SimpleMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@SpringBootTest
class Springboot10MailtestApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //简单的邮件发送
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("2389407153@qq.com");
        message.setFrom("2389407153@qq.com");
        message.setSubject("测试邮件主题");
        message.setText("测试邮件正文");
        message.setSentDate(new Date());
        mailSender.send(message);
    }

    @Test
    void contextLoads2() throws MessagingException {
        //复杂的邮件发送
        //床架一个复杂的信息类
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //创建信息组装帮助类
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        //正文
        helper.setSubject("测试邮件主题 -p");
        helper.setText("<p style='color:red'>测试邮件正文</p>",true);
        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\luodo\\Desktop\\java\\微信截图_20200220213152.png"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\luodo\\Desktop\\java\\微信截图_20200220213152.png"));
        //目标
        helper.setTo("2389407153@qq.com");
        helper.setFrom("2389407153@qq.com");
        mailSender.send(mimeMessage);
    }

}
