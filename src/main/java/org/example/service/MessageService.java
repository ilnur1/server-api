package org.example.service;

import org.example.dto.MessageDto;
import org.example.entity.Message;
import org.springframework.http.ResponseEntity;

public interface MessageService {

    ResponseEntity<Message> save(MessageDto message);
}
