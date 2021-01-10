package com.gen.com.Insurance_portal.common.mappers;

import com.gen.com.Insurance_portal.entites.TransactionHistory;
import com.gen.com.Insurance_portal.models.responseModels.UTransactionHistoryModel;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-10T15:58:02+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_265 (AdoptOpenJDK)"
)
public class TransactionHistoryMapperImpl implements TransactionHistoryMapper {

    @Override
    public UTransactionHistoryModel TransactionHistoryToTransactionHistoryModel(TransactionHistory transactionHistory) {
        if ( transactionHistory == null ) {
            return null;
        }

        UTransactionHistoryModel uTransactionHistoryModel = new UTransactionHistoryModel();

        uTransactionHistoryModel.setContractCode( transactionHistory.getContractCode() );
        uTransactionHistoryModel.setProductName( transactionHistory.getProductName() );
        uTransactionHistoryModel.setEffectiveDate( transactionHistory.getEffectiveDate() );
        uTransactionHistoryModel.setExpiredDate( transactionHistory.getExpiredDate() );
        uTransactionHistoryModel.setTransactionDate( transactionHistory.getTransactionDate() );
        uTransactionHistoryModel.setAmount( transactionHistory.getAmount() );

        return uTransactionHistoryModel;
    }
}
