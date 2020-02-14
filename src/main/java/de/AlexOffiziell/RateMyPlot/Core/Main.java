package de.AlexOffiziell.RateMyPlot.Core;

import de.AlexOffiziell.RateMyPlot.Utils.Utils;
import org.bukkit.plugin.java.JavaPlugin;
import sun.rmi.runtime.Log;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    //TODO: 


    @Override
    public void onEnable() {
        System.out.println(Utils.getInstance().getPrefix() + "activated");
        super.onEnable();
    }


    @Override
    public void onDisable() {
        System.out.println(Utils.getInstance().getPrefix() + "deactivated");
        super.onDisable();
    }
}
