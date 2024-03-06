package ru.gorshkov.gameother.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import ru.gorshkov.gameother.enums.BuyerStatus;
import ru.gorshkov.gameother.enums.SellerStatus;

@Entity
@Table(name="transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @Column(nullable = false)
    private Long QuantityGoods;

    @Column(nullable = false)
    private Long pricePerLot;

    @Column(nullable = false)
    private BuyerStatus buyerStatus;

    @Column(nullable = false)
    private SellerStatus sellerStatus;
}
