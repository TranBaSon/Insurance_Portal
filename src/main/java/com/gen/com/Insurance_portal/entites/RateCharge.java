package com.gen.com.Insurance_portal.entites;

import com.gen.com.Insurance_portal.common.enums.PolicyGroup;
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
public class RateCharge extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private Double rateChargeShare;

    private Date startDate;

    private Date endDate;

    private Boolean isActive;

    private PolicyGroup policyGroup;
}
