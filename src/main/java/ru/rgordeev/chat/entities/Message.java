package ru.rgordeev.chat.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.StringJoiner;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(
            generator = "msg_sequence",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "msg_sequence",
            allocationSize = 10
    )
    private Integer id;
    @Column(name = "sender")
    private String from;
    @Column(name = "recipient")
    private String to;
    private String message;

    public Message(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Message.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("from='" + from + "'")
                .add("to='" + to + "'")
                .add("message='" + message + "'")
                .toString();
    }
}
