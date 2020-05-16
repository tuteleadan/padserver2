package com.proiectpad2.service;

import com.proiectpad2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class NotificationService {
    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender)
    {
        this.javaMailSender=javaMailSender;
    }

    public void sendNotification(User user) throws MailException {
        //send email
        SimpleMailMessage mail=new SimpleMailMessage();
        mail.setTo(user.getEmailAddress());
        mail.setFrom("projectpad001@gmail.com");
        mail.setSubject(user.getSubiect());
        mail.setText(user.getText());

        javaMailSender.send(mail);
    }

    public void sendHtmlNotification(User user) throws MailException, MessagingException {
        //send email
        //SimpleMailMessage mail=new SimpleMailMessage();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mail =
                new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mail.setTo(user.getEmailAddress());
        mail.setFrom("projectpad001@gmail.com");
        mail.setSubject(user.getSubiect());
        mail.setText(user.getText(),true);

        javaMailSender.send(mimeMessage);
    }
}
