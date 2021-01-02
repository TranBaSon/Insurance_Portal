package com.gen.com.Insurance_portal.models.RequestModels;

import com.gen.com.Insurance_portal.common.enums.GenderApply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductModel {

    @NotBlank(message = "name is required!")
    private String name;

    @NotNull(message = "partnerId is required!")
    private Long partnerId;

    @NotBlank(message = "code is required!")
    private String code;


    @NotNull(message = "insuredRule is required!")
    private MultipartFile insuredRule;

    @NotBlank(message = "code is required!")
    private String detailedDescription;

    @NotNull(message = "targetGroupId is required!")
    private Long productCategoryId;

    @NotNull(message = "genderApply is required!")
    private GenderApply genderApply;

    @NotNull(message = "bannerImage is required!")
    private MultipartFile bannerImage;

    @NotNull(message = "priceObj is required!")
    @Min(value = 1, message = "priceObj must be greater than 0")
    private Double priceObj;

    @NotNull(message = "EffectiveDateRangeSelectionNumber is required!")
    private Integer EffectiveDateRangeSelectionNumber;

    @NotBlank(message = "shortDescription is required!")
    private String shortDescription;

    @NotNull(message = "avatarImage is required!")
    private MultipartFile avatarImage;

}
