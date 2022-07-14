package com.example.controler;

import com.example.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/find")
    public String find(@RequestParam Optional<String> english, Model model) {
        String result = dictionaryService.find(english.orElse(""));
        model.addAttribute("result", result);
        return "home";
    }

    @GetMapping("")
    public String returnHome() {
        return "home";
    }
}
