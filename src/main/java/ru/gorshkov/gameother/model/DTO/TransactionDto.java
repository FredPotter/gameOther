package ru.gorshkov.gameother.model.DTO;

import ru.gorshkov.gameother.enums.BuyerStatus;
import ru.gorshkov.gameother.enums.SellerStatus;

public record TransactionDto(
        Long id,
        UserDto buyer,
        UserDto seller,
        OfferDto offer,
        Long QuantityGoods,
        Long pricePerLot,
        BuyerStatus buyerStatus,
        SellerStatus sellerStatus
) {}