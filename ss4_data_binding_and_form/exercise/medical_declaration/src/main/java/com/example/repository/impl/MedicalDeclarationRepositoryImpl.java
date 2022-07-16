package com.example.repository.impl;

import com.example.model.MedicalDeclaration;
import com.example.repository.MedicalDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class MedicalDeclarationRepositoryImpl implements MedicalDeclarationRepository {
    static List<MedicalDeclaration> medicalDeclarations = new LinkedList<>();

    static {
        medicalDeclarations.add(new MedicalDeclaration(1, "Truong Ngoc Huyen", "1997", "199898781"));
        medicalDeclarations.add(new MedicalDeclaration(2, "Truong Ngoc Huyen", "1997", "199898781"));
        medicalDeclarations.add(new MedicalDeclaration(3, "Truong Ngoc Huyen", "1997", "199898781"));
        medicalDeclarations.add(new MedicalDeclaration(4, "Truong Ngoc Huyen", "1997", "199898781"));
    }

    @Override
    public List<MedicalDeclaration> findAll() {
        return medicalDeclarations;
    }

    @Override
    public MedicalDeclaration findById(int id) {
        for (MedicalDeclaration item : medicalDeclarations) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void update(MedicalDeclaration medicalDeclaration) {
        for (MedicalDeclaration item : medicalDeclarations) {
            if (item.getId() == medicalDeclaration.getId()) {
                medicalDeclarations.remove(item);
                medicalDeclarations.add(medicalDeclaration);
            }
        }
    }

    @Override
    public List<Integer> findYearOfBirth() {
        List<Integer> yearList = new LinkedList<>();
        yearList.add(1990);
        yearList.add(1991);
        yearList.add(1992);
        yearList.add(1993);
        yearList.add(1994);
        yearList.add(1995);
        yearList.add(1996);
        yearList.add(1997);
        yearList.add(1998);
        yearList.add(1999);
        yearList.add(2000);
        yearList.add(2001);
        yearList.add(2002);
        yearList.add(2003);
        yearList.add(2004);
        yearList.add(2005);
        yearList.add(2006);
        yearList.add(2007);
        yearList.add(2008);
        return yearList;
    }

    @Override
    public List<Integer> findGender() {
        List<Integer> genderList = new LinkedList<>();
        genderList.add(0);
        genderList.add(1);
        return genderList;
    }

    @Override
    public List<String> findNationality() {
        List<String> nationalityList = new LinkedList<>();
        nationalityList.add("Viet Nam");
        nationalityList.add("Lao");
        nationalityList.add("Trung Quoc");
        return nationalityList;
    }

    @Override
    public List<String> findVehicle() {
        List<String> vehicleList = new LinkedList<>();
        vehicleList.add("tau bay");
        vehicleList.add("tau thuyen");
        vehicleList.add("o to");
        vehicleList.add("khac");
        return vehicleList;
    }

    @Override
    public List<Integer> findDay() {
        List<Integer> dayList = new LinkedList<>();
        dayList.add(1);
        dayList.add(2);
        dayList.add(3);
        dayList.add(4);
        dayList.add(5);
        dayList.add(6);
        dayList.add(7);
        dayList.add(8);
        dayList.add(9);
        dayList.add(10);
        dayList.add(11);
        dayList.add(12);
        dayList.add(13);
        dayList.add(14);
        dayList.add(15);
        dayList.add(16);
        dayList.add(17);
        dayList.add(18);
        dayList.add(19);
        dayList.add(20);
        dayList.add(21);
        dayList.add(22);
        dayList.add(23);
        dayList.add(24);
        dayList.add(25);
        dayList.add(26);
        dayList.add(27);
        dayList.add(28);
        dayList.add(29);
        dayList.add(30);
        dayList.add(31);
        return dayList;
    }

    @Override
    public List<Integer> findMonth() {
        List<Integer> monthList = new LinkedList<>();
        monthList.add(1);
        monthList.add(2);
        monthList.add(3);
        monthList.add(4);
        monthList.add(5);
        monthList.add(6);
        monthList.add(7);
        monthList.add(8);
        monthList.add(9);
        monthList.add(10);
        monthList.add(11);
        monthList.add(12);
        return monthList;
    }

}
