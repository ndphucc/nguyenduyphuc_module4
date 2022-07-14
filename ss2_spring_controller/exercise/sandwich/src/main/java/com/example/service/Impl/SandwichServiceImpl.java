package com.example.service.Impl;

import com.example.service.SandwichService;
import org.springframework.stereotype.Service;

@Service
public class SandwichServiceImpl implements SandwichService {

    @Override
    public String choose(String[] strings) {
        String result = "";
        for (int i = 0; i < strings.length; i++) {
            result += strings[i] + " ";
        }
        return result;
    }
}
