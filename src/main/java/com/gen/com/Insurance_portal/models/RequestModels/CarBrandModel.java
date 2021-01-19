package com.gen.com.Insurance_portal.models.RequestModels;

import com.gen.com.Insurance_portal.entites.CarModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarBrandModel {

    @NotBlank(message = "carBrand is required!")
    private String carBrand;

    @NotBlank(message = "carBrandCode is required!")
    private String carBrandCode;

    @NotNull(message = "models is required!")
    private Set<CarModel> models;
}
