package com.oracle.cloud.product;

public class ProductInfo {
    private String name;
    private String description;
    private InventoryInfo stock;

    public ProductInfo() {
    }

    public ProductInfo(String name, InventoryInfo stock) {
        this.name = name;
        this.description = "Description for "+ this.name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public InventoryInfo getStock() {
        return stock;
    }
    
    
}
