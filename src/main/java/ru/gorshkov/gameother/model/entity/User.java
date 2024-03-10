package ru.gorshkov.gameother.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import ru.gorshkov.gameother.enums.AccountStatus;
import ru.gorshkov.gameother.enums.UserStatus;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name="users_seq", allocationSize=1)
    private Long id;

    @Column(nullable = false)
    private UserStatus userStatus;

    @Column(nullable = false)
    private String login;

    @Column
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @Column
    private Long balance;

    @Column(nullable = false)
    private AccountStatus accountStatus;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column
    private String pathToAvatar;

    @Column
    private LocalDateTime lastLoginDate;
}
