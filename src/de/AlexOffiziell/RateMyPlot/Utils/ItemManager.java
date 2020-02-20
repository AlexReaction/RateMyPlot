package de.AlexOffiziell.RateMyPlot.Utils;

import de.AlexOffiziell.RateMyPlot.FileManagement.FileHolder;
import de.AlexOffiziell.RateMyPlot.Inventory.ItemFactory;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemManager {

    private static ItemManager manager = new ItemManager();


    public ItemFactory backgroundItem = new ItemFactory(Material.getMaterial(Utils.getInstance().getMaterialString((String) FileHolder.getInstance().items.getValue("VoteInventory.Background.Material"))),
            FileHolder.getInstance().items.getMinecraftString("VoteInventory.Background.Name"), Collections.emptyList());





    public static ItemManager getManager() {
        return manager == null ? new ItemManager() : manager;
    }
}
