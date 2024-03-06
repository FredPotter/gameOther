package ru.gorshkov.gameother.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="messageToSupport")
@Data
public class MessageToSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @Column(nullable = false)
    private String messageSubject;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private LocalDateTime messageDate;
}
