package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Data
@Table(name = "message", schema = "public")
@With
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "message")
    private String message;
    @Column(name = "type")
    private String type;
    @Column(name = "level")
    private String level;
    @Column(name = "time")
    private OffsetDateTime time;

    public Message() {

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setTime(OffsetDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", time=" + time +
                '}';
    }
}
