package ru.gorshkov.gameother.DTO.responses.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PreRegisterResponse {
    private Boolean success;
    private String message;
}
