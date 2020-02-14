package de.AlexOffiziell.RateMyPlot.FileManagement;


import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class which allows you to simply create files. Coded by Alex|ByteBuffer
 *
 * Created by Alex on 06.05.2017.
 */


public class FileFactory {


    File file;
    File dataFolder;
    FileConfiguration configuration;
    String name;
    String path;
    String pluginName;
    boolean usePath;


    /**
     * This method is used to create an new FileCreator object
     * with those parameters.
     *
     * @param name is the name of the file
     * @param path is the path where the file will be created
     * @param usePath when true => path is used
     */

    public FileFactory(String name, String path, boolean usePath){
        file = new File(path, name);
        configuration = YamlConfiguration.loadConfiguration(file);
        this.name = name;
        this.path = path;
        this.usePath = usePath;
    }


    /**
     * This method is used to create an new FileCreator object
     * with those parameters.
     *
     * @param name is the name of the file
     * @param pluginName is the name of the plugin
     */

    public FileFactory(String name, String pluginName){
        this.name = name;
        this.pluginName = pluginName;
        this.file = new File("plugins/"+pluginName, name);
        this.configuration = YamlConfiguration.loadConfiguration(file);

    }


    /**
     *
     * This method is used to create a new FileCreator object
     * with those parameters.
     *
     *
     * @param name is the name of the file
     * @param dataFolder is the dataFolder where the file will be created
     */

    public FileFactory(String name, File dataFolder){
        this.name = name;
        this.dataFolder = dataFolder;
        this.file = new File(dataFolder, name);
        this.configuration = YamlConfiguration.loadConfiguration(file);
    }


    /**
     *
     * This method creates the file if the
     * specified file does not exists.
     */
    public void createFile(){
        if(!this.file.exists()) {
            this.configuration.options().copyDefaults(true);
            try {
                this.configuration.save(this.file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * This method saves the specified file.
     */

    public void saveFile(){
        try {
            this.configuration.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * This method will set an object in the specified file at a
     * specified path.
     *
     * @param value the object, which need to be set
     * @param path the path where the object should be set
     */

    public void setValue(Object value, String path){
        this.configuration.set(path,value);
        saveFile();

    }
    /**
     *
     *
     *
     * @return created FileConfiguration
     */

    public FileConfiguration getFile(){
        return configuration;
    }


    /**
     * Returns the value from the path
     *
     * @param path is the path from where to get the value
     * @return the Object from the path
     */

    public Object getValue(String path){
        return configuration.get(path);
    }

    /**
     * Returns the chatcolored value from the path
     * @param path the path
     * @return colored String
     */

    public String getMinecraftString(String path) {
        return ChatColor.translateAlternateColorCodes('&', String.valueOf(configuration.get(path)));
    }


    /**
     * deleteFile() deletes the file.
     */

    public void deleteFile(){
        this.file.delete();
    }



    /**
     * This method deletes all values from a specified path.
     *
     * @param path is the path where the values should be deleted.
     */


    public void deleteValue(String path){
        this.configuration.set(path, null);
        saveFile();
    }


    /**
     *
     * This method generates standart values from the ArrayList
     *
     * @param values are the values which need to be set
     * @param whereSplit is the string where the values will be splitted
     */

    //TODO REFACTOR THIS

    public void generateStandart(ArrayList<String> values, String whereSplit){
        if(values.size() == 0){
            throw new ArrayIndexOutOfBoundsException("ArrayList is null");
        }else{
            if(!this.file.exists()){
                for(int i=0;i<values.size();i++){
                    String value1 = values.get(i);
                    if(!configuration.contains(value1)){
                        if(value1.contains(whereSplit)) {
                            String[] doublevalue = value1.split(whereSplit);
                            String path = doublevalue[0];
                            String values2 = doublevalue[1];
                            setValue(values2, path);
                        }else{
                            System.out.println("String["+i+"] doesnt contains String \""+ whereSplit+"\"");
                        }
                    }else{
                        System.out.println("String["+i+"] is already in the config");
                    }
                }
            }
        }

    }

}
