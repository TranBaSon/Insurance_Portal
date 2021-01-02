package com.gen.com.Insurance_portal.models.RequestModels;

import com.gen.com.Insurance_portal.common.enums.GenderApply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductModel {

    private String name;

    private Long partnerId;

    private String code;

    private MultipartFile insuredRule;

    private String detailedDescription;

    private Long productCategoryId;

    private GenderApply genderApply;

    private MultipartFile bannerImage;

    @Min(value = 1, message = "priceObj must be greater than 0")
    private Double priceObj;

    private Integer EffectiveDateRangeSelectionNumber;

    private String shortDescription;

    private MultipartFile avatarImage;
}
