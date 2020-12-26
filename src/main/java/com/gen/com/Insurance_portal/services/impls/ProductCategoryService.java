package com.gen.com.Insurance_portal.services.impls;

import com.gen.com.Insurance_portal.entites.ProductCategory;
import com.gen.com.Insurance_portal.repositories.ProductCategoryRepository;
import com.gen.com.Insurance_portal.services.IProductCategoryService;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService extends AbstractService<ProductCategory> implements IProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        super(productCategoryRepository);
        this.productCategoryRepository = productCategoryRepository;
    }
}
