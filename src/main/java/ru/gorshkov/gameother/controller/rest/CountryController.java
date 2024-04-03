package ru.gorshkov.gameother.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gorshkov.gameother.DTO.entitiesDto.CountryDto;
import ru.gorshkov.gameother.mapper.CountryMapper;
import ru.gorshkov.gameother.model.entity.Country;
import ru.gorshkov.gameother.model.service.CountryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/country")
@CrossOrigin(origins = "http://localhost:3000/")
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/list")
    public ResponseEntity<List<CountryDto>> getCountries() {
        List<Country> list = countryService.getCountries();
        return ResponseEntity.ok(list.stream().map(CountryMapper.INSTANCE::toDto).toList());
    }
}
