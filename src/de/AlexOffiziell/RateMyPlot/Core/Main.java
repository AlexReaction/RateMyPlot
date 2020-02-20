package de.AlexOffiziell.RateMyPlot.Core;

import com.github.intellectualsites.plotsquared.api.PlotAPI;
import de.AlexOffiziell.RateMyPlot.Commands.Info_CMD;
import de.AlexOffiziell.RateMyPlot.Events.PlotRated_Listener;
import de.AlexOffiziell.RateMyPlot.FileManagement.FileFactory;
import de.AlexOffiziell.RateMyPlot.FileManagement.FileHolder;
import de.AlexOffiziell.RateMyPlot.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;


public class Main extends JavaPlugin {
    static Main instance;

    //TODO: Custom events
    //TODO: Responsive Inventory -> user can choose how many vote categories, the more categories the bigger the inventory has to be!
    //TODO: Cache values from config and only update them on start

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

    public static Main getInstance() {
        return instance == null ? new Main() : instance;
    }
}
