package com.example.controller;

import com.example.service.ContractService;
import com.example.service.CustomerService;
import com.example.service.EmployeeService;
import com.example.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private FacilityService facilityService;
    @GetMapping("/list")
    public String findAll(Model model){
        model.addAttribute("list",contractService.findAll());
        model.addAttribute("employeeList",employeeService.findAll());
        model.addAttribute("customerList",customerService.findAll(Pageable.unpaged()));
        model.addAttribute("facilityList",facilityService.findAll(Pageable.unpaged()));
        model.addAttribute("attachFacilityList",contractService.findAttachFacility());
        return "contract/list";
    }
}
