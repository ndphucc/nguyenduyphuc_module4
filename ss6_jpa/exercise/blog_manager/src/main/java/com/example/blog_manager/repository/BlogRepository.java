package com.example.blog_manager.repository;

import com.example.blog_manager.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where name like : name",nativeQuery = true)
    Page<Blog> findByName(@Param("name") String name,Pageable pageable);
}
