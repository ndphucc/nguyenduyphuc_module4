package com.example.repository.impl;

import com.example.repository.DictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository {
    private static Map<String, String> map = new LinkedHashMap<>();

    static {
        map.put("Hello", "Xin chao");
        map.put("GoodBye", "Tam Biet");
        map.put("Dog", "Con cho");
        map.put("Cat", "Con meo");
        map.put("Bird", "Con chym");
    }

    @Override
    public Map<String, String> findAll() {
        return map;
    }
}
