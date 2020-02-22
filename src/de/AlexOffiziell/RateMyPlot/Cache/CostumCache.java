package de.AlexOffiziell.RateMyPlot.Cache;

public interface CostumCache {

    void addPairToCache(String key, String value);
    void removePairFromCache(String key);
    String getValueFromCache(String key);



}
