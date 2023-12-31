package com.example.sender.service.impl;

import com.example.sender.service.EmailSenderService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender mailSender;

    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String to, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("vlad-13@list.ru");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("notification");
        simpleMailMessage.setText(message);
        this.mailSender.send(simpleMailMessage);
    }
}
