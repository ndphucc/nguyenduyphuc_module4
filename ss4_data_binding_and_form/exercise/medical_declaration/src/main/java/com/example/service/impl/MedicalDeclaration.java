package com.example.service.impl;

import com.example.repository.MedicalDeclarationRepository;
import com.example.service.MedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDeclaration implements MedicalDeclarationService {
    @Autowired
    MedicalDeclarationRepository medicalDeclarationRepository;
    @Override
    public List<com.example.model.MedicalDeclaration> findAll() {
        return medicalDeclarationRepository.findAll();
    }

    @Override
    public com.example.model.MedicalDeclaration findById(int id) {
        return medicalDeclarationRepository.findById(id);
    }

    @Override
    public void update(com.example.model.MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepository.update(medicalDeclaration);
    }

    @Override
    public List<Integer> findYearOfBirth() {
        return medicalDeclarationRepository.findYearOfBirth();
    }

    @Override
    public List<Integer> findGender() {
        return medicalDeclarationRepository.findGender();
    }

    @Override
    public List<String> findNationality() {
        return medicalDeclarationRepository.findNationality();
    }

    @Override
    public List<String> findVehicle() {
        return medicalDeclarationRepository.findVehicle();
    }

    @Override
    public List<Integer> findDay() {
        return medicalDeclarationRepository.findDay();
    }

    @Override
    public List<Integer> findMonth() {
        return medicalDeclarationRepository.findMonth();
    }
}
