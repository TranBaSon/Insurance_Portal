package com.gen.com.Insurance_portal.models.RequestModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarModel {

    private String name;

    private String code;

    private Integer percent;

    private Long carBrandId;
}
