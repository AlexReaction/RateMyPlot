package de.AlexOffiziell.RateMyPlot.Inventory;

import de.AlexOffiziell.RateMyPlot.FileManagement.FileHolder;
import de.AlexOffiziell.RateMyPlot.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class InventoryManager {


    String name;
    int size;
    Inventory inventory;

    public InventoryManager(){
        this.name = Utils.getInstance().getColorMSG((String) FileHolder.getInstance().items.getValue("VoteInventory.Inventory.Name")); //TODO Cache those values earlier so you don't have to read from the file all the time
        this.size = Integer.parseInt(Utils.getInstance().getColorMSG((String) FileHolder.getInstance().items.getValue("VoteInventory.Inventory.Size")));;
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
