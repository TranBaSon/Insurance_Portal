package com.gen.com.Insurance_portal.controllers.auth;

import com.gen.com.Insurance_portal.entites.CarModel;
import com.gen.com.Insurance_portal.exceptions.NotFoundEntityExceptionByCode;
import com.gen.com.Insurance_portal.models.RequestModels.CarModelRequest;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateCarModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseMessageModel;
import com.gen.com.Insurance_portal.services.ICarModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/car-model")
public class CarModelController {

    private final ICarModelService carModelService;

    public CarModelController(ICarModelService carModelService) {
        this.carModelService = carModelService;
    }


    @PreAuthorize(value = "hasRole('All_Authorities')")
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(carModelService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('All_Authorities')")
    @PostMapping
    public ResponseEntity<?> create( @RequestBody @Valid CarModelRequest carModel){
        carModelService.create(carModel);
        return new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('All_Authorities')")
    @GetMapping("/{code}")
    public ResponseEntity<?> get(@PathVariable String code){
        CarModel carModel = carModelService
                .findByCode(code).orElseThrow(() -> new NotFoundEntityExceptionByCode(code, "CarModel"));
        return  new ResponseEntity<>(carModel, HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('All_Authorities')")
    @PutMapping("/{code}")
    public ResponseEntity<?> update(@PathVariable String code, @Valid @RequestBody UpdateCarModel carModel){

        carModelService.findByCode(code)
                .orElseThrow(() -> new NotFoundEntityExceptionByCode(code, "Menu"));
        carModelService.update(carModel, code);

        return  new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('All_Authorities')")
    @DeleteMapping("/{code}")
    public ResponseEntity<?>  delete(@PathVariable String code){
        CarModel carModel = carModelService
                .findByCode(code).orElseThrow(() -> new NotFoundEntityExceptionByCode(code, "CarBrand"));
        carModelService.delete(carModel);
        return  new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }
}
