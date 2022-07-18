package com.example.model;


public class Product implements Comparable{
    private int id;
    private String name;
    private double price;
    private String description;
    private String production;

    public Product() {
    }

    public Product(int id) {
        this.id = id;
    }

    public Product(int id, String name, double price, String description, String production) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.production = production;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Product) {
            if (this.id == ((Product) o).getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        if ((o instanceof Product) && (this.id > ( ((Product) o).id ))){
            return 1;
        }else {
            return -1;
        }
    }
}
