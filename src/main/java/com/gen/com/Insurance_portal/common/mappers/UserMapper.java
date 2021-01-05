package com.gen.com.Insurance_portal.common.mappers;

import com.gen.com.Insurance_portal.entites.User;
import com.gen.com.Insurance_portal.models.RequestModels.CreateProviderModel;
import com.gen.com.Insurance_portal.models.RequestModels.CreateUserModel;
import com.gen.com.Insurance_portal.models.responseModels.CustomerResponseModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseUserInfor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User createUserModelToUser(CreateUserModel userModel);

    ResponseUserInfor UserToUserInfor(User user);

    User createProviderModelToUser(CreateProviderModel providerModel);

    CustomerResponseModel userToCustomerResponse(User providerModel);

}
