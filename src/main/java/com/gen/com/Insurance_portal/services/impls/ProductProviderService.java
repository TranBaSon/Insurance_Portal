package com.gen.com.Insurance_portal.services.impls;

import com.gen.com.Insurance_portal.common.mappers.ProductProviderMapper;
import com.gen.com.Insurance_portal.entites.ProductProvider;
import com.gen.com.Insurance_portal.exceptions.NotFoundEntityException;
import com.gen.com.Insurance_portal.models.RequestModels.CreateProductProviderModel;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateProductProviderModel;
import com.gen.com.Insurance_portal.repositories.ProductProviderRepository;
import com.gen.com.Insurance_portal.services.IProductProviderService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class ProductProviderService extends AbstractService<ProductProvider> implements IProductProviderService {

    private final ProductProviderRepository productProviderRepository;

    public ProductProviderService(ProductProviderRepository productProviderRepository) {
        super(productProviderRepository);
        this.productProviderRepository = productProviderRepository;
    }


    @Override
    public void save(CreateProductProviderModel productProviderModel) {
        ProductProvider provider = ProductProviderMapper.INSTANCE
                                   .createProductProviderModelToProductProvider(productProviderModel);

        this.save(provider);
    }


    @Override
    public void update(UpdateProductProviderModel productProviderModel, Long id) {
        ProductProvider provider = this.findById(id)
                .orElseThrow(() -> new NotFoundEntityException(id, "Partner"));

        if (!Strings.isBlank(productProviderModel.getCode())) {
            provider.setCode(productProviderModel.getCode());
        }
        if (!Strings.isBlank(productProviderModel.getAppellation())) {
            provider.setAppellation(productProviderModel.getAppellation());
        }
        if (!Strings.isBlank(productProviderModel.getImages())) {
            provider.setAvatarImage(productProviderModel.getImages());
        }
        if (!Strings.isBlank(productProviderModel.getContact())) {
            provider.setContact(productProviderModel.getContact());
        }
        if (!Strings.isBlank(productProviderModel.getHotline())) {
            provider.setHotline(productProviderModel.getHotline());
        }
        if (!Strings.isBlank(productProviderModel.getName())) {
            provider.setName(productProviderModel.getName());
        }
        if (!Strings.isBlank(productProviderModel.getPhoneNumber())) {
            provider.setPhoneNumber(productProviderModel.getPhoneNumber());
        }
        if (!Strings.isBlank(productProviderModel.getPhoneNumber())) {
            provider.setPhoneNumber(productProviderModel.getPhoneNumber());
        }

        this.update(provider);
    }

    @Override
    public void toggleStatus(Long id) {
        ProductProvider provider = this.findById(id)
                .orElseThrow(() -> new NotFoundEntityException(id, "Partner"));
        provider.setIsActive(!provider.getIsActive());
        update(provider);
    }

}
