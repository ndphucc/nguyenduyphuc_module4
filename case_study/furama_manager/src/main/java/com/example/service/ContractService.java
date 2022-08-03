package com.example.service;

import com.example.dto.ContractDto;
import com.example.dto.TotalDto;
import com.example.model.AttachFacility;
import com.example.model.Contract;
import com.example.model.ContractDetail;
import com.example.model.Facility;

import java.util.List;
import java.util.Map;

public interface ContractService {
    Map<Contract, Double> findAll();
    List<AttachFacility> findAttachFacility();

    List<ContractDetail> findContractDetail(int id);

    double calculateTotal(TotalDto totalDto);

    AttachFacility findAttachById(int id);
    Facility findFacilityById(int id);
    Contract copyContract(ContractDto contractDto);

    Contract save(Contract contract);
}
