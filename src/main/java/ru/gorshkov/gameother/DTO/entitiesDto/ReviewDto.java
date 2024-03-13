package ru.gorshkov.gameother.DTO.entitiesDto;

import ru.gorshkov.gameother.enums.ModerationCheckStatus;
import java.time.LocalDateTime;

public record ReviewDto(
        Long id,
        UserDto buyer,
        UserDto seller,
        String gameName,
        Byte rating,
        String text,
        LocalDateTime dispatchTime,
        ModerationCheckStatus moderationCheckStatus
) {}