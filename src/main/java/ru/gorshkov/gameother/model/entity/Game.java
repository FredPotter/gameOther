package ru.gorshkov.gameother.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="game", indexes = @Index(columnList = "name"))
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String pathToPoster;
}
