package com.gen.com.Insurance_portal.controllers.auth;

import com.gen.com.Insurance_portal.entites.CarModel;
import com.gen.com.Insurance_portal.exceptions.NotFoundEntityException;
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
    public ResponseEntity<?> create( @RequestBody @Valid com.gen.com.Insurance_portal.models.RequestModels.CarModel carModel){
        carModelService.create(carModel);
        return new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('All_Authorities')")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        CarModel carModel = carModelService
                .findById(id).orElseThrow(() -> new NotFoundEntityException(id, "CarModel"));
        return  new ResponseEntity<>(carModel, HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('All_Authorities')")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdateCarModel carModel){

        carModelService.findById(id)
                .orElseThrow(() -> new NotFoundEntityException(id, "Menu"));
        carModelService.update(carModel);

        return  new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('All_Authorities')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?>  delete(@PathVariable Long id){
        CarModel carModel = carModelService
                .findById(id).orElseThrow(() -> new NotFoundEntityException(id, "CarBrand"));
        carModelService.delete(carModel);
        return  new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }
}
