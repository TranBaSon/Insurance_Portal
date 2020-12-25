package com.gen.com.Insurance_portal.entites;

import com.gen.com.Insurance_portal.common.enums.PaymentStatus;
import com.gen.com.Insurance_portal.common.enums.PolicyGroup;
import com.gen.com.Insurance_portal.common.enums.PolicyStatus;
import com.gen.com.Insurance_portal.common.enums.PurchaseMethod;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Policy extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String contactNo;

    @Column(nullable = false)
    private String customerCode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String idNumber;

    @Column(nullable = false)
    private PolicyStatus status;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Column(nullable = false)
    private Date effectiveDate;

    @Column(nullable = false)
    private Date expiredDate;

    private Date lastAutoExtendAttemptDate;

    private Integer dailyExtendAttempt;

    private Date autoExtendExpiredDate;

    private Date cancelDate;

    private Date createdPolicyDate;

    private Date activeDate;

    @Column(nullable = false)
    private Boolean enableExtend;

    @Column(nullable = false)
    private PaymentStatus paymentStatus;

    @Column(nullable = false)
    private Double feeAmount;

    private Double autoExtendFeeAmount;

    private Double paidAmount;

    private Double paidAmountPercentage;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Date extendSuccessDate;

    @ManyToOne
    @JoinColumn(name = "product_pack_detail_id")
    private ProductPackDetail productPackDetail;

    private String fullName;

    private Date dob;

    private String gender;

    private String email;

    private String address;

    private String buyerIdNumber;

    private PolicyGroup policyGroup;

    @Column(nullable = false)
    private PurchaseMethod purchaseMethod;

    private Boolean syncPolicy;

    private Boolean syncCancelPolicy;

    private String promoCode;

    private Date nextDebtDate;

    private Integer bidailyPaymentAttempts;

    /*

    private Campaign Campaign;

    */
}
