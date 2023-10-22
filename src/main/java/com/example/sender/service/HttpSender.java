package com.example.sender.service;

import com.example.sender.entity.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpSender {
    @Autowired
    private RestTemplate restTemplate;

    public void sendMessage(Command command) {
        HttpEntity<Command> request = new HttpEntity<>(command);
        String s = restTemplate.postForObject(command.getDestination(), request, String.class);
        System.out.println("Http message sent" + s);
    }
}
