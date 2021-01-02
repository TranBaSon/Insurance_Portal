package com.gen.com.Insurance_portal.services;

import com.gen.com.Insurance_portal.entites.ProductProvider;
import com.gen.com.Insurance_portal.models.RequestModels.CreateProductProviderModel;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateProductProviderModel;

public interface IProductProviderService extends IAbstractService<ProductProvider> {
    void save(CreateProductProviderModel productProviderModel);
    void update(UpdateProductProviderModel productProviderModel, Long id);
    void toggleStatus(Long id);
}
