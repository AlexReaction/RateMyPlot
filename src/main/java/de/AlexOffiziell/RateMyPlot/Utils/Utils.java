package de.AlexOffiziell.RateMyPlot.Utils;

import sun.nio.ch.Util;

public class Utils {

    private static Utils instance = new Utils();








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
