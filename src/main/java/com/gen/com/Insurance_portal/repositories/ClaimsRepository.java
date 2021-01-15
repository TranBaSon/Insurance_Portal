package com.gen.com.Insurance_portal.repositories;

import com.gen.com.Insurance_portal.entites.Claims;
import com.gen.com.Insurance_portal.entites.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimsRepository extends JpaRepository<Claims, Long> {
    Page<Claims> findAllByContractCode(String contractCode, Pageable pageable);

    Page<Claims> findAllByContractCodeAndCustomerCode(String contractCode, String customerCode, Pageable pageable);

    Page<Claims> findAllByCustomerCode(String customerCode, Pageable pageable);

}
