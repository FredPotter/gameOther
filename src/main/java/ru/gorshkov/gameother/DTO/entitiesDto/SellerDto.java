package ru.gorshkov.gameother.DTO.entitiesDto;

import java.time.LocalDateTime;

public record SellerDto(
        Long id,
        String username,
        LocalDateTime lastLoginDate,
        String pathToAvatar,
        Integer averageRating
) {}