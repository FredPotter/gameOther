package ru.gorshkov.gameother.DTO.requests.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GreenSmsGetTokenRequest {
    private String user;
    private String pass;
    private Long expired;
}
