package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static List<Product> list = new LinkedList<>();
    static {
        list.add(new Product(1,"abc",100,"ab","ab"));
        list.add(new Product(2,"abcf",100,"ab","ab"));
        list.add(new Product(3,"abcg",100,"ab","ab"));
        list.add(new Product(4,"abch",100,"ab","ab"));
    }
    @Override
    public List<Product> findAll() {
        Collections.sort(list);
        return list;
    }

    @Override
    public void add(Product product) {
        list.add(product);
    }

    @Override
    public void edit(Product product) {
        for (Product item: list) {
            if (product.equals(item)){
                list.remove(item);
                list.add(product);
                return;
            }
        }
    }

    @Override
    public void delete(Product product) {
        list.remove(product);
    }

    @Override
    public Product find(int id) {
        Product product = new Product(id);
        return list.get(list.indexOf(product));
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new LinkedList<>();
        for (Product product: list) {
            if (product.getName().contains(name)){
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public int getId() {
        int id = 1;
        if (list.isEmpty()){
            return id;
        }else {
            for (Product item:list) {
                if (item.getId()>id){
                    id=item.getId();
                }
            }
            return id+1;
        }
    }
}
