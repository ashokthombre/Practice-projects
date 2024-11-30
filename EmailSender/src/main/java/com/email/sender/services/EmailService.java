package com.email.sender.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public interface EmailService {

    //send email to single person
    public void sendEmail(String to,String subject,String message);

    // send email to multiple person
    public void sendEmail(String[]to,String subject,String message);

    //send email withHTML
    public void sendEmailWithHtml(String to,String subject,String htmlContent);

    //send email with file

    public void sendEmailWithFile(String to, String subject, String message, File file);



}
