package com.example.blog_manager.service;

import com.example.blog_manager.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    void Save(Category category);

    void delete(Category category);
}
