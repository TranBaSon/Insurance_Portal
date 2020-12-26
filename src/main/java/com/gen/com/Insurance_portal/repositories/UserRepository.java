package com.gen.com.Insurance_portal.repositories;

import com.gen.com.Insurance_portal.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Boolean existsByPhoneNumber(String phoneNumber);

    User findUserByPhoneNumber(String phoneNumber);

    Boolean existsByUsernameOrPhoneNumberOrEmail(String username, String phoneNumber, String email);
}
