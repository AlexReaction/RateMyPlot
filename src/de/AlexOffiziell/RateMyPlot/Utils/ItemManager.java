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


    public ItemFactory backgroundItem = new ItemFactory(Material.getMaterial(Utils.getInstance().getMaterialString((String) FileHolder.getInstance().items.getValue("VoteInventory.Background.Material"))), FileHolder.getInstance().items.getMinecraftString("VoteInventory.Background.Name"), "");
    public ItemFactory current = new ItemFactory(Material.getMaterial(Utils.getInstance().getMaterialString((String) FileHolder.getInstance().items.getValue("VoteInventory.CurrentVote.Material"))), FileHolder.getInstance().items.getMinecraftString("VoteInventory.CurrentVote.Name"), FileHolder.getInstance().items.getMinecraftString("VoteInventory.CurrentVote.Lore"));
    public ItemFactory standardVote = new ItemFactory(Material.getMaterial(Utils.getInstance().getMaterialString((String) FileHolder.getInstance().items.getValue("VoteInventory.StandardVote.Material"))), FileHolder.getInstance().items.getMinecraftString("VoteInventory.StandardVote.Name"), FileHolder.getInstance().items.getMinecraftString("VoteInventory.StandardVote.Lore"));
    public ItemFactory vote1 = new ItemFactory(Material.getMaterial(Utils.getInstance().getMaterialString((String) FileHolder.getInstance().items.getValue("VoteInventory.VoteCategory.1.Material"))), FileHolder.getInstance().items.getMinecraftString("VoteInventory.VoteCategory.1.Name"), FileHolder.getInstance().items.getMinecraftString("VoteInventory.VoteCategory.1.Lore"));
    public ItemFactory vote2 = new ItemFactory(Material.getMaterial(Utils.getInstance().getMaterialString((String) FileHolder.getInstance().items.getValue("VoteInventory.VoteCategory.2.Material"))), FileHolder.getInstance().items.getMinecraftString("VoteInventory.VoteCategory.2.Name"), FileHolder.getInstance().items.getMinecraftString("VoteInventory.VoteCategory.2.Lore"));
    public ItemFactory vote3 = new ItemFactory(Material.getMaterial(Utils.getInstance().getMaterialString((String) FileHolder.getInstance().items.getValue("VoteInventory.VoteCategory.3.Material"))), FileHolder.getInstance().items.getMinecraftString("VoteInventory.VoteCategory.3.Name"), FileHolder.getInstance().items.getMinecraftString("VoteInventory.VoteCategory.3.Lore"));
    public ItemFactory vote4 = new ItemFactory(Material.getMaterial(Utils.getInstance().getMaterialString((String) FileHolder.getInstance().items.getValue("VoteInventory.VoteCategory.4.Material"))), FileHolder.getInstance().items.getMinecraftString("VoteInventory.VoteCategory.4.Name"), FileHolder.getInstance().items.getMinecraftString("VoteInventory.VoteCategory.4.Lore"));




    public static ItemManager getManager() {
        return manager == null ? new ItemManager() : manager;
    }
}
