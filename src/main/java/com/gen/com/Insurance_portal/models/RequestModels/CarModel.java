package com.gen.com.Insurance_portal.models.RequestModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarModel {

    @NotBlank(message = "name is required!")
    private String name;

    @NotBlank(message = "code is required!")
    private String code;

    @NotNull(message = "percent is required!")
    private Integer percent;

    @NotNull(message = "carBrandId is required!")
    private Long carBrandId;
}
