package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"","home"})
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    public String home(Model model){
        model.addAttribute("list",productService.findAll());
        model.addAttribute("product",new Product());
        return "list";
    }
    @GetMapping("/showEdit/{id}")
    public String showEdit(@PathVariable int id,Model model){
        model.addAttribute("product",productService.find(id));
        return "update";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product){
        productService.edit(product);
        return "redirect:/home";
    }
    @GetMapping("/showCreate")
    public String showCreate(Model model){
        model.addAttribute("product",new Product(productService.getId()));
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Product product){
        productService.add(product);
        return "redirect:/home";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id){
        productService.delete(new Product(id));
        return "redirect:/home";
    }
    @GetMapping("/search")
    public String search(@RequestParam String search,Model model){
        model.addAttribute("list",productService.findByName(search));
        return "list";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("viewProduct",productService.find(id));
        model.addAttribute("mes","true");
        return "redirect:/home";
    }
}
