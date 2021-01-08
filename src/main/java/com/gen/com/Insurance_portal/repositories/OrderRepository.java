package com.gen.com.Insurance_portal.repositories;

import com.gen.com.Insurance_portal.entites.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
