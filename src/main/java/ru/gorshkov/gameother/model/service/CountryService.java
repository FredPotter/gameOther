package ru.gorshkov.gameother.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gorshkov.gameother.model.entity.Country;
import ru.gorshkov.gameother.model.repository.CountryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public Long size() {
        return countryRepository.count();
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Country not found for id :: " + id));
    }

    public Country getCountryByName(String name) {
        return countryRepository.findCountryByName(name).orElseThrow(() ->
                new RuntimeException("Country not found for name :: " + name));
    }

    @Transactional
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Transactional
    public void deleteCountryById(Long id) {
        countryRepository.deleteById(id);
    }
}
