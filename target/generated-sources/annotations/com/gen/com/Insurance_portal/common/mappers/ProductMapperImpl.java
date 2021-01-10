package com.gen.com.Insurance_portal.common.mappers;

import com.gen.com.Insurance_portal.entites.Product;
import com.gen.com.Insurance_portal.models.RequestModels.CreateProductModel;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateProductModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseProductModel;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-10T15:13:57+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_265 (AdoptOpenJDK)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product createProductModelToProduct(CreateProductModel productModel) {
        if ( productModel == null ) {
            return null;
        }

        Product product = new Product();

        product.setGenderApply( productModel.getGenderApply() );
        product.setName( productModel.getName() );
        product.setCode( productModel.getCode() );
        product.setShortDescription( productModel.getShortDescription() );
        product.setDetailedDescription( productModel.getDetailedDescription() );
        product.setEffectiveDateRangeSelectionNumber( productModel.getEffectiveDateRangeSelectionNumber() );
        product.setPriceObj( productModel.getPriceObj() );

        return product;
    }

    @Override
    public Product updateProductModelToProduct(UpdateProductModel productModel) {
        if ( productModel == null ) {
            return null;
        }

        Product product = new Product();

        product.setGenderApply( productModel.getGenderApply() );
        product.setName( productModel.getName() );
        product.setCode( productModel.getCode() );
        product.setShortDescription( productModel.getShortDescription() );
        product.setDetailedDescription( productModel.getDetailedDescription() );
        product.setEffectiveDateRangeSelectionNumber( productModel.getEffectiveDateRangeSelectionNumber() );
        product.setPriceObj( productModel.getPriceObj() );

        return product;
    }

    @Override
    public ResponseProductModel ProductModelToProductResponse(Product productModel) {
        if ( productModel == null ) {
            return null;
        }

        ResponseProductModel responseProductModel = new ResponseProductModel();

        responseProductModel.setName( productModel.getName() );
        responseProductModel.setCode( productModel.getCode() );

        return responseProductModel;
    }
}
