package ru.gorshkov.gameother.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gorshkov.gameother.DTO.entitiesDto.CategoryDto;
import ru.gorshkov.gameother.mapper.CategoryMapper;
import ru.gorshkov.gameother.model.entity.Category;
import ru.gorshkov.gameother.model.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:3000/")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/list")
    public ResponseEntity<List<CategoryDto>> getGames() {
        List<Category> list = categoryService.getCategories();
        return ResponseEntity.ok(list.stream().map(CategoryMapper.INSTANCE::toDto).toList());
    }
}
