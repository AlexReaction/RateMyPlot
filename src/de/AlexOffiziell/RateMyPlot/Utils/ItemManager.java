package de.AlexOffiziell.RateMyPlot.Utils;

public class ItemManager {

    private static ItemManager manager = new ItemManager();







    public static ItemManager getManager() {
        return manager == null ? new ItemManager() : manager;
    }
}
