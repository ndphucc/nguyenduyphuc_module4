package com.example.controller;

import com.example.model.Email;
import com.example.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class EmailController {
    @Autowired
    EmailService emailService;

    @GetMapping("/home")
    public String home(Model model) {
        String[] spams = {"true","false"};
        model.addAttribute("email", new Email("Vietnamese",25,true,"Thor,King,Asgard"));
        model.addAttribute("languages",emailService.findLanguage());
        model.addAttribute("pageSizes",emailService.findPageSize());
        model.addAttribute("spams",spams);
        return "home";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Email email, Model model){
        model.addAttribute("email",email);
        return "update";
    }

}
