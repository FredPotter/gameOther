package ru.gorshkov.gameother.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gorshkov.gameother.model.DTO.MessageToSupportDto;
import ru.gorshkov.gameother.model.entity.MessageToSupport;

@Mapper
public interface MessageToSupportMapper {
    MessageToSupportMapper INSTANCE = Mappers.getMapper(MessageToSupportMapper.class);
    MessageToSupportDto toDto(MessageToSupport messageToSupport);
    MessageToSupport toEntity(MessageToSupportDto messageToSupportDto);
}
