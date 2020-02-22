package de.AlexOffiziell.RateMyPlot.Core;

import com.github.intellectualsites.plotsquared.api.PlotAPI;
import de.AlexOffiziell.RateMyPlot.Cache.ConfigCache;
import de.AlexOffiziell.RateMyPlot.Commands.Info_CMD;
import de.AlexOffiziell.RateMyPlot.Events.PlotRated_Listener;
import de.AlexOffiziell.RateMyPlot.FileManagement.FileFactory;
import de.AlexOffiziell.RateMyPlot.FileManagement.FileHolder;
import de.AlexOffiziell.RateMyPlot.FileManagement.InventoryItem;
import de.AlexOffiziell.RateMyPlot.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;


public class Main extends JavaPlugin {
    static Main instance;
    public static ConfigCache configCache;

    /*
    TODO: Custom events
    TODO: Responsive Inventory -> user can choose how many vote categories, the more categories the bigger the inventory has to be! (LOW PRIORITY)
    TODO: Cache values from config and only update them on start (HIGH PRIORITY)
    */

    @Override
    public void onEnable() {
        instance = this;



        FileHolder.getInstance().messages.createFile();
        FileHolder.getInstance().items.createFile();
        Utils.getInstance().createStandardConfigs();

        System.out.println(Utils.getInstance().getPrefix() + "activated");
        Objects.requireNonNull(this.getCommand("hallo")).setExecutor(new Info_CMD());
        this.getServer().getPluginManager().registerEvents(new PlotRated_Listener(), this);
        getPlotAPI();
        initiateCache();
        super.onEnable();
    }



    @Override
    public void onDisable() {
        System.out.println(Utils.getInstance().getPrefix() + "deactivated");
        super.onDisable();
    }




    private void getPlotAPI() {

        PluginManager manager = Bukkit.getServer().getPluginManager();
        final Plugin plotsquared = manager.getPlugin("PlotSquared");

        // Disable the plugin if PlotSquared is not installed

        // If you move any PlotSquared related tasks to an external class you
        // wouldn't have to disable the plugin if PlotSquared wasn't installed

        if(plotsquared != null && !plotsquared.isEnabled()) {
            System.out.println("&c[ExamplePlugin] Could not find PlotSquared! Disabling plugin...");
            manager.disablePlugin(this);
            return;
        }

        // Do PlotSquared related stuff
        Utils.plotAPI = new PlotAPI();

    }


    private void initiateCache(){
        configCache = new ConfigCache();
        configCache.addPairToCache("Background_Material", InventoryItem.MATERIAL_BACKGROUND);
        configCache.addPairToCache("Selected_Material", InventoryItem.MATERIAL_CURRENTLY_SELECTED);
        configCache.addPairToCache("Not_Selected_Material", InventoryItem.MATERIAL_CURRENTLY_NOT_SELECTED);
        configCache.addPairToCache("Vote_1_Material", InventoryItem.MATERIAL_VOTE_CATEGORY_1);
        configCache.addPairToCache("Vote_2_Material", InventoryItem.MATERIAL_VOTE_CATEGORY_2);
        configCache.addPairToCache("Vote_3_Material", InventoryItem.MATERIAL_VOTE_CATEGORY_3);
        configCache.addPairToCache("Vote_4_Material", InventoryItem.MATERIAL_VOTE_CATEGORY_4);


    }

    public static Main getInstance() {
        return instance == null ? new Main() : instance;
    }
}
