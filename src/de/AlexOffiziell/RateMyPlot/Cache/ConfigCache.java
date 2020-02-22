package de.AlexOffiziell.RateMyPlot.Cache;

import de.AlexOffiziell.RateMyPlot.FileManagement.InventoryItem;

import java.util.HashMap;

public class ConfigCache implements CostumCache {

    HashMap<String, InventoryItem> configCache = new HashMap<>();
    //TODO: Check if the values are not null -> e.g. @NotNull or Validate.notNull

    public ConfigCache(){}

    @Override
    public void addPairToCache(String key, InventoryItem value) {
        configCache.put(key, value);
    }

    @Override
    public void removePairFromCache(String key) {
        configCache.remove(key);
    }

    @Override
    public InventoryItem getValueFromCache(String key) {
        return configCache.get(key);
    }

    public HashMap<String, InventoryItem> getConfigCache() {
        return configCache;
    }
}
