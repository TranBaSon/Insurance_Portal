package com.gen.com.Insurance_portal.models.responseModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessageModel {
    private String status;
    private String message;
}
