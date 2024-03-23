package org.mailsender.service;

import org.mailsender.pojo.Mail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Value("${spring.mail.username}")
    private String fromMail;
    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public boolean send(String toMail, Mail mail){
        var simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject(mail.subject());
        simpleMailMessage.setText(mail.mail());
        simpleMailMessage.setTo(toMail);

        mailSender.send(simpleMailMessage);

        return true;
    }
}
