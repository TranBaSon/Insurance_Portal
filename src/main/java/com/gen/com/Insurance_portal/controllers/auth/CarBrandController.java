package com.gen.com.Insurance_portal.controllers.auth;

import com.gen.com.Insurance_portal.entites.CarBrand;
import com.gen.com.Insurance_portal.exceptions.NotFoundEntityException;
import com.gen.com.Insurance_portal.models.responseModels.ResponseMessageModel;
import com.gen.com.Insurance_portal.services.ICarBrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/car-brand")
public class CarBrandController {

    private final ICarBrandService carBrandService;

    public CarBrandController(ICarBrandService carBrandService) {
        this.carBrandService = carBrandService;
    }

    @PreAuthorize(value = "hasRole('All_Authorities')")
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(carBrandService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('All_Authorities')")
    @PostMapping
    public ResponseEntity<?> create( @RequestBody @Valid CarBrand carBrand){
        carBrandService.save(carBrand);
        return new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);

    }

    @PreAuthorize(value = "hasRole('All_Authorities')")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        CarBrand carBrand = carBrandService
                .findById(id).orElseThrow(() -> new NotFoundEntityException(id, "CarBrand"));
        return  new ResponseEntity<>(carBrand, HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('All_Authorities')")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody CarBrand carBrand){

        carBrandService.findById(id)
                .orElseThrow(() -> new NotFoundEntityException(id, "Menu"));
        carBrandService.update(carBrand);

        return  new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }

    @PreAuthorize(value = "hasRole('All_Authorities')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?>  delete(@PathVariable Long id){
        CarBrand carBrand = carBrandService
                .findById(id).orElseThrow(() -> new NotFoundEntityException(id, "CarBrand"));
        carBrandService.delete(carBrand);
        return  new ResponseEntity<>(new ResponseMessageModel(true), HttpStatus.OK);
    }
}
