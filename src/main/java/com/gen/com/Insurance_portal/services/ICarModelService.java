package com.gen.com.Insurance_portal.services;

import com.gen.com.Insurance_portal.entites.CarModel;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateCarModel;

import java.util.Optional;

public interface ICarModelService extends IAbstractService<CarModel> {
    Optional<CarModel> findByCode(String code);
    void create(com.gen.com.Insurance_portal.models.RequestModels.CarModel carModel);
    void update(UpdateCarModel carModel);
}
