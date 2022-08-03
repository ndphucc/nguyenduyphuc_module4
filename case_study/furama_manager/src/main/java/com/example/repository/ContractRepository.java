package com.example.repository;

import com.example.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select max(contract.id) from contract",nativeQuery = true )
    Integer findId();
}
