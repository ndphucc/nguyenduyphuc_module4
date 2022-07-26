package com.example.repository;

import com.example.model.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
public interface FacilityTypeRepository extends JpaRepository<FacilityType,Integer> {
    @Query(value = "select * from facility_type ", nativeQuery = true)
    List<FacilityType> findFacilityType();
}
