package org.example.service.impl;

import lombok.extern.log4j.Log4j2;
import org.example.dao.MessageRepository;
import org.example.dto.MessageDto;
import org.example.entity.Message;
import org.example.mapping.MessageRqMapping;
import org.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MessageServiceImpl implements MessageService {

    private MessageRepository repository;
    private MessageRqMapping mapping;

    @Autowired
    public MessageServiceImpl(MessageRepository repository, MessageRqMapping mapping) {
        this.repository = repository;
        this.mapping = mapping;
    }

    @Override
    public ResponseEntity<Message> save(MessageDto message) {
        try {
            ResponseEntity<Message> response = new ResponseEntity<>(repository.save(mapping.map(message)), HttpStatus.OK);
            log.info("Сообщение сохранено: " + response.getBody());
            return response;
        }
        catch (Exception e){
            log.error("Ошибка при попытке сохранения сообщения: " + e.getStackTrace());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
