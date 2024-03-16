package ru.gorshkov.gameother.DTO.entitiesDto;

import java.time.LocalDateTime;

public record OfferDto(
        Long id,
        String name,
        CategoryDto category,
        GameDto game,
        LocalDateTime creationDate,
        UserDto seller,
        Long pricePerLot,
        Long quantityGoodsInLot,
        String description,
        String obtainMethod,
        VipStatusDto vipStatus
) {}