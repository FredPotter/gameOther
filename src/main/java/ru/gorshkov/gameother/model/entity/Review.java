package ru.gorshkov.gameother.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import ru.gorshkov.gameother.enums.ModerationCheckStatus;

import java.time.LocalDateTime;

@Entity
@Table(name="review")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User Buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User Seller;

    @Column(nullable = false)
    private String gameName;

    @Column(nullable = false)
    private Byte rating;

    @Column
    private String text;

    @Column(nullable = false)
    private LocalDateTime dispatchTime;

    @Column(nullable = false)
    private ModerationCheckStatus moderationCheckStatus;
}
