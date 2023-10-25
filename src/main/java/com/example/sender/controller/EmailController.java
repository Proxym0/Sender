package com.example.sender.controller;

import com.example.sender.dto.CommandDto;
import com.example.sender.service.MessageQueue;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class EmailController {
    @Autowired
    private MessageQueue queue;

    @PostMapping("/save-email")
    public ResponseEntity saveEmail(@RequestBody @Valid CommandDto commandDto){
        queue.save(commandDto);
        return ResponseEntity.ok("Success");
    }
}

