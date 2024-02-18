package com.teamchallenge.chat.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Messages {

    @Id
    @Column(name = "id_message")
    private int idMessage;

    @Column(name = "text_Message")
    private String textMessage;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @Column(name = "date")
    private String date;
}
