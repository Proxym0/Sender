package com.example.sender.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class CommandDto {
    @NotBlank
    @Pattern(regexp = "^(MAIL|HTTP)$", message = "введите MAIL или HTTP")
    private String type;
    @NotBlank
    @Pattern(regexp = "^((?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})|(http|https)://([\\w.-]+)\\.([a-zA-Z]{2,6})(:[0-9]{1,5})?(/[\\w.-]*)*/?)$",
            message = "must match email or URL format")
    private String destination;
    @NotBlank
    private String external_id;

    @NotBlank
    @Pattern(regexp ="^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}[+-]\\d{2}:\\d{2}$", message = "must match ZonedDateTime time format")
    private String time;
    @NotBlank
    private String message;

}
