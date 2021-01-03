package com.gen.com.Insurance_portal.controllers.auth;

import com.gen.com.Insurance_portal.entites.Partner;
import com.gen.com.Insurance_portal.models.RequestModels.CreatePartnerModel;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateProductProviderModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseMessageModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseObjectModel;
import com.gen.com.Insurance_portal.services.IPartnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/partner")
public class PartnerController {

    private final IPartnerService productProviderService;

    public PartnerController(IPartnerService productProviderService) {
        this.productProviderService = productProviderService;
    }

    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") })
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreatePartnerModel productProviderModel) {
        productProviderService.save(productProviderModel);
        return new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }

    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") })
    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Partner> providers = productProviderService.findAll();
        return new ResponseEntity<>(new ResponseObjectModel(true, providers), HttpStatus.OK);
    }

    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") })
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(
                new ResponseObjectModel(true, productProviderService.findById(id)),
                HttpStatus.OK);
    }

    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") })
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateProductProviderModel productProviderModel,
                                    @PathVariable Long id) {

        productProviderService.update(productProviderModel, id);

        return new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }


    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        productProviderService.delete(id);

        return new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }


}
