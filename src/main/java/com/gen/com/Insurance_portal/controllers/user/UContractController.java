package com.gen.com.Insurance_portal.controllers.user;

import com.gen.com.Insurance_portal.models.RequestModels.ParamsModel;
import com.gen.com.Insurance_portal.services.IConstractService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/u/contract")
public class UContractController {
    private final IConstractService constractService;

    public UContractController(IConstractService constractService) {
        this.constractService = constractService;
    }

    @Operation(summary = "Required Header { Authorization : bearer key }",security = { @SecurityRequirement(name = "bearer key") })
    @GetMapping
    public ResponseEntity<?> getAllFormat(
            @Parameter(name = "filter", description = "optional field, structure ?fillter={code or status},{value} \n" +
                    "-> if status: value in {Active, Expired, Cancelled, Inactive}")
            @RequestParam(required = false) String filter,
            @Parameter(name = "page", description = "optional field, The default page is 1")
            @RequestParam(defaultValue = "1") int page,
            @Parameter(name = "size", description = "optional field, the size of a default page is 10")
            @RequestParam(defaultValue = "10") int size,
            @Parameter(name = "sort", description = "optional field, syntax=field...,{desc/asc}")
            @RequestParam(defaultValue = "id,desc") String[] sort) {

        Object response = constractService.getList(new ParamsModel(filter, page, size, sort), true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}