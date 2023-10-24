package com.example.sender.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @NotEmpty
    @NotBlank
    @NotNull
    private String external_id;

    private ZonedDateTime time;
    @NotEmpty
    @NotBlank
    @NotNull
    private String message;
}
