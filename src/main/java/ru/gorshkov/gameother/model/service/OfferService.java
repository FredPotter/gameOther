package ru.gorshkov.gameother.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gorshkov.gameother.model.entity.Offer;
import ru.gorshkov.gameother.model.repository.OfferRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;

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
    public Offer saveOffer(Offer offer) {
        return offerRepository.save(offer);
    }
    public void deleteOfferById(Long id) {
        offerRepository.deleteById(id);
    }
    //TODO: Add methods to get offers by user id
    
}
