package com.api.ticket.Apiticket.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;
    public void sendSimpleMail(String mail, String Message) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(mail);
            helper.setSubject("Titre de mail");
            helper.setSubject("nouvel notification");
            helper.setText(Message, true);
            mailSender.send(mimeMessage);
        }catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
