package ru.gorshkov.gameother.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gorshkov.gameother.mapper.CategoryMapper;
import ru.gorshkov.gameother.model.DTO.CategoryDto;
import ru.gorshkov.gameother.model.DTO.SellerDto;
import ru.gorshkov.gameother.model.service.CategoryService;
import ru.gorshkov.gameother.model.service.ReviewService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/main")
public class mainController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/sellers")
    public ResponseEntity<List<SellerDto>> getSellers() {
        return ResponseEntity.status(200).body(reviewService.getSellers());
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categoryDtos = categoryService.getCategories().stream()
                .map(CategoryMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(200).body(categoryDtos);
    }
}
