package ru.gorshkov.gameother.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gorshkov.gameother.model.DTO.MessageDto;
import ru.gorshkov.gameother.model.entity.Message;

@Mapper
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    MessageDto toDto(Message message);
    Message toEntity(MessageDto messageDto);
}
