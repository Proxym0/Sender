package com.example.sender.service;

import org.springframework.stereotype.Service;

public interface EmailSenderService {
    void sendEmail(String to, String message);
}