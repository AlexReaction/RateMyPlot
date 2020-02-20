package de.AlexOffiziell.RateMyPlot.Commands;

import com.github.intellectualsites.plotsquared.plot.object.Plot;
import com.github.intellectualsites.plotsquared.plot.object.PlotPlayer;
import de.AlexOffiziell.RateMyPlot.CustomEvents.PlotRatedEvent;
import de.AlexOffiziell.RateMyPlot.Inventory.InventoryManager;
import de.AlexOffiziell.RateMyPlot.Inventory.ItemFactory;
import de.AlexOffiziell.RateMyPlot.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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


                    List<String> lores = new ArrayList<String>();
                    lores.add("§8 ");
                    lores.add("§8 ");
                    lores.add("§8 ");
                    lores.add("§a§lGEIL");
                    lores.add("§8 ");
                    lores.add("§8 ");
                    lores.add("§8 ");


                    ItemFactory item1 = new ItemFactory(Material.DIAMOND, "Vote", lores);
                    player.getInventory().addItem(item1.getItemStack());

                    ItemStack stack1 = new ItemStack(Material.DIAMOND_SWORD);
                    ItemMeta meta1 = stack1.getItemMeta();
                    assert meta1 != null : "ItemMeta is null";
                    meta1.setDisplayName("§4§lAxt Junge");
                    stack1.setItemMeta(meta1);
               //     player.getInventory().addItem(stack1);

                    InventoryManager inventoryManager = new InventoryManager("§a§lVote Inventory", 54); //TODO: Get name and size from config

                    player.openInventory(inventoryManager.createInventory());
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
