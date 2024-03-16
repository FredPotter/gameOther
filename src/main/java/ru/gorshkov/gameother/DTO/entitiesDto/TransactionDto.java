package ru.gorshkov.gameother.DTO.entitiesDto;

import ru.gorshkov.gameother.enums.BuyerStatus;
import ru.gorshkov.gameother.enums.SellerStatus;

public record TransactionDto(
        Long id,
        UserDto buyer,
        UserDto seller,
        OfferDto offer,
        Long quantityGoods,
        Long pricePerLot,
        BuyerStatus buyerStatus,
        SellerStatus sellerStatus
) {}