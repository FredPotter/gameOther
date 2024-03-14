package ru.gorshkov.gameother.DTO.requests.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gorshkov.gameother.model.entity.User;

import java.time.LocalDateTime;

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
    private Long quantityGoodsInLot;
    private String description;
    private String obtainMethod;
    private Long vipStatusDays;
}
