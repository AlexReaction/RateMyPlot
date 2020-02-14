package de.AlexOffiziell.RateMyPlot.Events;

import de.AlexOffiziell.RateMyPlot.CustomEvents.PlotRatedEvent;
import de.AlexOffiziell.RateMyPlot.Utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlotRated_Listener implements Listener {


    @EventHandler
    public void onRated(PlotRatedEvent event){
        Player player = event.getPlayer();
        int[] rats = event.getRatings();


        for (int rat : rats) {
            player.sendMessage(Utils.getInstance().getPrefix() + " Ratings: " + rat);
        }



    }



}
