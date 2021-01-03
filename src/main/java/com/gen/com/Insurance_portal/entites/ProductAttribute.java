package com.gen.com.Insurance_portal.entites;

import com.gen.com.Insurance_portal.common.enums.AttributeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ProductAttribute extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private Boolean isParent;

    private String attributeGroup;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ProductAttribute parentProductAttribute;

    @Column(nullable = false)
    protected Boolean appliedToAllProductProvider;

    @Column(nullable = false)
    private Boolean displayOnFE;

    private Boolean showHideByParent;

    private Boolean PaddingByParent;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private AttributeFormat attributeFormat;

    private String formatObject;

    @ManyToOne
    @JoinColumn(name = "product_provider_id")
    private Partner partner;

    @OneToMany(mappedBy = "productAttribute")
    private Set<ProductAttributeOption> productAttributeOptions;

    @OneToMany(mappedBy = "productAttribute")
    private Set<OrderAttributeSetting> orderAttributeSettings;

    @OneToMany(mappedBy = "productAttribute")
    private Set<ProductAttributeSetting> productAttributeSettings;

    private Integer minValueText;

    private Integer maxValueText;

    private Date minValueDate;

    private Date maxValueDate;

    private String contains;

}
