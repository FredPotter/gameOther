package ru.gorshkov.gameother.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gorshkov.gameother.DTO.entitiesDto.ReviewDto;
import ru.gorshkov.gameother.model.entity.Review;

@Mapper
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);
    ReviewDto toDto(Review review);
    Review toEntity(ReviewDto reviewDto);
}
