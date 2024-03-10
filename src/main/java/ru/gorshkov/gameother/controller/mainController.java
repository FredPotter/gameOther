package ru.gorshkov.gameother.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gorshkov.gameother.model.DTO.SellerDto;
import ru.gorshkov.gameother.model.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/main")
public class mainController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/sellers")
    public ResponseEntity<List<SellerDto>> getSellers() {
        return ResponseEntity.status(200).body(reviewService.getSellers());
    }
}
