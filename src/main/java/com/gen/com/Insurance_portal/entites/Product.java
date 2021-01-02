package com.gen.com.Insurance_portal.entites;

import com.gen.com.Insurance_portal.common.enums.*;
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
public class Product extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @Lob
    @Column(nullable = false)
    private String shortDescription;

    @Lob
    @Column(nullable = false)
    private String detailedDescription;

    private String avatarImage;

    private String bannerImage;

    private String indemnityTemplate;

    private String indemnityInstruction;

    @Lob
    @Column(nullable = false)
    private String indemnityInstructionContent = "guide";

    @Enumerated(EnumType.STRING)
    private EffectiveDateType effectiveDateType = EffectiveDateType.NONE;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FeeType feeType = FeeType.FIXED;

    @Column(nullable = false)
    private ProductStatus productStatus = ProductStatus.APPROVED;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderApply genderApply;

    private Boolean isActive =  true;

    private Boolean duplicateBuyerInfo;

    private Boolean hideBeneficiary;

    // số lựa chọn ngày có hiệu lực
    private Integer EffectiveDateRangeSelectionNumber;


    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    @ManyToOne
    @JoinColumn(name = "product_provider_id")
    private ProductProvider productProvider;

    private Boolean enableIndemnity;

    private Boolean canBuyMultiple;

    private Boolean isSelfInsurance;

    private Boolean hideBuyerInfo;

    private String videoUrl;

    private Double priceObj;

    private String insuredRule;

    @OneToMany(mappedBy = "product")
    private Set<Benefit> benefits;

    @ManyToOne
    @JoinColumn(name = "target_group_id")
    private TargetGroup targetGroup;

    @OneToMany(mappedBy = "product")
    private Set<ProductAttributeSetting> productAttributeSettings;


//    public string MappedRequestJsonStructure { get; set; }
//
//    public string FERequestJsonStructure { get; set; }
//    public string FERequestQueryBuilder { get; set; }
//    public bool HideInsured { get; set; }
//
//
//        [Required]
//    public int RequestJsonStructureId { get; set; }
//
//        [ForeignKey("RequestJsonStructureId")]
//    public RequestJsonStructure RequestJsonStructure { get; set; }

//
//    public ICollection<ProductPaymentSetting> ProductPaymentSettings { get; set; }
//    public ICollection<CampaignProduct> CampaignProducts { get; set; }

}
