package de.AlexOffiziell.RateMyPlot.FileManagement;

import de.AlexOffiziell.RateMyPlot.Core.Main;

import java.io.File;

public class FileHolder {


    public FileFactory messages = new FileFactory("messages.yml", Main.getInstance().getDataFolder());


    static FileHolder fileHolder = new FileHolder();

    public static FileHolder getInstance() {
        return fileHolder == null ? new FileHolder() : fileHolder;
    }
}
