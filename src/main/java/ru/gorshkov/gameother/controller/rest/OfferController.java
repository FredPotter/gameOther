package ru.gorshkov.gameother.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gorshkov.gameother.DTO.entitiesDto.OfferDto;
import ru.gorshkov.gameother.DTO.requests.rest.BuyOfferRequest;
import ru.gorshkov.gameother.DTO.requests.rest.CreateOfferRequest;
import ru.gorshkov.gameother.DTO.responses.rest.BuyOfferResponse;
import ru.gorshkov.gameother.DTO.responses.rest.CreateOfferResponse;
import ru.gorshkov.gameother.mapper.OfferMapper;
import ru.gorshkov.gameother.model.entity.Offer;
import ru.gorshkov.gameother.model.service.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/offer")
@CrossOrigin(origins = "http://localhost:3000/")
public class OfferController {
    private final OfferService offerService;
    private final TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<CreateOfferResponse> createOffer(@RequestBody CreateOfferRequest request) {
        offerService.createOffer(request);
        return ResponseEntity.ok(new CreateOfferResponse(true, "OK"));
    }
    @PostMapping("/buy")
    public ResponseEntity<BuyOfferResponse> buyOffer(@RequestHeader("Authorization") String token,
                                                     @RequestBody BuyOfferRequest request) {
        try{
            transactionService.createTransaction(request, token);
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BuyOfferResponse(false, e.getMessage()));
        }
        return ResponseEntity.ok(new BuyOfferResponse(true, "OK"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDto> getOffer(@PathVariable Long id) {
        OfferDto offerDto = OfferMapper.INSTANCE.toDto(offerService.getOfferById(id));
        return ResponseEntity.ok(offerDto);
    }
    @GetMapping("/list")
    public ResponseEntity<List<OfferDto>> getOffers(@RequestParam Long gameId, @RequestParam String categoryName) {
        System.out.println(categoryName);
        if (gameId != null && Objects.equals(categoryName, "")) {
            List<Offer> list = offerService.findOffersByGame(gameId);
            return ResponseEntity.ok(list.stream().map(OfferMapper.INSTANCE::toDto).toList());
        }
        List<Offer> list = offerService.findOffersByGameAndCategoryOrderByPricePerLot(gameId, categoryName);
        return ResponseEntity.ok(list.stream().map(OfferMapper.INSTANCE::toDto).toList());
    }
}
