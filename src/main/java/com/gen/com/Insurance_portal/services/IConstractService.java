package com.gen.com.Insurance_portal.services;

import com.gen.com.Insurance_portal.common.enums.ContractStatus;
import com.gen.com.Insurance_portal.entites.Contract;
import com.gen.com.Insurance_portal.models.RequestModels.ParamsModel;

public interface IConstractService extends IAbstractService<Contract> {
    Boolean existsByCode(String code);
    Object getList(ParamsModel paramsModel, Boolean forUser);
    Object UGetList(ParamsModel paramsModel, String token);
    void changeStatus(String code, ContractStatus contractStatus);
}
