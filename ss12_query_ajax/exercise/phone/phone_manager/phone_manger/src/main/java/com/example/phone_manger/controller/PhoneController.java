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
        Phone phone = iPhoneService.findById(id);
        if (phone==null){
            return new ResponseEntity<>(phone,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(phone,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Phone> remove(@PathVariable long id){
        Phone phone = iPhoneService.findById(id);
        if (phone==null){
            return new ResponseEntity<>(phone,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iPhoneService.remove(phone),HttpStatus.OK);
    }
}
