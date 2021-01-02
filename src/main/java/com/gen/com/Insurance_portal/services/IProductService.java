package com.gen.com.Insurance_portal.services;

import com.gen.com.Insurance_portal.entites.Product;
import com.gen.com.Insurance_portal.models.RequestModels.CreateProductModel;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateProductModel;

import java.util.concurrent.ExecutionException;

public interface IProductService extends IAbstractService<Product> {

    void create(CreateProductModel productModel) throws ExecutionException, InterruptedException;
    void update(UpdateProductModel productModel, Long id) throws ExecutionException, InterruptedException;
}
