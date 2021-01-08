package com.gen.com.Insurance_portal.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gen.com.Insurance_portal.common.enums.PaymentStatus;
import com.gen.com.Insurance_portal.common.enums.ContractStatus;
import com.gen.com.Insurance_portal.common.enums.PurchaseMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Contract extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String partner;

    private String partnerCode;

    @Column(nullable = false)
    private String customerCode;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String idNumber;

    @Enumerated(value = EnumType.STRING)
    private ContractStatus status = ContractStatus.Inactive;

    @Column(nullable = false)
    private Date effectiveDate;

    @Column(nullable = false)
    private Date expiredDate;

    private Date cancelDate;

    private Date createdContractDate;

    private Date activeDate;

    @Column(nullable = false)
    private PaymentStatus paymentStatus = PaymentStatus.Paid;

    private Double paidAmount;

    private Date extendSuccessDate;

    private String fullName;

    private Date dob;

    private String gender;

    private String email;

    private String phoneNumber;

    private String address;

    private String buyerIdNumber;

    @Column(nullable = false)
    private PurchaseMethod purchaseMethod;

    private String numberPlate;

    private String carBrand;

    private String carMaker;

    private String product;

    private String productCode;

    @JsonIgnore
    @OneToOne(mappedBy = "contract", fetch = FetchType.LAZY)
    private TransactionHistory transactionHistory;

}
