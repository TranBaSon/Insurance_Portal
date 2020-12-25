package com.gen.com.Insurance_portal.entites;

import com.gen.com.Insurance_portal.common.enums.PaymentMethod;
import com.gen.com.Insurance_portal.common.enums.PolicyGroup;
import com.gen.com.Insurance_portal.common.enums.TransactionProcessName;
import com.gen.com.Insurance_portal.common.enums.TransactionStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionId;

    private String processCode;

    private Date transactionDate;

    private Double amount;

    private String customerId;

    private String customerPhoneNumber;

    private String policyCode;

    private String productName;

    private String productCode;

    private String productId;

    private String ProductProviderId;

    private String ProductProviderName;

    private String ProductProviderCode;

    private String ProductPackName;

    private String CampaignName;

    private String CampaignCode;

    private Double Commission;

    private String errorCode;

    private String errorMessage;

    private TransactionProcessName processName;

    private PaymentMethod paymentMethod;

    private TransactionStatus transactionStatus;

    private PolicyGroup policyGroup;

    private String orderId;

    private String proposalNum;

    private String contractNo;

    private String subscriptionType;

    private String customerCode;
}
