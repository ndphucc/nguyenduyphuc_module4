package com.example.service;

import com.example.model.Facility;
import com.example.model.FacilityType;
import com.example.model.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FacilityService {
    Page<Facility> findAll(Pageable pageable);

    void save(Facility facility);


    void remove(int id);

    List<FacilityType> findFacilityType();

    List<RentType> findRentType();
    Facility findById(int id);

}
