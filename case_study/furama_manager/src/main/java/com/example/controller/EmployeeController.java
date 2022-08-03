package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("positionList",employeeService.findPosition());
        model.addAttribute("educationDegreeList",employeeService.findEducationDegree());
        model.addAttribute("divisionList",employeeService.findDivision());
        return "/employee/home";
    }


}
