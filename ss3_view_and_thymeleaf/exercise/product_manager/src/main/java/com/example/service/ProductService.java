package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void add(Product product);

    void edit(Product product);

    void delete(Product product);

    Product find(int id);

    List<Product> findByName(String name);

    int getId();
}
