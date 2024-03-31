package ru.gorshkov.gameother.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gorshkov.gameother.DTO.requests.rest.CreateOfferRequest;
import ru.gorshkov.gameother.model.entity.Offer;
import ru.gorshkov.gameother.model.entity.VipStatus;
import ru.gorshkov.gameother.model.repository.OfferRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final GameService gameService;
    private final VipStatusService vipStatusService;

    @Transactional
    public void createOffer(CreateOfferRequest request) {
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
        saveOffer(Offer.builder()
                .seller(seller)
                .name(request.getName())
                .game(game)
                .category(category)
                .creationDate(LocalDateTime.now())
                .pricePerLot(request.getPricePerLot())
                .quantityGoodsInLot(request.getQuantityGoodsInLot())
                .description(request.getDescription())
                .obtainMethod(request.getObtainMethod())
                .vipStatus(vipStatus)
                .build());
    }

    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    public Long size() {
        return offerRepository.count();
    }

    public Offer getOfferById(Long id) {
        return offerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Offer not found for id :: " + id));
    }

    @Transactional
    public Offer saveOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Transactional
    public void deleteOfferById(Long id) {
        offerRepository.deleteById(id);
    }

    @Transactional
    public List<Offer> findOffersByGameAndCategoryOrderByPricePerLot(Long gameId, String categoryName) {
        var game = gameService.getGameById(gameId);
        var category = categoryService.getCategoryByName(categoryName);
        return offerRepository.findOffersByGameAndCategoryOrderByPricePerLot(game, category);
    }

    @Transactional
    public List<Offer> findOffersByGame(Long gameId) {
        var game = gameService.getGameById(gameId);
        return offerRepository.findOffersByGame(game);
    }
    
    //TODO: Add methods to get offers by user id

}
