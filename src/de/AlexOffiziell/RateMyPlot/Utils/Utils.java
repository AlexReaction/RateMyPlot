package de.AlexOffiziell.RateMyPlot.Utils;

import com.github.intellectualsites.plotsquared.api.PlotAPI;
import de.AlexOffiziell.RateMyPlot.FileManagement.FileFactory;
import de.AlexOffiziell.RateMyPlot.FileManagement.FileHolder;

public class Utils {

    private static Utils instance = new Utils();


    public static PlotAPI plotAPI;


    public String getPrefix(){
        return "§8[§4RateMyPlot§8] ";
    } //TODO: get String from some config file

    public String getNoPerm(){
        return getPrefix() + "§4You have no permission to execute this command!";
    }

    public void createStandardConfigs(){
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.Background//minecraft:gray_stained_glass_pane");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.StandardVote.Material//minecraft:lime_wool");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.StandardVote.Name//%position Points");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.StandardVote.Lore//&aSelected!"); //TODO: Add multi line lores

        FileHolder.getInstance().standardItemConfig.add("VoteInventory.StandardVoteItem.Material//minecraft:white_wool");
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.StandardVoteItem.Name//%position Points"); //TODO: Add points counter for the name like 1 Point, 2 Points, 3 Points ...
        FileHolder.getInstance().standardItemConfig.add("VoteInventory.StandardVoteItem.Lore//&4Not selected");



        FileHolder.getInstance().items.generateStandart(FileHolder.getInstance().standardItemConfig, "//");
    }



    public static Utils getInstance() {
        return instance == null ? new Utils() : instance;
    }

}
