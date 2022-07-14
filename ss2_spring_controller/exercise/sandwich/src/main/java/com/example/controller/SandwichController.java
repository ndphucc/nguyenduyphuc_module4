package com.example.controller;

import com.example.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @Autowired
    SandwichService sandwichService;
    @PostMapping("/sandwich")
    public String resultSelect(@RequestParam(value = "condiment",defaultValue = "") String[] condiment, Model model){
        model.addAttribute("result",sandwichService.choose(condiment));
        return "home";
    }
    @GetMapping("")
    public String getHome(){
        return "home";
    }
}
