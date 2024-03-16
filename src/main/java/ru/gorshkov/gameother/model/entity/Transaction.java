package ru.gorshkov.gameother.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gorshkov.gameother.enums.BuyerStatus;
import ru.gorshkov.gameother.enums.SellerStatus;

@Entity
@Table(name="transaction")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
    @SequenceGenerator(name="transaction_seq", allocationSize=1)
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
    private Long quantityGoods;

    @Column(nullable = false)
    private Long pricePerLot;

    @Column(nullable = false)
    private BuyerStatus buyerStatus;

    @Column(nullable = false)
    private SellerStatus sellerStatus;
}
