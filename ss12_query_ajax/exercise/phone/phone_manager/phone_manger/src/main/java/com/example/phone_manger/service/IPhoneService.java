package com.example.phone_manger.service;

import com.example.phone_manger.model.Phone;

import java.util.List;

public interface IPhoneService {
    Phone save(Phone phone);
    List<Phone> findAll();
    Phone findById(long id);
    Phone remove(Phone phone);

}
