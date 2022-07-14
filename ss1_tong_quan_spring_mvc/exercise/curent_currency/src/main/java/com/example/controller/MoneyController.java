package com.example.controller;

import com.example.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyController {
    @Autowired
    MoneyService moneyService;


    @GetMapping("/current")
    public String count(@RequestParam String usd, Model model) {
        double temp = Double.parseDouble(usd);
        double result = moneyService.current(temp);
        model.addAttribute("usd", usd);
        model.addAttribute("result", result);
        return "index";
    }

    @GetMapping("")
    public String result() {
        return "index";
    }
}
