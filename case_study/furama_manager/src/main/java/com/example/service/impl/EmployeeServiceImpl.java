package com.example.service.impl;

import com.example.model.Division;
import com.example.model.EducationDegree;
import com.example.model.Employee;
import com.example.model.Position;
import com.example.repository.DivisionRepository;
import com.example.repository.EducationDegreeRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.PositionRepository;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;
    @Autowired
    private DivisionRepository divisionRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Position> findPosition() {
        return positionRepository.findAll();
    }

    @Override
    public List<EducationDegree> findEducationDegree() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public List<Division> findDivision() {
        return divisionRepository.findAll();
    }
}
