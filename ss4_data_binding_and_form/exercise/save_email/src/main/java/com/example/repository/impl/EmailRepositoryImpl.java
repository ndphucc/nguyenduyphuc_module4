package com.example.repository.impl;

import com.example.repository.EmailRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
@Repository
public class EmailRepositoryImpl implements EmailRepository {
    @Override
    public List<String> findLanguage() {
        List<String> languages = new LinkedList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        return languages;
    }

    @Override
    public List<Integer> findPageSize() {
        List<Integer> pageSize = new LinkedList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
        return pageSize;
    }
}
