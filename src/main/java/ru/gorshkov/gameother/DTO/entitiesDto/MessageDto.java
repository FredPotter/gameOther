package ru.gorshkov.gameother.DTO.entitiesDto;

import java.time.LocalDateTime;

public record MessageDto(
        Long id,
        UserDto sender,
        UserDto receiver,
        String messageSubject,
        String text,
        LocalDateTime messageDate
) {
}
