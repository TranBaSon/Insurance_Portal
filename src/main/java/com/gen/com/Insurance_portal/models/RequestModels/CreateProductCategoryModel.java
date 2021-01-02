package com.gen.com.Insurance_portal.models.RequestModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductCategoryModel {

    @NotBlank(message = "name is required!")
    private String name;

    @NotBlank(message = "description is required!")
    private String description;
}
