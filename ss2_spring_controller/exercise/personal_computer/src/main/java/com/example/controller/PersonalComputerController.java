package com.example.controller;

import com.example.service.PersonComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonalComputerController {
    @Autowired
    PersonComputerService personComputerService;
    @GetMapping("")
    public String getHome() {
        return "home";
    }
    @PostMapping("/calculator")
    public String calculator(@RequestParam("numberFirst") double numberFirth, double numberSecond, String calculation, Model model){
        double result = personComputerService.calculator(numberFirth,numberSecond,calculation);
        model.addAttribute("result",result);
        return "home";
    }
}
