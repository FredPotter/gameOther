package ru.gorshkov.gameother.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gorshkov.gameother.DTO.entitiesDto.CountryDto;
import ru.gorshkov.gameother.model.entity.Country;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    CountryDto toDto(Country country);
    Country toEntity(CountryDto countryDto);
}
