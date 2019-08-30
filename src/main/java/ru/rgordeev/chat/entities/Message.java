package ru.rgordeev.chat.entities;

import javax.persistence.*;

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

    public Message() {
    }

    public Message(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format(
                "Message[id=%d, from='%s', to='%s', message='%s']",
                id, from, to, message);
    }

}
