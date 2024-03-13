package ru.gorshkov.gameother.DTO.entitiesDto;

import java.time.LocalDateTime;

public record MessageToSupportDto(
        Long id,
        UserDto sender,
        String messageSubject,
        String text,
        LocalDateTime messageDate
) {
}
