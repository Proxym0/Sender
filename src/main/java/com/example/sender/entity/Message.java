package com.example.sender.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Component
public class Message {
    private String external_id;
    private ZonedDateTime time;
    private String message;
}
