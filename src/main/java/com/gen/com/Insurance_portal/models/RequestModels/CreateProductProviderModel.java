package com.gen.com.Insurance_portal.models.RequestModels;

import com.gen.com.Insurance_portal.common.constanst.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductProviderModel {

    @NotBlank(message = "name is required!")
    private String name;

    @Email(message = "email invalid!")
    @NotBlank(message = "email is required!")
    private String email;

    @NotBlank(message = "phoneNumber is required!")
    @Pattern(regexp = Constants.patternPhone, message = "phoneNumber Invalid")
    private String phoneNumber;
    private String introductionContent;

    @NotBlank(message = "appellation is required!")
    private String appellation;

    @NotBlank(message = "contact is required!")
    private String contact;

    @NotBlank(message = "code is required!")
    private String code;

    private String hotline;

    private String images;
}
