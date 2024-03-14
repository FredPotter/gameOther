package ru.gorshkov.gameother.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gorshkov.gameother.DTO.entitiesDto.VipStatusDto;
import ru.gorshkov.gameother.DTO.requests.rest.CreateOfferRequest;
import ru.gorshkov.gameother.model.entity.Offer;
import ru.gorshkov.gameother.model.entity.VipStatus;
import ru.gorshkov.gameother.model.service.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OfferController {
    private final OfferService offerService;
    private final CategoryService categoryService;
    private final GameService gameService;
    private final VipStatusService vipStatusService;
    private final UserService userService;

    @PostMapping("/offer")
    public ResponseEntity<String> createOffer(@RequestBody CreateOfferRequest request) {
        var category = categoryService.getCategoryByName(request.getCategoryName());
        var game = gameService.getGameByName(request.getGameName());
        var seller = userService.getUserById(request.getSellerId());
        VipStatus vipStatus = null;
        if (request.getVipStatusDays() > 0) {
            vipStatus = vipStatusService.saveVipStatus(
                    VipStatus.builder()
                            .expirationDateVipStatus(LocalDateTime.now().plusDays(request.getVipStatusDays()))
                            .build());
        }
        offerService.saveOffer(Offer.builder()
                .seller(seller)
                .name(request.getName())
                .game(game)
                .category(category)
                .pricePerLot(request.getPricePerLot())
                .quantityGoodsInLot(request.getQuantityGoodsInLot())
                .description(request.getDescription())
                .obtainMethod(request.getObtainMethod())
                .vipStatus(vipStatus)
                .build());
        return ResponseEntity.ok("OK");
    }
}
