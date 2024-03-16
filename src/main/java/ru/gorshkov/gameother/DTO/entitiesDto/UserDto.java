package ru.gorshkov.gameother.DTO.entitiesDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gorshkov.gameother.enums.AccountStatus;
import ru.gorshkov.gameother.enums.UserStatus;
import java.time.LocalDateTime;

public record UserDto(
         Long id,
         @JsonIgnore UserStatus userStatus,
         String login,
         String email,
         @JsonIgnore String password,
         String username,
         @JsonIgnore Long balance,
         AccountStatus accountStatus,
         @JsonIgnore LocalDateTime registrationDate,
         CountryDto country,
         String pathToAvatar,
         LocalDateTime lastLoginDate
) { }
