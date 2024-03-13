package ru.gorshkov.gameother.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gorshkov.gameother.DTO.entitiesDto.SellerDto;
import ru.gorshkov.gameother.model.entity.Review;
import ru.gorshkov.gameother.model.repository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public Long size() {
        return reviewRepository.count();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Review not found for id :: " + id));
    }

    @Transactional
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Transactional
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }

    public List<SellerDto> getSellers() {
        return reviewRepository.getSellers();
    }
}
