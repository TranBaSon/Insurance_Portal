package com.gen.com.Insurance_portal.repositories;

import com.gen.com.Insurance_portal.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
