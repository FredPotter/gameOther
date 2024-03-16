package ru.gorshkov.gameother.DTO.requests.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangeBalanceRequest {
    private Long amount;
}
