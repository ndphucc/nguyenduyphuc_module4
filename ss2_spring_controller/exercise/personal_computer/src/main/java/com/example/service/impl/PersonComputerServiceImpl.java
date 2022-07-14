package com.example.service.impl;

import com.example.service.PersonComputerService;
import org.springframework.stereotype.Service;


@Service
public class PersonComputerServiceImpl implements PersonComputerService {
    @Override
    public double calculator(double numberFirth, double numberSecond, String calculator) {
        switch (calculator){
            case "+":
                return numberFirth+numberSecond;
            case "-":
                return numberFirth-numberSecond;
            case "*":
                return numberFirth*numberSecond;
            case "/":
                return numberFirth/numberSecond;
            default:
                return 0;
        }
    }
}
