package com.gen.com.Insurance_portal.common.mappers;

import com.gen.com.Insurance_portal.entites.User;
import com.gen.com.Insurance_portal.models.RequestModels.CreateUserModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseUserInfor;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-26T22:56:28+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_265 (AdoptOpenJDK)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User createUserModelToUser(CreateUserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        User user = new User();

        return user;
    }

    @Override
    public ResponseUserInfor UserToUserInfor(User user) {
        if ( user == null ) {
            return null;
        }

        ResponseUserInfor responseUserInfor = new ResponseUserInfor();

        return responseUserInfor;
    }
}
