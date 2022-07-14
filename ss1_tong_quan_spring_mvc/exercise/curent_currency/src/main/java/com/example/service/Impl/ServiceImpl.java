package com.example.service.Impl;

import com.example.service.MoneyService;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements MoneyService {

    @Override
    public double current(double usd) {
        return usd * 22000;
    }
}
