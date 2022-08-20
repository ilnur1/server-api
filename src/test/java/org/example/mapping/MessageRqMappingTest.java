package org.example.mapping;

import org.example.dto.MessageDto;
import org.example.entity.Message;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MessageRqMappingTest {

    private static final String MESSAGE = "message";
    private static final String TYPE = "type";
    private static final String LEVEL = "level";

    private MessageRqMappingImpl mapping = new MessageRqMappingImpl();

    @Test
    public void mapTest() {
        Message result = mapping.map(new MessageDto()
                .withMessage(MESSAGE)
                .withLevel(LEVEL)
                .withType(TYPE));

        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(MESSAGE, result.getMessage()),
                () -> assertEquals(LEVEL, result.getLevel()),
                () -> assertEquals(TYPE, result.getType()),
                () -> assertNotNull(result.getTime())
        );
    }
}
