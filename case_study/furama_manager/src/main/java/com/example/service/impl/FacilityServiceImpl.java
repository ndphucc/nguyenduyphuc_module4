package com.example.service.impl;

import com.example.model.Facility;
import com.example.model.FacilityType;
import com.example.model.RentType;
import com.example.repository.FacilityRepository;
import com.example.repository.FacilityTypeRepository;
import com.example.repository.RentTypeRepository;
import com.example.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private FacilityTypeRepository facilityTypeRepository;
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public void save(Facility facility) {
        if (facility.getFacilityType().getId()==1){
            facility.setFacilityFree(null);
        }else if (facility.getFacilityType().getId()==2){
            facility.setPoolArea(0);
            facility.setFacilityFree(null);
        }else {
            facility.setStandardRoom(null);
            facility.setDescriptionOtherConvenience(null);
            facility.setPoolArea(0);
            facility.setNumberOfFloors(0);
        }
        facilityRepository.save(facility);
    }

    @Override
    public void remove(int id) {
        facilityRepository.remove(id);
    }
    @Override
    public List<FacilityType> findFacilityType() {
        return facilityTypeRepository.findFacilityType();
    }

    @Override
    public List<RentType> findRentType() {
        return rentTypeRepository.findRentType();
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).get();
    }
}
