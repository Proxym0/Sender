package com.example.sender.controller;

import com.example.sender.entity.Command;
import com.example.sender.entity.NotificationType;
import com.example.sender.service.EmailSenderService;
import com.example.sender.service.MessageQueue;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor
//@RequestMapping()
public class EmailController {
    @Autowired
    private MessageQueue queue;

    @PostMapping("/save-email")
    public ResponseEntity saveEmail(@RequestBody Command command){
        queue.save(command);
        return ResponseEntity.ok("Success");
    }
}

