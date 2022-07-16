package com.example.repository;

import com.example.model.MedicalDeclaration;

import java.util.List;

public interface MedicalDeclarationRepository {
    List<MedicalDeclaration> findAll();
    MedicalDeclaration findById(int id);
    void update(MedicalDeclaration medicalDeclaration);
    List<Integer> findYearOfBirth();
    List<Integer> findGender();
    List<String> findNationality();
    List<String> findVehicle();
    List<Integer> findDay();
    List<Integer> findMonth();
}
