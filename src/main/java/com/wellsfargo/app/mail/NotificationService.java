package com.wellsfargo.app.mail;

import com.wellsfargo.app.model.EmailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Properties;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailProperties emailProperties;

    // TODO need to changes as per requirement the body and subject
    public void sendErrorNotification(File file, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(emailProperties.getToEmails().toArray(new String[]{}));
        mailMessage.setCc(emailProperties.getCcEmails().toArray(new String[]{}));
        mailMessage.setBcc(emailProperties.getBccEmails().toArray(new String[]{}));
        mailMessage.setSubject(emailProperties.getSubjectTemplate());
        mailMessage.setText(emailProperties.getBodyTemplate());
        mailMessage.setFrom(emailProperties.getFromEmail());
        mailSender.send(mailMessage);
    }
}
