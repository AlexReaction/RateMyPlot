package de.AlexOffiziell.RateMyPlot.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class InventoryManager {


    String name;
    int size;

    public InventoryManager(String name, int size){
        this.name = name;
        this.size = size;
    }


    public Inventory createInventory(){
        return Bukkit.createInventory(null, this.size, this.name);
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
