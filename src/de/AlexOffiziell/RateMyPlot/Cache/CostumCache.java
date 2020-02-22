package de.AlexOffiziell.RateMyPlot.Cache;

import de.AlexOffiziell.RateMyPlot.FileManagement.InventoryItem;

public interface CostumCache {

    void addPairToCache(String key, InventoryItem value);
    void removePairFromCache(String key);
    InventoryItem getValueFromCache(String key);



}
