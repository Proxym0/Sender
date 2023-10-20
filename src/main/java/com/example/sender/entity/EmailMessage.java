package com.example.sender.entity;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class EmailMessage {

    private String to;
    private String subject;
    private String message;
}
