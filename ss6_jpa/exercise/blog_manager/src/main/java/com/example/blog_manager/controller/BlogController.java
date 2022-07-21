package com.example.blog_manager.controller;

import com.example.blog_manager.model.Blog;
import com.example.blog_manager.service.BlogService;
import com.example.blog_manager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping({"", "home"})
    public String home(Model model, @PageableDefault(value = 2)Pageable pageable) {
        model.addAttribute("list", blogService.findAll(pageable));
        return "home";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", categoryService.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog) {
        blogService.update(blog);
        return "redirect:/home";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("blogView",blogService.findById(id));
//        model.addAttribute("list", blogService.findAll());
        return "home";
    }
    @GetMapping("/search")
    public String search(@RequestParam String search, Model model, @PageableDefault(value = 2)Pageable pageable){
        model.addAttribute("list",blogService.findByName(search,pageable));
        return "home";
    }

}
