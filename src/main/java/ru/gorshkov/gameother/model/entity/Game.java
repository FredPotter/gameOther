package ru.gorshkov.gameother.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="game", indexes = @Index(columnList = "name"))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
    @SequenceGenerator(name="game_seq", allocationSize=1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String pathToPoster;
}
