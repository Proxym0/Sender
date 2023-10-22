package com.example.sender.entity;

import lombok.*;
import org.springframework.stereotype.Component;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Component
public class Command {
    private Message message;
    private NotificationType type;
    private String destination;
}

