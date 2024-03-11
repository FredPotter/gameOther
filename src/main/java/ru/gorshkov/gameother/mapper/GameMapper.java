package ru.gorshkov.gameother.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gorshkov.gameother.DTO.entitiesDto.GameDto;
import ru.gorshkov.gameother.model.entity.Game;

@Mapper
public interface GameMapper {
    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    GameDto toDto(Game game);
    Game toEntity(GameDto gameDto);
}
