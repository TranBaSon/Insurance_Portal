package com.gen.com.Insurance_portal.entites;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Benefit extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String parentId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Boolean isBenefitPlus;

    private String description;

    @OneToMany(mappedBy = "benefit")
    private Set<BenefitSetting> benefitSettings;

}
