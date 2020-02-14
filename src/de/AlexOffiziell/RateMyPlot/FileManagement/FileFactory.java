package de.AlexOffiziell.RateMyPlot.FileManagement;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileFactory implements FileManager {

    YamlConfiguration yamlConfiguration;
    String name;
    String path;

    @Override
    public void createFile(String name, String path) {

        this.name = name;
        this.path = path;
        File file = new File(this.path, this.name);
        this.yamlConfiguration = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs(); //ignoring success boolean because there is no usage atm (14.02.2020)
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("File: " + this.name + " already exists -> skipping");
        }

    }

    @Override
    public void saveFile() {

    }

    public YamlConfiguration getYamlConfiguration() {
        return yamlConfiguration;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

}
