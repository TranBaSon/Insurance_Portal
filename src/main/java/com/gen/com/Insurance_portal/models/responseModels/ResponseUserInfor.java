package com.gen.com.Insurance_portal.models.responseModels;

import com.gen.com.Insurance_portal.entites.Role;
import lombok.Data;

@Data
public class ResponseUserInfor {
    private Long id;

    private String username;

    private String email;

    private String avatar;

    private String surname;

    private String givenName;

    private String phoneNumber;

    private RoleResponseModel role;

}
