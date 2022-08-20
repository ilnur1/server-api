package org.example.controller;

import org.example.dto.MessageDto;
import org.example.entity.Message;
import org.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private MessageService messageService;

    @Autowired
    public Controller(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("core-api")
    public ResponseEntity<Message> saveData(@RequestBody MessageDto message){
        return messageService.save(message);
    }
}
