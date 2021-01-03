package com.gen.com.Insurance_portal.services;

import com.gen.com.Insurance_portal.entites.Partner;
import com.gen.com.Insurance_portal.models.RequestModels.CreatePartnerModel;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateProductProviderModel;

public interface IPartnerService extends IAbstractService<Partner> {
    void save(CreatePartnerModel productProviderModel);
    void update(UpdateProductProviderModel productProviderModel, Long id);
    void toggleStatus(Long id);
}