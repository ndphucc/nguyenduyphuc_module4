package com.example.dto;

import java.util.Map;

public class ContractDto {
    private String startDate;
    private String endDate;
    private double deposit;
    private int customer;
    private int employee;
    private int facility;
    private Map<String,String> contractDetail;

    public ContractDto() {
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public int getFacility() {
        return facility;
    }

    public void setFacility(int facility) {
        this.facility = facility;
    }

    public Map<String, String> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(Map<String, String> contractDetail) {
        this.contractDetail = contractDetail;
    }
}
