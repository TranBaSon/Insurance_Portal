package com.gen.com.Insurance_portal.common.mappers;

import com.gen.com.Insurance_portal.entites.User;
import com.gen.com.Insurance_portal.models.RequestModels.CreateProviderModel;
import com.gen.com.Insurance_portal.models.RequestModels.CreateUserModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseUserInfor;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-28T19:28:22+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_265 (AdoptOpenJDK)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User createUserModelToUser(CreateUserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        User user = new User();

        user.setSurname( userModel.getSurname() );
        user.setGivenName( userModel.getGivenName() );
        user.setUsername( userModel.getUsername() );
        user.setPassword( userModel.getPassword() );
        user.setPhoneNumber( userModel.getPhoneNumber() );
        user.setEmail( userModel.getEmail() );
        user.setGender( userModel.getGender() );
        user.setIdNumber( userModel.getIdNumber() );
        user.setAddress( userModel.getAddress() );

        return user;
    }

    @Override
    public ResponseUserInfor UserToUserInfor(User user) {
        if ( user == null ) {
            return null;
        }

        ResponseUserInfor responseUserInfor = new ResponseUserInfor();

        responseUserInfor.setId( user.getId() );
        responseUserInfor.setUsername( user.getUsername() );
        responseUserInfor.setEmail( user.getEmail() );
        responseUserInfor.setSurname( user.getSurname() );
        responseUserInfor.setGivenName( user.getGivenName() );
        responseUserInfor.setPhoneNumber( user.getPhoneNumber() );
        responseUserInfor.setRole( user.getRole() );

        return responseUserInfor;
    }

    @Override
    public User createProviderModelToUser(CreateProviderModel providerModel) {
        if ( providerModel == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( providerModel.getUsername() );
        user.setPassword( providerModel.getPassword() );
        user.setPhoneNumber( providerModel.getPhoneNumber() );
        user.setEmail( providerModel.getEmail() );
        user.setAddress( providerModel.getAddress() );

        return user;
    }
}
