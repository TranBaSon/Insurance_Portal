package com.gen.com.Insurance_portal.controllers.auth;

import com.gen.com.Insurance_portal.entites.ProductProvider;
import com.gen.com.Insurance_portal.models.RequestModels.CreateProductProviderModel;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateProductProviderModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseMessageModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseObjectModel;
import com.gen.com.Insurance_portal.services.IProductProviderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/partner")
public class PartnerController {

    private final IProductProviderService productProviderService;

    public PartnerController(IProductProviderService productProviderService) {
        this.productProviderService = productProviderService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateProductProviderModel productProviderModel) {
        productProviderService.save(productProviderModel);
        return new ResponseEntity<>(new ResponseMessageModel("succeed", "created!."), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<ProductProvider> providers = productProviderService.findAll();
        return new ResponseEntity<>(new ResponseObjectModel(true, providers), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(
                new ResponseObjectModel(true, productProviderService.findById(id)),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateProductProviderModel productProviderModel,
                                    @PathVariable Long id) {

        productProviderService.update(productProviderModel, id);

        return new ResponseEntity<>(new ResponseMessageModel("succeed", "updated!."), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        productProviderService.delete(id);

        return new ResponseEntity<>(new ResponseMessageModel("succeed", "deleted!."), HttpStatus.OK);
    }


}
