package com.restful_blog.controller;

import com.restful_blog.model.Blog;
import com.restful_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/api/v1")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Blog> save(@RequestBody Blog blog){
        blogService.save(blog);
        return new ResponseEntity<>(blog,HttpStatus.CREATED);
    }

    @PutMapping ("/edit")
    public ResponseEntity edit(@RequestBody Blog blog) {
        if (blog == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        blogService.update(blog.getId(),blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping ("/delete")
    public ResponseEntity delete(@RequestParam int id) {
        blogService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
