package ru.gorshkov.gameother.model.DTO;

import java.time.LocalDateTime;

public record UserBlockingDto(
        Long id,
        UserDto user,
        String reason,
        LocalDateTime expirationDate
) {}