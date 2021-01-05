package com.gen.com.Insurance_portal.controllers.auth;

import com.gen.com.Insurance_portal.models.RequestModels.CreateProductModel;
import com.gen.com.Insurance_portal.models.RequestModels.ProductStatusRequest;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateProductModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseMessageModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseObjectModel;
import com.gen.com.Insurance_portal.services.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize(value = "hasRole('Product_Create')")
    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") })
    @PostMapping
    public ResponseEntity<?> create(@ModelAttribute @Valid CreateProductModel productModel) throws ExecutionException, InterruptedException {
        productService.create(productModel);
        return new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('Product_List')")
    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") }, description = "Get approved products, return: { name: String, code: String }")
    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(new ResponseObjectModel(true, productService.getList()), HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('Product_List')")
    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") }, description = "get all product")
    @GetMapping("/list")
    public ResponseEntity<?> getAllDetail() {
        return new ResponseEntity<>(new ResponseObjectModel(true, productService.findAll()), HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('Product_Detail')")
    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") })
    @GetMapping("/{code}")
    public ResponseEntity<?> getOne(@PathVariable String code) {
        return new ResponseEntity<>(
                new ResponseObjectModel(true, productService.findByCode(code)),
                HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('Product_Detail')")
    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") })
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(
                new ResponseObjectModel(true, productService.findById(id)),
                HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('Product_Edit')")
    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") })
    @PutMapping("/id/{id}")
    public ResponseEntity<?> update(@ModelAttribute @Valid UpdateProductModel updateProductModel,
                                    @PathVariable Long id) throws ExecutionException, InterruptedException {

        productService.update(updateProductModel, id);

        return new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }


    @PreAuthorize(value = "hasRole('Product_Delete')")
    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") })
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        productService.delete(id);

        return new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('Product_Edit')")
    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") })
    @PutMapping("{code}")
    public ResponseEntity<?> update(@ModelAttribute @Valid UpdateProductModel updateProductModel,
                                    @PathVariable String code) throws ExecutionException, InterruptedException {

        productService.updateByCode(updateProductModel, code);

        return new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('Product_Delete')")
    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") })
    @DeleteMapping("/{code}")
    public ResponseEntity<?> delete(@PathVariable String code) {

        productService.deleteByCode(code);

        return new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('Product_Status')")
    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") })
    @PostMapping("/status")
    public ResponseEntity<?> status(@PathVariable String code, ProductStatusRequest statusRequest) {

        productService.deleteByCode(code);

        return new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }

}
