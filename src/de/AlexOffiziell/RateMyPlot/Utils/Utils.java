package de.AlexOffiziell.RateMyPlot.Utils;

import com.github.intellectualsites.plotsquared.api.PlotAPI;

public class Utils {

    private static Utils instance = new Utils();


    public static PlotAPI plotAPI;







    public String getPrefix(){
        return "§8[§4RateMyPlot§8] ";
    }

    public String getNoPerm(){
        return getPrefix() + "§4You have no permission to execute this command!";
    }


    public static Utils getInstance() {
        return instance == null ? new Utils() : instance;
    }

}
