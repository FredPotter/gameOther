package ru.gorshkov.gameother.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gorshkov.gameother.DTO.entitiesDto.OfferDto;
import ru.gorshkov.gameother.DTO.requests.rest.BuyOfferRequest;
import ru.gorshkov.gameother.DTO.requests.rest.CreateOfferRequest;
import ru.gorshkov.gameother.mapper.OfferMapper;
import ru.gorshkov.gameother.model.entity.Offer;
import ru.gorshkov.gameother.model.service.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/offer")
public class OfferController {
    private final OfferService offerService;
    private final TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<String> createOffer(@RequestBody CreateOfferRequest request) {
        offerService.createOffer(request); //TODO: Сделать проверки пользователя
        return ResponseEntity.ok("OK");
    }
    @PostMapping("/buy")
    public ResponseEntity<String> buyOffer(@RequestHeader("Authorization") String token,
                                           @RequestBody BuyOfferRequest request) {
        transactionService.createTransaction(request, token);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDto> getOffer(@PathVariable Long id) {
        OfferDto offerDto = OfferMapper.INSTANCE.toDto(offerService.getOfferById(id));
        return ResponseEntity.ok(offerDto);
    }
    @GetMapping("/list")
    public ResponseEntity<List<OfferDto>> getOffers(@RequestParam String gameName, @RequestParam String categoryName) {
        List<Offer> list = offerService.findOffersByGameAndCategoryOrderByPricePerLot(gameName, categoryName);
        return ResponseEntity.ok(list.stream().map(OfferMapper.INSTANCE::toDto).toList());
    }
}
