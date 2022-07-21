package com.example.blog_manager.service.impl;

import com.example.blog_manager.model.Blog;
import com.example.blog_manager.repository.BlogRepository;
import com.example.blog_manager.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.deleteById(blog.getId());
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findByName(String name, Pageable pageable) {
        return blogRepository.findByName("%" + name + "%", pageable);
    }


}
