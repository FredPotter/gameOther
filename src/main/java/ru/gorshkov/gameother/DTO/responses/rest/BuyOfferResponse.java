package ru.gorshkov.gameother.DTO.responses.rest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuyOfferResponse {
    private Boolean success;
    private String message;
}
