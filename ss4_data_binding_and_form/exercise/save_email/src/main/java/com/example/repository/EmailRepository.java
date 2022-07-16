package com.example.repository;

import java.util.List;

public interface EmailRepository {
    List<String> findLanguage();

    List<Integer> findPageSize();
}
