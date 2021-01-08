package com.gen.com.Insurance_portal.common.mappers;

import com.gen.com.Insurance_portal.entites.TransactionHistory;
import com.gen.com.Insurance_portal.models.responseModels.UTransactionHistoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionHistoryMapper {
    TransactionHistoryMapper INSTANCE = Mappers.getMapper(TransactionHistoryMapper.class);

    UTransactionHistoryModel TransactionHistoryToTransactionHistoryModel(TransactionHistory transactionHistory);
}
