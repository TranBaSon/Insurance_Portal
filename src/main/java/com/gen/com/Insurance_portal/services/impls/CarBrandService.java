package com.gen.com.Insurance_portal.services.impls;

import com.gen.com.Insurance_portal.entites.CarBrand;
import com.gen.com.Insurance_portal.repositories.CarBrandRepository;
import com.gen.com.Insurance_portal.services.ICarBrandService;
import org.springframework.stereotype.Service;

@Service
public class CarBrandService extends AbstractService<CarBrand> implements ICarBrandService {
    private final CarBrandRepository carBrandRepository;

    public CarBrandService(CarBrandRepository carBrandRepository) {
        super(carBrandRepository);
        this.carBrandRepository = carBrandRepository;
    }
}
