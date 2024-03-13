package ru.gorshkov.gameother.DTO.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GreenSmsGetTokenResponse {
    private String access_token;
}
