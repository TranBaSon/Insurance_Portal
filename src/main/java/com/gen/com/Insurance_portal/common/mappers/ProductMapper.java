package com.gen.com.Insurance_portal.common.mappers;

import com.gen.com.Insurance_portal.entites.Product;
import com.gen.com.Insurance_portal.models.RequestModels.CreateProductModel;
import com.gen.com.Insurance_portal.models.RequestModels.PrimitiveModel;
import com.gen.com.Insurance_portal.models.RequestModels.PrimitiveUpdateModel;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateProductModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


    @Mapping(target = "insuredRule", ignore = true)
    @Mapping(target = "bannerImage", ignore = true)
    @Mapping(target = "avatarImage", ignore = true)
    @Mapping(target = "genderApply", source = "genderApply")
    Product createProductModelToProduct(PrimitiveModel productModel);

    @Mapping(target = "insuredRule", ignore = true)
    @Mapping(target = "bannerImage", ignore = true)
    @Mapping(target = "avatarImage", ignore = true)
    @Mapping(target = "genderApply", source = "genderApply")
    Product updateProductModelToProduct(PrimitiveUpdateModel productModel);

    ResponseProductModel ProductModelToProductResponse(Product productModel);
}
