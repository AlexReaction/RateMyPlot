package de.AlexOffiziell.RateMyPlot.Commands;

import com.github.intellectualsites.plotsquared.plot.object.Plot;
import com.github.intellectualsites.plotsquared.plot.object.PlotPlayer;
import de.AlexOffiziell.RateMyPlot.Cache.ConfigCache;
import de.AlexOffiziell.RateMyPlot.Core.Main;
import de.AlexOffiziell.RateMyPlot.CustomEvents.PlotRatedEvent;
import de.AlexOffiziell.RateMyPlot.FileManagement.FileHolder;
import de.AlexOffiziell.RateMyPlot.FileManagement.InventoryItem;
import de.AlexOffiziell.RateMyPlot.Inventory.InventoryManager;
import de.AlexOffiziell.RateMyPlot.Inventory.ItemFactory;
import de.AlexOffiziell.RateMyPlot.Utils.ItemManager;
import de.AlexOffiziell.RateMyPlot.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class Info_CMD implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission("RateMyPlot.VotePlot")) {
                //TODO: CREATE PLOT SQUARED SUB COMMAND!


                //CHECKS IF PLAYER IS ON VALID PLOT
                PlotPlayer plotPlayer = PlotPlayer.wrap(player);
                if (plotPlayer != null) {


                    Bukkit.getPluginManager().callEvent(new PlotRatedEvent(player, new int[]{1, 4, 2, 5, 1, 6}));
                    Plot currPlot = plotPlayer.getCurrentPlot();


                    InventoryManager inventoryManager = new InventoryManager();
                    inventoryManager.createInventory();
                    for (int i = 0;i<54;i++) {
                        inventoryManager.getInventory().setItem(i,ItemManager.getManager().backgroundItem.getItemStack());

                    }
                    //TESTING
                    for (Map.Entry<String, InventoryItem> entry : Main.configCache.getConfigCache().entrySet()){
                        player.sendMessage("Key: " + entry.getKey());
                        player.sendMessage("Value: " + entry.getValue().getName() + " " + entry.getValue().getValue());
                        player.sendMessage("------");
                    }

                    //TESTING END


                    inventoryManager.getInventory().setItem(10, ItemManager.getManager().vote1.getItemStack());
                    inventoryManager.getInventory().setItem(19, ItemManager.getManager().vote2.getItemStack());
                    inventoryManager.getInventory().setItem(28, ItemManager.getManager().vote3.getItemStack());
                    inventoryManager.getInventory().setItem(37, ItemManager.getManager().vote4.getItemStack());
                    inventoryManager.getInventory().setItem(38, ItemManager.getManager().standardVote.getItemStack());
                    inventoryManager.getInventory().setItem(39, ItemManager.getManager().current.getItemStack());





                    player.openInventory(inventoryManager.getInventory());

                    player.sendMessage(String.valueOf(currPlot == null ? Utils.getInstance().getPrefix() + "§4§lBitte stelle dich eindeutig auf das Plot" : currPlot.owner == null ? "Dieses Plot gehört keinem" : currPlot.getOwners()));


                }
            }else{
                player.sendMessage(Utils.getInstance().getNoPerm());
            }
        } else {
            System.out.println(Utils.getInstance().getPrefix() + " you have to be a player to execute commands!");
            return false;
        }

        return false;
    }
}
