package com.example.phone_manger.controller;

import com.example.phone_manger.model.Phone;
import com.example.phone_manger.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    private IPhoneService iPhoneService;
    @PostMapping("/save")
    public ResponseEntity<Phone> save(@RequestBody Phone phone){
        return new ResponseEntity<>(iPhoneService.save(phone), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Phone>> findAll(){
        return new ResponseEntity<>(iPhoneService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Phone> findById(@PathVariable long id){
        if (iPhoneService.findById(id)==null){
            return new ResponseEntity<>(iPhoneService.findById(id),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iPhoneService.findById(id),HttpStatus.NO_CONTENT);

    }
    @PostMapping("/remove")
    public ResponseEntity<Phone> remove(@RequestBody Phone phone){
        return new ResponseEntity<>(iPhoneService.remove(phone),HttpStatus.NO_CONTENT);
    }
}
