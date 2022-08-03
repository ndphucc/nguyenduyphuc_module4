package com.example.service.impl;

import com.example.dto.ContractDto;
import com.example.dto.TotalDto;
import com.example.model.*;
import com.example.repository.*;
import com.example.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ContractDetailRepository contractDetailRepository;
    @Autowired
    private AttachFacilityRepository attachFacilityRepository;
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Map<Contract, Double> findAll() {
        Map<Contract, Double> contractDoubleMap = new LinkedHashMap<>();
        List<Contract> contractList = contractRepository.findAll();
        List<ContractDetail> contractDetails = contractDetailRepository.findAll();
        for (Contract contract : contractList) {
            double total = 0;
            for (ContractDetail contractDetail : contractDetails) {
                if (contract.getId() == contractDetail.getContract().getId()) {
                    total += contractDetail.getQuantity() * contractDetail.getAttachFacility().getCost();
                }
            }
            total += contract.getFacility().getCost();
            contractDoubleMap.put(contract, total);
        }
        return contractDoubleMap;
    }


    @Override
    public List<AttachFacility> findAttachFacility() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public List<ContractDetail> findContractDetail(int id) {
        return contractDetailRepository.findContractDetail(id);
    }

    @Override
    public double calculateTotal(TotalDto totalDto) {
        double result = 0;
        for (String id : totalDto.getMap().keySet()) {
            if (Integer.parseInt(totalDto.getMap().get(id)) > 0) {
                result += findAttachById(Integer.parseInt(id)).getCost() * Integer.parseInt(totalDto.getMap().get(id));
            }
        }
        if (findFacilityById(totalDto.getIdFacility()) != null) {
            result += findFacilityById(totalDto.getIdFacility()).getCost();
        }
        return result;
    }

    @Override
    public AttachFacility findAttachById(int id) {
        return attachFacilityRepository.findById(id).get();
    }

    @Override
    public Facility findFacilityById(int id) {
        return facilityRepository.findById(id).get();
    }

    @Override
    public Contract copyContract(ContractDto contractDto) {
        Facility facility = facilityRepository.findById(contractDto.getFacility()).get();
        Customer customer = customerRepository.findById(contractDto.getCustomer()).get();
        Employee employee = employeeRepository.findById(contractDto.getEmployee()).get();
        Set<ContractDetail> set = new LinkedHashSet<>();
        for (String id:contractDto.getContractDetail().keySet()) {
            int quantity = Integer.parseInt(contractDto.getContractDetail().get(id));
            AttachFacility attachFacility = attachFacilityRepository.findById(Integer.parseInt(id)).get();
            set.add(new ContractDetail(quantity,attachFacility));
        }
        return new Contract(contractDto.getStartDate(),contractDto.getEndDate(),contractDto.getDeposit(),customer,employee,facility,set);
    }

    @Override
    public Contract save(Contract contract) {
        contractRepository.save(contract);
        for (ContractDetail item:contract.getContractDetails()) {
            contractDetailRepository.save(new ContractDetail(item.getQuantity(),contractRepository.findById(findId()).get(),item.getAttachFacility()));
        }
        return contract;
    }

    public Integer findId(){
        return contractRepository.findId();
    }

}
