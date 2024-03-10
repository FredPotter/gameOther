package ru.gorshkov.gameother.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "category", indexes = @Index(columnList = "name"))
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @SequenceGenerator(name="category_seq", allocationSize=1)
    private Long id;
    @Column(nullable = false)
    private String name;
}
