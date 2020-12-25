package com.gen.com.Insurance_portal.repositories;

import com.gen.com.Insurance_portal.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
