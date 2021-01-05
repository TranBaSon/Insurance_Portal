package com.gen.com.Insurance_portal.models.RequestModels;

import com.gen.com.Insurance_portal.common.enums.GenderApply;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "CreateProductModel")
public class CreateProductModel {

    @Schema(name = "name", type = "String", required = true)
    @NotBlank(message = "name is required!")
    private String name;

    @Schema(name = "partnerId", type = "Long", required = true)
    @NotNull(message = "partnerId is required!")
    private Long partnerId;

    @Schema(name = "code", type = "String", required = true)
    @NotBlank(message = "code is required!")
    private String code;


    @Schema(name = "detailedDescription", type = "String", required = true)
    @NotBlank(message = "code is required!")
    private String detailedDescription;

    @Schema(name = "productCategoryId", type = "Long", required = true)
    @NotNull(message = "targetGroupId is required!")
    private Long productCategoryId;

    @Schema(name = "genderApply", type = "String", required = true, description = "value in {'ALL', 'Male', 'FEMALE'}")
    @NotNull(message = "genderApply is required!")
    private GenderApply genderApply;

    @Schema(name = "priceObj", type = "Double", required = true)
    @NotNull(message = "priceObj is required!")
    @Min(value = 1, message = "priceObj must be greater than 0")
    private Double priceObj;

    @Schema(name = "EffectiveDateRangeSelectionNumber", type = "Integer", required = true)
    @NotNull(message = "EffectiveDateRangeSelectionNumber is required!")
    private Integer EffectiveDateRangeSelectionNumber;

    @Schema(name = "shortDescription", type = "String", required = true)
    @NotBlank(message = "shortDescription is required!")
    private String shortDescription;

    private FileModel files;

}
