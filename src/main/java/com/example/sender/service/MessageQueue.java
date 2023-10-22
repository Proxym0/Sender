package com.example.sender.service;

import com.example.sender.entity.Command;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

@Service
public class MessageQueue {
    private PriorityBlockingQueue<Command> queue = new PriorityBlockingQueue<>(10, Comparator.comparing(s -> s.getMessage().getTime()));

    public boolean save(Command command) {
        return queue.add(command);

    }

    public List<Command> get() {
        List<Command> get = new ArrayList<>();
        ZonedDateTime now = ZonedDateTime.now();

        while (!queue.isEmpty() && now.isAfter(queue.peek().getMessage().getTime())) {
            Command poll = queue.poll();
            get.add(poll);
        }
        return get;
    }
}


