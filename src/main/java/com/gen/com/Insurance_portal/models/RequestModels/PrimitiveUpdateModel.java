package com.gen.com.Insurance_portal.models.RequestModels;

import com.gen.com.Insurance_portal.common.enums.GenderApply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrimitiveUpdateModel {
    private String name;

    private Long partnerId;

    private String code;

    private String detailedDescription;

    private Long productCategoryId;

    private GenderApply genderApply;

    private Double priceObj;

    private Integer EffectiveDateRangeSelectionNumber;

    private String shortDescription;
}
