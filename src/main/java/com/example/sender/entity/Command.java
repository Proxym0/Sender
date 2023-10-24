package com.example.sender.entity;

import com.example.sender.controller.util.CustomerTypeSubset;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Component
public class Command {
    @Valid
    private Message message;

    //    @Pattern(regexp = "^(MAIL|HTTP)$")
    @Valid
    @CustomerTypeSubset(anyOf = {NotificationType.MAIL, NotificationType.HTTP})
    private NotificationType type;
    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String destination;
}

