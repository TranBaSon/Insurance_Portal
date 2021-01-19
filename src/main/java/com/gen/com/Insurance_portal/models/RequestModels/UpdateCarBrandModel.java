package com.gen.com.Insurance_portal.models.RequestModels;

import com.gen.com.Insurance_portal.entites.CarModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarBrandModel {

    private String carBrand;

    private String carBrandCode;

    private Set<CarModel> models;
}
