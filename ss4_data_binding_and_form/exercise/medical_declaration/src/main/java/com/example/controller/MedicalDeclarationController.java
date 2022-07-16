package com.example.controller;

import com.example.model.MedicalDeclaration;
import com.example.service.MedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class MedicalDeclarationController {
    @Autowired
    MedicalDeclarationService medicalDeclarationService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("list", medicalDeclarationService.findAll());
        return "home";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam int id, Model model) {
        MedicalDeclaration medicalDeclaration = medicalDeclarationService.findById(id);
        model.addAttribute("medicalDeclaration", medicalDeclaration);
        model.addAttribute("years", medicalDeclarationService.findYearOfBirth());
        model.addAttribute("gender", medicalDeclarationService.findGender());
        model.addAttribute("nationality", medicalDeclarationService.findNationality());
        model.addAttribute("vehicle", medicalDeclarationService.findVehicle());
        model.addAttribute("month", medicalDeclarationService.findMonth());
        model.addAttribute("day", medicalDeclarationService.findDay());
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MedicalDeclaration medicalDeclaration, Model model) {
        medicalDeclarationService.update(medicalDeclaration);
        model.addAttribute("list", medicalDeclarationService.findAll());
        return "home";
    }
}
