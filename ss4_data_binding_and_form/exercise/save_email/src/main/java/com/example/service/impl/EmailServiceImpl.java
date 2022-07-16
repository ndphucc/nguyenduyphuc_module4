package com.example.service.impl;

import com.example.repository.EmailRepository;
import com.example.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    EmailRepository emailRepository;
    @Override
    public List<String> findLanguage() {
        return emailRepository.findLanguage();
    }

    @Override
    public List<Integer> findPageSize() {
        return emailRepository.findPageSize();
    }
}
