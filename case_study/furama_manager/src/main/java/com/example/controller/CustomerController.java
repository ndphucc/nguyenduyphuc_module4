package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("list")
    public String showList(@PageableDefault(value = 5) Pageable pageable, Model model){
        model.addAttribute("list",customerService.findAll(pageable));
        model.addAttribute("customerType",customerService.findCustomerType());
        return "customer/list";
    }
    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        model.addAttribute("customerTypeList",customerService.findCustomerType());
        return "customer/create";
    }
    @PostMapping("create")
    public String create(@ModelAttribute CustomerDto customerDto){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        return "redirect:/customer/list";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id,Model model){
        model.addAttribute("customerDto",customerService.findById(id));
        model.addAttribute("customerTypeList",customerService.findCustomerType());
        return "customer/edit";
    }
}
