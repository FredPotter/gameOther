package ru.gorshkov.gameother.model.DTO;

import ru.gorshkov.gameother.enums.AccountStatus;
import ru.gorshkov.gameother.enums.UserStatus;
import java.time.LocalDateTime;

public record UserDto(
         Long id,
         UserStatus userStatus,
         String login,
         String email,
         String password,
         String username,
         Long balance,
         AccountStatus accountStatus,
         LocalDateTime registrationDate,
         CountryDto country,
         String pathToAvatar,
         LocalDateTime lastLoginDate
) {
}
