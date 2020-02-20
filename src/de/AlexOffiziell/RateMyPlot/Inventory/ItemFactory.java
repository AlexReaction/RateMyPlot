package de.AlexOffiziell.RateMyPlot.Inventory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemFactory {

    Material material;
    String name;
    List<String> lore;



        public ItemFactory(Material material, String name, List<String> lore){
            this.material = material;
            this.name = name;
            this.lore = lore;
        }


        public ItemStack getItemStack(){
            ItemStack stack = new ItemStack(this.material);
            ItemMeta meta = stack.getItemMeta();

            assert meta != null : "ItemMeta is null";

            meta.setDisplayName(this.name);

            stack.setItemMeta(meta);
            return stack;
        }


    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public Material getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }

    public List<String> getLore() {
        return lore;
    }
}
