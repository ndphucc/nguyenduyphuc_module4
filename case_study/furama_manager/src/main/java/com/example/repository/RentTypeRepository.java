package com.example.repository;

import com.example.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentTypeRepository extends JpaRepository<RentType,Integer> {
    @Query(value = "select * from rent_type ", nativeQuery = true)
    List<RentType> findRentType();
}
