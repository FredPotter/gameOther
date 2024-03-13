package ru.gorshkov.gameother.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gorshkov.gameother.DTO.entitiesDto.UserBlockingDto;
import ru.gorshkov.gameother.model.entity.UserBlocking;

@Mapper
public interface UserBlockingMapper {
    UserBlockingMapper INSTANCE = Mappers.getMapper(UserBlockingMapper.class);
    UserBlockingDto toDto(UserBlocking userBlocking);
    UserBlocking toEntity(UserBlockingDto userBlockingDto);
}
