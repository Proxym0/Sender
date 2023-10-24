package com.example.sender.controller.util;


import com.example.sender.entity.NotificationType;

import javax.validation.ConstraintValidator;

import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class CustomerTypeSubSetValidator implements ConstraintValidator<CustomerTypeSubset, NotificationType> {
    private NotificationType[] subset;

    @Override
    public void initialize(CustomerTypeSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(NotificationType value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
