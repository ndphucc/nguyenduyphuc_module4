package com.example.service;

import com.example.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Optional<Blog> findById(int id);

    void delete(Blog blog);

    void update(Blog blog);
}
