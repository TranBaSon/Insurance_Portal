package com.gen.com.Insurance_portal.repositories;

import com.gen.com.Insurance_portal.entites.TransactionHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {
    Optional<TransactionHistory> findByTransactionCode(String code);
    Page<TransactionHistory> findAllByContractCode(String code, Pageable pageable);

}
