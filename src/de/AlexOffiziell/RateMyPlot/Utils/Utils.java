package de.AlexOffiziell.RateMyPlot.Utils;

import com.github.intellectualsites.plotsquared.api.PlotAPI;
import de.AlexOffiziell.RateMyPlot.FileManagement.FileFactory;
import de.AlexOffiziell.RateMyPlot.FileManagement.FileHolder;
import org.bukkit.ChatColor;

public class Utils {

    private static Utils instance = new Utils();


    public static PlotAPI plotAPI;


    public String getPrefix(){
        return "§8[§4RateMyPlot§8] ";
    } //TODO: get String from some config file

    public String getNoPerm(){
        return getPrefix() + "§4You have no permission to execute this command!";
    }

    public void createStandardConfigs(){ //TODO: Add multi line lores

        //Inventory Settings
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.Inventory.Name//&aVoting");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.Inventory.Size//54");

        //Background Item
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.Background.Material//minecraft:gray_stained_glass_pane");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.Background.Name//&8 []");

        //Currently choosen Items
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.CurrentVote.Material//minecraft:lime_wool");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.CurrentVote.Name//%position Points");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.CurrentVote.Lore//&aSelected!");

        //Standard Vote Item
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.StandardVoteItem.Material//minecraft:white_wool");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.StandardVoteItem.Name//%position Points"); //TODO: Add points counter for the name like 1 Point, 2 Points, 3 Points ...
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.StandardVoteItem.Lore//&4Not selected");

        //Vote Category 1
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.VoteCategory.1.Material//minecraft:diamond_sword");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.VoteCategory.1.Name//&a&lCreativity");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.VoteCategory.1.Lore//&3 1=Not creative at all -> 6 extremely creative");

        //Vote Category 2
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.VoteCategory.2.Material//minecraft:compass");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.VoteCategory.2.Name//&a&lDetails");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.VoteCategory.2.Lore//&3 1=No details at all -> 6 extremely detailed");

        //Vote Category 3
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.VoteCategory.3.Material//minecraft:diamond_block");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.VoteCategory.3.Name//&a&lVariety of Materials");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.VoteCategory.3.Lore//&3 1=No variety at all -> 6 extreme variety");

        //Vote Category 4
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.VoteCategory.4.Material//minecraft:turtle_egg");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.VoteCategory.4.Name//&a&lIDK");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.VoteCategory.4.Lore//&3 1=bad -> 6 extremely good");

        FileHolder.getInstance().items.generateStandart(FileHolder.getInstance().standardItemConfig, "//");
    }



    public String getMaterialString(String rawInput){
        return rawInput == null ? "-1" : rawInput.replace("minecraft:","").toUpperCase();
    }

    public String getColorMSG(String input){
        return ChatColor.translateAlternateColorCodes('&', input);
    }


    public static Utils getInstance() {
        return instance == null ? new Utils() : instance;
    }

}
