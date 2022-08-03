package com.example.repository;

import com.example.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Query(value = "select * from contract_detail where contract_id =:id",nativeQuery = true)
    List<ContractDetail> findContractDetail(@Param("id") int id);
}
