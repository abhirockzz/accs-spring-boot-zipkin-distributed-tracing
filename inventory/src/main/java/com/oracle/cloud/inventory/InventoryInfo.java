package com.oracle.cloud.inventory;

public class InventoryInfo {
    private int inventory;
    private final static String node = System.getenv().getOrDefault("APAAS_CONTAINER_NAME", "node1");

    public InventoryInfo() {
    }

    
    public InventoryInfo(int inventory) {
        this.inventory = inventory;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
    
    public String getNode() {
        return node;
    }


}
