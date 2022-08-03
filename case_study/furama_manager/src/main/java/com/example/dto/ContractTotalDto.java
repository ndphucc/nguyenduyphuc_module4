package com.example.dto;

import com.example.model.Contract;

import java.util.LinkedHashMap;
import java.util.Map;

public class ContractTotalDto {
    private Map<Contract,Double> contractDoubleMap = new LinkedHashMap<>();

    public ContractTotalDto(Map<Contract, Double> contractDoubleMap) {
        this.contractDoubleMap = contractDoubleMap;
    }

    public ContractTotalDto() {
    }

    public Map<Contract, Double> getContractDoubleMap() {
        return contractDoubleMap;
    }

    public void setContractDoubleMap(Map<Contract, Double> contractDoubleMap) {
        this.contractDoubleMap = contractDoubleMap;
    }
}
