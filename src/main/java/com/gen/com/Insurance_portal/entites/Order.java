package com.gen.com.Insurance_portal.entites;

import com.gen.com.Insurance_portal.common.enums.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="\"order\"")
public class Order extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;

    private String proposalNum;

    @Column(nullable = false)
    private String CustomerCode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(nullable = false)
    private Date effectiveDate;

    @Column(nullable = false)
    private Date expiredDate;

    private Double FeeAmount;

    @Column(nullable = false)
    private OrderStatus orderStatus;

    private String beneficiaryFullName; // Tên đầy đủ của người thụ hưởng

    private String beneficiaryPhoneNumber;

    private Date beneficiaryDOB;

    private String beneficiaryRelationship;

    private String beneficiaryEmail;

    private String beneficiaryGender;

    @ManyToOne
    @JoinColumn(name = "product_pack_detail_id")
    private ProductPackDetail productPackDetail;

    @OneToMany(mappedBy = "order")
    private Set<OrderAttributeSetting> orderAttributeSettings;

    private String insuredFullName;

    private String insuredDOB;

    private String insuredIdNumber;

    private String insuredEmail;

    private String insuredAddress;

    private String insuredGender;

    @OneToOne
    @JoinColumn(name = "promo_code_id")
    private PromoCode promoCode;




    /*

        public string JsonAttribute { get; set; }
        public string JsonAttributeDisplay { get; set; }


        public Guid? CampaignId { get; set; }
        public Guid? BeneficiaryId { get; set; }

        [NotMapped]
        public int PolicyCreateFailedCount { get; set; }
        [NotMapped]
        public string OrderSendToVTPay { get; set; }

    * */

}
