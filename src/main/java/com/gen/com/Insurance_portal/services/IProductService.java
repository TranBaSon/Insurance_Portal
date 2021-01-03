package com.gen.com.Insurance_portal.services;

import com.gen.com.Insurance_portal.entites.Product;
import com.gen.com.Insurance_portal.models.RequestModels.CreateProductModel;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateProductModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseProductModel;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IProductService extends IAbstractService<Product> {

    void create(CreateProductModel productModel) throws ExecutionException, InterruptedException;
    void update(UpdateProductModel productModel, Long id) throws ExecutionException, InterruptedException;
    Product findByCode (String code);
    List<ResponseProductModel> getList();
    void updateByCode(UpdateProductModel productModel, String code) throws ExecutionException, InterruptedException;
    void deleteByCode(String code);
}