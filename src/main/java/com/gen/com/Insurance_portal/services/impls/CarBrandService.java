package com.gen.com.Insurance_portal.services.impls;

import com.gen.com.Insurance_portal.entites.CarBrand;
import com.gen.com.Insurance_portal.entites.CarModel;
import com.gen.com.Insurance_portal.exceptions.MessageException;
import com.gen.com.Insurance_portal.exceptions.NotFoundEntityExceptionByCode;
import com.gen.com.Insurance_portal.models.RequestModels.CarBrandModel;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateCarBrandModel;
import com.gen.com.Insurance_portal.repositories.CarBrandRepository;
import com.gen.com.Insurance_portal.services.ICarBrandService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarBrandService extends AbstractService<CarBrand> implements ICarBrandService {
    private final CarBrandRepository carBrandRepository;

    public CarBrandService(CarBrandRepository carBrandRepository) {
        super(carBrandRepository);
        this.carBrandRepository = carBrandRepository;
    }

    @Override
    public void create(CarBrandModel carBrandModel) {

        CarBrand carBrand = new CarBrand();

        Set<CarModel> collect = carBrandModel.getModels().stream().map(m -> {
            m.setCarBrand(carBrand);
            return m;
        }).collect(Collectors.toSet());

        carBrand.setCarBrand(carBrandModel.getCarBrand());
        carBrand.setCarBrandCode(carBrandModel.getCarBrandCode());
        carBrand.setModels(collect);
        save(carBrand);
    }

    @Override
    public void update(UpdateCarBrandModel carBrandModel, String code) {
        CarBrand carBrand = carBrandRepository.findByCarBrandCode(code)
                .orElseThrow(() -> new NotFoundEntityExceptionByCode(code, "CarBrand"));

        if(carBrandRepository.existsCarBrandByCarBrandCodeAndIdNot(carBrandModel.getCarBrandCode(), carBrand.getId())) {
            throw new MessageException("code already exists");
        }

        Set<CarModel> collect = carBrandModel.getModels().stream().map(m -> {
            m.setCarBrand(carBrand);
            return m;
        }).collect(Collectors.toSet());

        carBrand.getModels().retainAll(collect);
        if (Strings.isNotEmpty(carBrandModel.getCarBrand())){
            carBrand.setCarBrand(carBrandModel.getCarBrand());
        }
        if (Strings.isNotEmpty(carBrandModel.getCarBrandCode())){
            carBrand.setCarBrandCode(carBrandModel.getCarBrandCode());
        }
        carBrand.getModels().addAll(carBrandModel.getModels());
        update(carBrand);
    }

    @Override
    public Optional<CarBrand> findByCarBrandCode(String code) {
        return carBrandRepository.findByCarBrandCode(code);
    }


}
