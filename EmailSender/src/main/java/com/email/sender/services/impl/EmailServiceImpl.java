package com.email.sender.services.impl;

import com.email.sender.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    private Logger logger= LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public void sendEmail(String to, String subject, String message) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom("ashok.marketyard@gmail.com");

        mailSender.send(mailMessage);

        logger.info("Email has been send..");


    }

    @Override
    public void sendEmail(String[] to, String subject, String message) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom("ashok.marketyard@gmail.com");

        mailSender.send(mailMessage);

        logger.info("Email Sent to multiple emails...");

    }

    @Override
    public void sendEmailWithHtml(String to, String subject, String htmlContent) {

        MimeMessage mimeMessage = this.mailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom("ashok.marketyard@gmail.com");
            mimeMessageHelper.setText(htmlContent,true);

            this.mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void sendEmailWithFile(String to, String subject, String message, File file) {


        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
             mimeMessageHelper.setFrom("ashok.marketyard@gmail.com");
             mimeMessageHelper.setTo(to);
             mimeMessageHelper.setSubject(subject);
             mimeMessageHelper.setText(message);

            FileSystemResource fileSystemResource=new FileSystemResource(file);

            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),file);

            mailSender.send(mimeMessage);

            logger.info("Mail sent with attachment...");


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
