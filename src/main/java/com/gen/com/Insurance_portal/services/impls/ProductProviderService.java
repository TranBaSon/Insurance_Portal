package com.gen.com.Insurance_portal.services.impls;

import com.gen.com.Insurance_portal.entites.ProductProvider;
import com.gen.com.Insurance_portal.repositories.ProductProviderRepository;
import com.gen.com.Insurance_portal.services.IProductProviderService;
import org.springframework.stereotype.Service;

@Service
public class ProductProviderService extends AbstractService<ProductProvider> implements IProductProviderService {

    private final ProductProviderRepository productProviderRepository;

    public ProductProviderService(ProductProviderRepository productProviderRepository) {
        super(productProviderRepository);
        this.productProviderRepository = productProviderRepository;
    }
}
