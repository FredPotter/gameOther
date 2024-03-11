package ru.gorshkov.gameother.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gorshkov.gameother.DTO.entitiesDto.VipStatusDto;
import ru.gorshkov.gameother.model.entity.VipStatus;

@Mapper
public interface VipStatusMapper {
    VipStatusMapper INSTANCE = Mappers.getMapper(VipStatusMapper.class);
    VipStatusDto toDto(VipStatus vipStatus);
    VipStatus toEntity(VipStatusDto vipStatusDto);
}
