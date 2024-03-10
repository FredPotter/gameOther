package ru.gorshkov.gameother.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="offer")
@Data
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer_seq")
    @SequenceGenerator(name="offer_seq", allocationSize=1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @Column(nullable = false)
    private Long pricePerLot;

    @Column(nullable = false)
    private Long QuantityGoodsInLot;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String obtainMethod;

    @OneToOne
    @JoinColumn(name = "vip_status_id")
    private VipStatus vipStatus;
}
