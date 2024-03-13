package ru.gorshkov.gameother.DTO.entitiesDto;

import java.time.LocalDateTime;

public record UserBlockingDto(
        Long id,
        UserDto user,
        String reason,
        LocalDateTime expirationDate
) {}