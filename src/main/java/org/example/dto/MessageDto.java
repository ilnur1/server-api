package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Component;

@Component
@With
@AllArgsConstructor
public class MessageDto {

    public MessageDto() {
    }

    private String message;
    private String type;
    private String level;

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public String getLevel() {
        return level;
    }
}
