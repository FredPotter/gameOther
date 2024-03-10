package ru.gorshkov.gameother.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name="user_blocking")
@Data
public class UserBlocking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_blocking_seq")
    @SequenceGenerator(name="user_blocking_seq", allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String reason;

    @Column(nullable = false)
    private LocalDateTime expirationDate;
}
