package com.example.sender.entity;

import javax.validation.constraints.Pattern;

@Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$")
public enum NotificationType {
    MAIL, HTTP
}
