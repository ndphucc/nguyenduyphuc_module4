package com.example.service;

import com.example.model.Division;
import com.example.model.EducationDegree;
import com.example.model.Employee;
import com.example.model.Position;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void remove(int id);

    List<Position> findPosition();
    List<EducationDegree> findEducationDegree();
    List<Division> findDivision();

}
