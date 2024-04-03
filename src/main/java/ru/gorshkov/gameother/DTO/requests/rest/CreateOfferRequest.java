package ru.gorshkov.gameother.DTO.requests.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOfferRequest {
    private Long sellerId;
    private String name;
    private String gameName;
    private String categoryName;
    private Long pricePerLot;
    private Long quantity;
    private Long quantityGoodsInLot;
    private String description;
    private String obtainMethod;
    private Long vipStatusDays;
}
