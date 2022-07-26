package com.example.service;

import com.example.model.Customer;
import com.example.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    void save(Customer customer);
    void remove(int id);
    Customer findById(int id);
    List<CustomerType> findCustomerType();
}
