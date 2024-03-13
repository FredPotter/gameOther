package ru.gorshkov.gameother.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gorshkov.gameother.DTO.entitiesDto.OfferDto;
import ru.gorshkov.gameother.model.entity.Offer;

@Mapper
public interface OfferMapper {
    OfferMapper INSTANCE = Mappers.getMapper(OfferMapper.class);
    OfferDto toDto(Offer offer);
    Offer toEntity(OfferDto offerDto);
}
