package ru.gorshkov.gameother.model.DTO;

import java.time.LocalDateTime;

public record VipStatusDto(
        Long id,
        LocalDateTime expirationDateVipStatus
) {}