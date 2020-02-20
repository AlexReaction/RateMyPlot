package de.AlexOffiziell.RateMyPlot.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class InventoryManager {


    String name;
    int size;
    Inventory inventory;

    public InventoryManager(String name, int size){
        this.name = name;
        this.size = size;
    }


    public void createInventory(){
        this.inventory = Bukkit.createInventory(null, this.size, this.name);
    }

    public Inventory getInventory() {
        return inventory == null ? Bukkit.createInventory(null,9, "§4§lNo Inventory created (Standard Inventory showing)" ) : inventory; //TODO: Make this more beautiful
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
