package com.gen.com.Insurance_portal.services.impls;

import com.gen.com.Insurance_portal.entites.CarBrand;
import com.gen.com.Insurance_portal.entites.CarModel;
import com.gen.com.Insurance_portal.exceptions.NotFoundEntityException;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateCarModel;
import com.gen.com.Insurance_portal.repositories.CarModelRepository;
import com.gen.com.Insurance_portal.services.ICarBrandService;
import com.gen.com.Insurance_portal.services.ICarModelService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarModelService extends AbstractService<CarModel> implements ICarModelService {
    private final CarModelRepository carModelRepository;
    private final ICarBrandService carBrandService;

    public CarModelService(CarModelRepository carModelRepository,
                           ICarBrandService carBrandService) {
        super(carModelRepository);
        this.carModelRepository = carModelRepository;
        this.carBrandService = carBrandService;
    }

    @Override
    public Optional<CarModel> findByCode(String code) {
        return carModelRepository.findByCode(code);
    }

    @Override
    public void create(com.gen.com.Insurance_portal.models.RequestModels.CarModel carModel) {
        CarBrand carBrand = carBrandService
                .findById(carModel.getCarBrandId()).orElseThrow(() -> new NotFoundEntityException(carModel.getCarBrandId(), "CarBrand"));

        CarModel carModel1 = new CarModel();
        carModel1.setCarBrand(carBrand);
        carModel1.setCode(carModel.getCode());
        carModel1.setName(carModel.getName());
        carModel1.setPercent(carModel.getPercent());
        save(carModel1);
    }

    @Override
    public void update(UpdateCarModel carModel) {
        CarModel carModel1 = new CarModel();

        CarBrand carBrand = null;

        if (carModel.getCarBrandId() != null) {
            carBrand = carBrandService
                    .findById(carModel.getCarBrandId()).orElseThrow(() -> new NotFoundEntityException(carModel.getCarBrandId(), "CarBrand"));
            carModel1.setCarBrand(carBrand);
        }

        if (Strings.isNotEmpty(carModel.getCode())) {
            carModel1.setCode(carModel.getCode());
        }
        if (Strings.isNotEmpty(carModel.getName())) {
            carModel1.setName(carModel.getName());
        }
        if (carModel.getPercent() != null) {
            carModel1.setPercent(carModel.getPercent());
        }
        update(carModel);
    }
}
