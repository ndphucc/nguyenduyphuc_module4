package com.example.controller;

import com.example.dto.ContractDto;
import com.example.dto.TotalDto;
import com.example.model.Contract;
import com.example.model.ContractDetail;
import com.example.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contract")
public class ContractRestfulController {
    @Autowired
    private ContractService contractService;

    @GetMapping("{id}")
    public ResponseEntity<List<ContractDetail>> findContractDetail(@PathVariable int id) {
        List<ContractDetail> contractDetails = contractService.findContractDetail(id);
        if (contractDetails == null) {
            return new ResponseEntity<>(contractDetails, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(contractDetails, HttpStatus.OK);
        }
    }

    @RequestMapping(
            value = "/total",
            method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> calculateTotal(
            @RequestBody TotalDto totalDto) {
        System.out.println(totalDto);
         return new ResponseEntity<>(contractService.calculateTotal(totalDto), HttpStatus.OK);
    }
    @PostMapping(value = "/create",consumes = "application/json")
    public ResponseEntity<Contract> savaContract(@RequestBody ContractDto newContractDto){
        contractService.save(contractService.copyContract(newContractDto));
        return new ResponseEntity<>(contractService.save(contractService.copyContract(newContractDto)),HttpStatus.CREATED);
    }
}

