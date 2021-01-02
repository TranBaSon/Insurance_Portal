package com.gen.com.Insurance_portal.controllers.auth;

import com.gen.com.Insurance_portal.models.RequestModels.CreateProductModel;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateProductModel;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateProductProviderModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseMessageModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseObjectModel;
import com.gen.com.Insurance_portal.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> create(@ModelAttribute @Valid CreateProductModel productModel) throws ExecutionException, InterruptedException {
        productService.create(productModel);
        return new ResponseEntity<>(new ResponseMessageModel("succeed", "created!."), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(new ResponseObjectModel(true, productService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(
                new ResponseObjectModel(true, productService.findById(id)),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@ModelAttribute @Valid UpdateProductModel updateProductModel,
                                    @PathVariable Long id) throws ExecutionException, InterruptedException {

        productService.update(updateProductModel, id);

        return new ResponseEntity<>(new ResponseMessageModel("succeed", "updated!."), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        productService.delete(id);

        return new ResponseEntity<>(new ResponseMessageModel("succeed", "deleted!."), HttpStatus.OK);
    }

}
