package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void add(Product product);

    void edit(Product product);

    void delete(Product product);

    Product find(int id);

    List<Product> findByName(String name);

    int getId();
}
