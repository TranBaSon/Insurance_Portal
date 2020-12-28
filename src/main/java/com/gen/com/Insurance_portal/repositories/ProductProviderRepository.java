package com.gen.com.Insurance_portal.repositories;

import com.gen.com.Insurance_portal.entites.ProductProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductProviderRepository extends JpaRepository<ProductProvider, Long> {
}
