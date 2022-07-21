package com.example.blog_manager.service;

import com.example.blog_manager.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Optional<Blog> findById(int id);

    void delete(Blog blog);

    void update(Blog blog);
    Page<Blog> findByName(String name,Pageable pageable);
}
