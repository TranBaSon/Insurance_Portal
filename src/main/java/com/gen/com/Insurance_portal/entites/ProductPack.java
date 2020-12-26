package com.gen.com.Insurance_portal.entites;

import com.gen.com.Insurance_portal.common.enums.FeeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ProductPack extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    private Integer claimAmount;

    @Column(nullable = false)
    private Integer orderNo;

    @Column(nullable = false)
    private FeeType feeType;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    @OneToMany(mappedBy = "productPack")
    private Set<BenefitSetting> benefitSettings;
}
