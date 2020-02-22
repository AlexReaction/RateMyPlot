package de.AlexOffiziell.RateMyPlot.Cache;

import java.util.HashMap;

public class ConfigCache implements CostumCache {

    HashMap<String, String> configCache = new HashMap<>();

    public ConfigCache(){}

    @Override
    public void addPairToCache(String key, String value) {
        configCache.put(key, value);
    }

    @Override
    public void removePairFromCache(String key) {
        configCache.remove(key);
    }

    @Override
    public String getValueFromCache(String key) {
        return configCache.get(key) == null ? "-1" : configCache.get(key);
    }
}
