package ru.gorshkov.gameother.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gorshkov.gameother.DTO.entitiesDto.UserDto;
import ru.gorshkov.gameother.model.entity.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
