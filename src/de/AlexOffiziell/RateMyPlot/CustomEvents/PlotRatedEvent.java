package de.AlexOffiziell.RateMyPlot.CustomEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlotRatedEvent extends Event {

    private Player player;
    private int[] ratings;

    public PlotRatedEvent(Player player, int[] ratings){
        this.player = player;
        this.ratings = ratings;

    }

    public Player getPlayer() {
        return player;
    }

    public int[] getRatings() {
        return ratings;
    }

    private static final HandlerList HANDLERS = new HandlerList();

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }


}
