package com.example.phone_manger.service;

import com.example.phone_manger.model.Phone;
import com.example.phone_manger.repository.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService implements IPhoneService{
    @Autowired
    private IPhoneRepository phoneRepository;
    @Override
    public Phone save(Phone phone) {
        phoneRepository.save(phone);
        return phone;
    }

    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone findById(long id) {
        return phoneRepository.findById(id).get();
    }

    @Override
    public Phone remove(Phone phone) {
        phoneRepository.delete(phone);
        return phone;
    }
}
