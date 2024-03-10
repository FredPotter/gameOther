package ru.gorshkov.gameother.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "country", indexes = @Index(columnList = "name"))
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
}
