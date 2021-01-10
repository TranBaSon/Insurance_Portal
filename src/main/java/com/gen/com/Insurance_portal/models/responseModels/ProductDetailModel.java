package com.gen.com.Insurance_portal.models.responseModels;

import com.gen.com.Insurance_portal.common.enums.EffectiveDateType;
import com.gen.com.Insurance_portal.common.enums.FeeType;
import com.gen.com.Insurance_portal.common.enums.GenderApply;
import com.gen.com.Insurance_portal.common.enums.ProductStatus;
import com.gen.com.Insurance_portal.entites.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailModel {
    private Long id;

    private String name;

    private String code;

    private String shortDescription;

    private String detailedDescription;

    private String avatarImage;

    private String bannerImage;

    private String indemnityTemplate;

    private String indemnityInstruction;

    private String indemnityInstructionContent;

    private EffectiveDateType effectiveDateType;

    private FeeType feeType;

    private ProductStatus productStatus ;

    private GenderApply genderApply;

    private Boolean isActive ;

    private Boolean duplicateBuyerInfo;

    private Boolean hideBeneficiary;

    private Integer EffectiveDateRangeSelectionNumber;

    private String categoryName;
    private Long categoryId;

    private Long partnerId;

    private String partnerName;

    private Boolean enableIndemnity;

    private Boolean isSelfInsurance;

    private Boolean hideBuyerInfo;

    private String videoUrl;

    private Double priceObj;

    private String insuredRule;

    private Set<Benefit> benefits;
}
