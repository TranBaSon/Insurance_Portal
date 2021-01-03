package com.gen.com.Insurance_portal.repositories;

import com.gen.com.Insurance_portal.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCode (String code);
    Boolean existsByNameOrCode(String name, String code);
    Boolean existsByNameOrCodeAndIdNot(String name, String code, Long id);
}
