package com.gen.com.Insurance_portal.entites;

import com.gen.com.Insurance_portal.common.enums.OrderStatus;
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
@Table(name="\"order\"")
public class Order extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;

    @Column(nullable = false)
    private String CustomerCode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(nullable = false)
    private Date effectiveDate;

    @Column(nullable = false)
    private Date expiredDate;

    @Column(nullable = false)
    private OrderStatus orderStatus;

//    private String beneficiaryFullName; // Tên đầy đủ của người thụ hưởng
//
//    private String beneficiaryPhoneNumber;
//
//    private Date beneficiaryDOB;
//
//    private String beneficiaryRelationship;
//
//    private String beneficiaryEmail;
//
//    private String beneficiaryGender;

    private String insuredFullName;

    private String insuredDOB;

    private String insuredIdNumber;

    private String insuredEmail;

    private String insuredAddress;

    private String insuredGender;

}
