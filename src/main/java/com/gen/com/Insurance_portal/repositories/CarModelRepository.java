package com.gen.com.Insurance_portal.repositories;

import com.gen.com.Insurance_portal.entites.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    Optional<CarModel> findByCode(String code);
    Boolean existsByCode(String code);
}
