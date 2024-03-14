package ru.gorshkov.gameother.DTO.requests.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String countryName;
    private String login;
    private String password;
    private String telephoneRegion;
}