package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestfulController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/list")
    public Repon
    @PostMapping("/create")
    public ResponseEntity<?> save(@Valid @RequestBody EmployeeDto employeeDto, BindingResult bindingResult) {
        new EmployeeDto().validate(employeeDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            Map<String, String> error = new LinkedHashMap<>();
            for (FieldError item:bindingResult.getFieldErrors()) {
                String field = item.getField();
                String mes = item.getDefaultMessage();
                error.put(field,mes);
            }
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        }
    }
}
