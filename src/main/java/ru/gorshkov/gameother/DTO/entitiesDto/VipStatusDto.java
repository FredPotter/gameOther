package ru.gorshkov.gameother.DTO.entitiesDto;

import java.time.LocalDateTime;

public record VipStatusDto(
        Long id,
        LocalDateTime expirationDateVipStatus
) {}