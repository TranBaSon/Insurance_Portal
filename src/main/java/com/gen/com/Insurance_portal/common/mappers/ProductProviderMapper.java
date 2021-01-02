package com.gen.com.Insurance_portal.common.mappers;

import com.gen.com.Insurance_portal.entites.ProductProvider;
import com.gen.com.Insurance_portal.models.RequestModels.CreateProductProviderModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductProviderMapper {
    ProductProviderMapper INSTANCE = Mappers.getMapper(ProductProviderMapper.class);

    ProductProvider createProductProviderModelToProductProvider(CreateProductProviderModel productProviderModel);
}
