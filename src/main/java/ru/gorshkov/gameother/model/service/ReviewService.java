package ru.gorshkov.gameother.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }
}
