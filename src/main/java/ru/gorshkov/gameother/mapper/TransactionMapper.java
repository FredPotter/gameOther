package ru.gorshkov.gameother.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gorshkov.gameother.DTO.entitiesDto.TransactionDto;
import ru.gorshkov.gameother.model.entity.Transaction;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);
    TransactionDto toDto(Transaction transaction);
    Transaction toEntity(TransactionDto transactionDto);
}
