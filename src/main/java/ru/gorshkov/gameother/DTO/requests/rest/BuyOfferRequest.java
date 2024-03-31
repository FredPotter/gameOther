package ru.gorshkov.gameother.DTO.requests.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuyOfferRequest {
    private Long offerId;
    private Long quantity;
    private Long totalPrice;
}
