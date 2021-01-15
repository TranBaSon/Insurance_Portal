package com.gen.com.Insurance_portal.common.mappers;

import com.gen.com.Insurance_portal.entites.Claims;
import com.gen.com.Insurance_portal.models.RequestModels.RequiredClaimsModel;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-15T18:49:52+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_265 (AdoptOpenJDK)"
)
public class ClaimsMapperImpl implements ClaimsMapper {

    @Override
    public Claims requiredClaimsModelToClaim(RequiredClaimsModel requiredClaimsModel) {
        if ( requiredClaimsModel == null ) {
            return null;
        }

        Claims claims = new Claims();

        claims.setContractCode( requiredClaimsModel.getContractCode() );
        claims.setName( requiredClaimsModel.getName() );
        claims.setNumberPlate( requiredClaimsModel.getNumberPlate() );
        claims.setRepaintFee( requiredClaimsModel.getRepaintFee() );
        claims.setRepaintFeeAmount( requiredClaimsModel.getRepaintFeeAmount() );
        claims.setBringingFee( requiredClaimsModel.getBringingFee() );
        claims.setBringingFeeAmount( requiredClaimsModel.getBringingFeeAmount() );
        claims.setRearViewMirror( requiredClaimsModel.getRearViewMirror() );
        claims.setRearViewMirrorAmount( requiredClaimsModel.getRearViewMirrorAmount() );
        claims.setComponentFee( requiredClaimsModel.getComponentFee() );
        claims.setComponentFeeAmount( requiredClaimsModel.getComponentFeeAmount() );
        claims.setScratchedFee( requiredClaimsModel.getScratchedFee() );
        claims.setScratchedFeeAmount( requiredClaimsModel.getScratchedFeeAmount() );
        claims.setEmployeeName( requiredClaimsModel.getEmployeeName() );
        claims.setEmployeePhoneNumber( requiredClaimsModel.getEmployeePhoneNumber() );
        claims.setNote( requiredClaimsModel.getNote() );

        return claims;
    }
}
