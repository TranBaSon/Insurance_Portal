package com.gen.com.Insurance_portal.common.mappers;

import com.gen.com.Insurance_portal.entites.ProductProvider;
import com.gen.com.Insurance_portal.models.RequestModels.CreateProductProviderModel;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-02T18:00:00+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_265 (AdoptOpenJDK)"
)
public class ProductProviderMapperImpl implements ProductProviderMapper {

    @Override
    public ProductProvider createProductProviderModelToProductProvider(CreateProductProviderModel productProviderModel) {
        if ( productProviderModel == null ) {
            return null;
        }

        ProductProvider productProvider = new ProductProvider();

        productProvider.setName( productProviderModel.getName() );
        productProvider.setCode( productProviderModel.getCode() );
        productProvider.setEmail( productProviderModel.getEmail() );
        productProvider.setPhoneNumber( productProviderModel.getPhoneNumber() );
        productProvider.setHotline( productProviderModel.getHotline() );
        productProvider.setIntroductionContent( productProviderModel.getIntroductionContent() );
        productProvider.setAppellation( productProviderModel.getAppellation() );
        productProvider.setContact( productProviderModel.getContact() );

        return productProvider;
    }
}
