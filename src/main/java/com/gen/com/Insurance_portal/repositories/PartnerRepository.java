package com.gen.com.Insurance_portal.repositories;

import com.gen.com.Insurance_portal.entites.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    Boolean existsByNameOrCode(String name, String code);
    Boolean existsByNameOrCodeAndIdNot(String name, String code, Long id);
}
