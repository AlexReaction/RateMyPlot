package de.AlexOffiziell.RateMyPlot.Commands;

import com.github.intellectualsites.plotsquared.plot.object.Plot;
import com.github.intellectualsites.plotsquared.plot.object.PlotPlayer;
import de.AlexOffiziell.RateMyPlot.CustomEvents.PlotRatedEvent;
import de.AlexOffiziell.RateMyPlot.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Info_CMD implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player) {
            //TODO: Add permission support!
            Player player = (Player) commandSender;


            //CHECK IF PLAYER IS ON VALID PLOT
            PlotPlayer plotPlayer = PlotPlayer.wrap(player);
            if (plotPlayer != null) {
                Bukkit.getPluginManager().callEvent(new PlotRatedEvent(player, new int[]{1, 4, 2, 5, 1, 6}));
                Plot currPlot = plotPlayer.getCurrentPlot();
                player.sendMessage(String.valueOf(currPlot == null ? Utils.getInstance().getPrefix() + "§4§lBitte stelle dich eindeutig auf das Plot" : currPlot.owner == null ? "Dieses Plot gehört keinem" : currPlot.getOwners()));
            } else {
                System.out.println(Utils.getInstance().getPrefix() + " you have to be a player to execute commands!");
                return false;
            }
        }

        return false;
    }
}
