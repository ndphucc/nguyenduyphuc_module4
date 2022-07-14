package com.example.service.impl;

import com.example.repository.DictionaryRepository;
import com.example.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    DictionaryRepository repository;

    @Override
    public String find(String str) {
        Map<String, String> map = repository.findAll();
        if (map.get(str) != null) {
            return map.get(str);
        } else {
            return "Khong tim thay";
        }
    }
}
