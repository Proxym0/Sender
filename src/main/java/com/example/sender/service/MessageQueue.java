package com.example.sender.service;

import com.example.sender.dto.CommandDto;
import com.example.sender.entity.Command;
import com.example.sender.entity.Message;
import com.example.sender.entity.NotificationType;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

@Service
public class MessageQueue {
    private PriorityBlockingQueue<Command> queue = new PriorityBlockingQueue<>(10, Comparator.comparing(s -> s.getMessage().getTime()));

    public boolean save(CommandDto commanddto) {
        Command command = toEntity(commanddto);
        return queue.add(command);

    }
    private static Command toEntity(CommandDto commandDto) {
        return Command.builder()
                .message(Message.builder()
                        .message(commandDto.getMessage())
                        .external_id(commandDto.getExternal_id())
                        .time(ZonedDateTime.parse(commandDto.getTime()))
                        .build())
                .destination(commandDto.getDestination())
                .type(NotificationType.valueOf(commandDto.getType()))
                .build();
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


