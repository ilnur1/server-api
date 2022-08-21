package org.example.service;


import org.example.dao.MessageRepository;
import org.example.dto.MessageDto;
import org.example.entity.Message;
import org.example.mapping.MessageRqMapping;
import org.example.service.impl.MessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MessageServiceImplTest {

    private static final Long ID = 1L;
    private static final String MESSAGE = "message";
    private static final String TYPE = "type";
    private static final String LEVEL = "level";
    private static final OffsetDateTime TIME = OffsetDateTime.now();

    private MessageServiceImpl service;
    @Mock
    private MessageRepository repository;
    @Mock
    private MessageRqMapping mapping;

    @BeforeEach
    void before() {
        service = new MessageServiceImpl(repository, mapping);
    }

    @Test
    public void saveTest_OK() {
        Message message = new Message()
                .withId(ID)
                .withMessage(MESSAGE)
                .withLevel(LEVEL)
                .withTime(TIME)
                .withType(TYPE);

        when(repository.save(any())).thenReturn(message);
        ResponseEntity<Message> response = service.save(new MessageDto()
                .withMessage(MESSAGE)
                .withLevel(LEVEL)
                .withType(TYPE));

        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody()),
                () -> assertEquals(MESSAGE, response.getBody().getMessage()),
                () -> assertEquals(LEVEL, response.getBody().getLevel()),
                () -> assertEquals(TYPE, response.getBody().getType()),
                () -> assertEquals(TIME, response.getBody().getTime())
        );


    }

    @Test
    public void saveTest_Fail() {
        when(repository.save(any())).thenThrow(new RuntimeException());
        ResponseEntity<Message> response = service.save(new MessageDto()
                .withMessage(MESSAGE)
                .withLevel(LEVEL)
                .withType(TYPE));
        assertAll(
                () -> assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode()),
                () -> assertNull(response.getBody())
        );
    }
}
