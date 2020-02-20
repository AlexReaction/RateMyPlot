package de.AlexOffiziell.RateMyPlot.FileManagement;

import de.AlexOffiziell.RateMyPlot.Core.Main;

import java.io.File;
import java.util.ArrayList;

public class FileHolder {

    public ArrayList<String> standardItemConfig = new ArrayList<>();

    public FileFactory messages = new FileFactory("messages.yml", Main.getInstance().getDataFolder());
    public FileFactory items = new FileFactory("items.yml", Main.getInstance().getDataFolder());







    static FileHolder fileHolder = new FileHolder();

    public static FileHolder getInstance() {
        return fileHolder == null ? new FileHolder() : fileHolder;
    }
}
