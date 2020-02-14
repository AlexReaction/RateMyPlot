package de.AlexOffiziell.RateMyPlot.Commands;

import com.github.intellectualsites.plotsquared.plot.object.Location;
import com.mysql.jdbc.Util;
import de.AlexOffiziell.RateMyPlot.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Info_CMD implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player){
            //TODO: Add permission support!
            Player player = (Player) commandSender;
           String PLOT_ID = Utils.plotAPI.getPlotSquared().getApplicablePlotArea(new Location(player.getWorld().getName(),(int) player.getLocation().getX(),(int) player.getLocation().getY(), (int) player.getLocation().getZ())).id;
            player.sendMessage(Utils.getInstance().getPrefix() + "Plot ID: " + PLOT_ID);
        }else{
            System.out.println(Utils.getInstance().getPrefix() + " you have to be a player to execute commands!");
            return false;
        }


        return false;
    }
}
