package com.example.dto;

import java.util.Map;

public class TotalDto {
    private int idFacility;
    private Map<String, String> map;

    public TotalDto() {
    }

    public TotalDto(int idFacility, Map<String, String> map) {
        this.idFacility = idFacility;
        this.map = map;
    }

    public int getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(int idFacility) {
        this.idFacility = idFacility;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
