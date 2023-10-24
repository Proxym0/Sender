package com.example.sender.service;

import com.example.sender.entity.Command;
import com.example.sender.entity.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service

public class Timers {
    private Timer timer;
    @Autowired
    private MessageQueue messageQueue;
    @Autowired
    EmailSenderService sender;
    @Autowired
    private HttpSender client;

    @PostConstruct
    public void initTimer() {
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                List<Command> commands = messageQueue.get();
                for (Command s : commands) {
                    if (NotificationType.MAIL.equals(s.getType())) {
                        sender.sendEmail(s.getDestination(), s.getMessage().getMessage());
                    } else {
                        client.sendMessage(s);
                    }

                }
            }
        };
        timer = new Timer("Timer");
        timer.scheduleAtFixedRate(repeatedTask, 0, 1000L);
    }
    @PreDestroy
    public void finishTimer() {
        timer.cancel();
    }
}

