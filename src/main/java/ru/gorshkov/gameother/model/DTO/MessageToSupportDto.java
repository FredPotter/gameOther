package ru.gorshkov.gameother.model.DTO;

import java.time.LocalDateTime;

public record MessageToSupportDto(
        Long id,
        UserDto sender,
        String messageSubject,
        String text,
        LocalDateTime messageDate
) {
}
