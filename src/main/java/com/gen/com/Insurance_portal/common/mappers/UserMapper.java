package com.gen.com.Insurance_portal.common.mappers;

import com.gen.com.Insurance_portal.entites.User;
import com.gen.com.Insurance_portal.models.RequestModels.CreateUserModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseUserInfor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //User userModelToUser(UserModel userModel);

//    @Mappings({
//            @Mapping(target = "username", source = "username"),
//            @Mapping(target = "password", source = "password")
//    })

    User createUserModelToUser(CreateUserModel userModel);

    ResponseUserInfor UserToUserInfor(User user);

}
