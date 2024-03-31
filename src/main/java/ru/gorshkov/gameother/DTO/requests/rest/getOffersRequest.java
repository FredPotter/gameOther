package ru.gorshkov.gameother.DTO.requests.rest;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class getOffersRequest {
    private String gameName;
    private String categoryName;
}
