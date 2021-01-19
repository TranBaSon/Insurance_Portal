package com.gen.com.Insurance_portal.services.impls;

import com.gen.com.Insurance_portal.entites.CarBrand;
import com.gen.com.Insurance_portal.entites.CarModel;
import com.gen.com.Insurance_portal.exceptions.MessageException;
import com.gen.com.Insurance_portal.exceptions.NotFoundEntityExceptionByCode;
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
    public void create(com.gen.com.Insurance_portal.models.RequestModels.CarModelRequest carModel) {
        CarBrand carBrand = carBrandService.findByCarBrandCode(carModel.getCarBrandCode())
                .orElseThrow(() -> new NotFoundEntityExceptionByCode(carModel.getCarBrandCode(), "CarBrand"));

        if (carModelRepository.existsByCode(carModel.getCode())) {
            throw new MessageException("code already exist!");
        }

        CarModel carModel1 = new CarModel();
        carModel1.setCarBrand(carBrand);
        carModel1.setCode(carModel.getCode());
        carModel1.setTitle(carModel.getTitle());
        carModel1.setPrice(carModel.getPrice());
        save(carModel1);
    }

    @Override
    public void update(UpdateCarModel carModel, String code) {
       CarModel carModel1 = carModelRepository.findByCode(code)
               .orElseThrow(() -> new NotFoundEntityExceptionByCode(code, "CarModel"));

        CarBrand carBrand = null;

        if (Strings.isNotBlank(carModel.getCarBrandCode())) {
            carBrand = carBrandService.findByCarBrandCode(carModel.getCarBrandCode())
                    .orElseThrow(() -> new NotFoundEntityExceptionByCode(carModel.getCarBrandCode(), "CarBrand"));
            carModel1.setCarBrand(carBrand);
        }

        if (Strings.isNotEmpty(carModel.getCode())) {
            carModel1.setCode(carModel.getCode());
        }
        if (Strings.isNotEmpty(carModel.getTitle())) {
            carModel1.setTitle(carModel.getTitle());
        }
        if (carModel.getPrice() != null) {
            carModel1.setPrice(carModel.getPrice());
        }
        update(carModel1);
    }
}
