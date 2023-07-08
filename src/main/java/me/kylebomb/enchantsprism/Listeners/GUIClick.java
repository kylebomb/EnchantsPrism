package me.kylebomb.enchantsprism.Listeners;

import me.kylebomb.enchantsprism.EnchantsPrism;
import me.kylebomb.enchantsprism.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import sun.applet.Main;

public class GUIClick implements Listener{
    Plugin plugin = EnchantsPrism.getPlugin(EnchantsPrism.class);

    @EventHandler
    public void OnMenuClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        final String MainEnchantsGUI = (String) plugin.getConfig().getString("MainGUITitle");
        final String MeleeEnchantsGUI = (String) plugin.getConfig().getString("MeleeGUITitle");
        final String BowEnchantsGUI = (String) plugin.getConfig().getString("BowGUITitle");
        final String ShieldEnchantsGUI = (String) plugin.getConfig().getString("ShieldGUITitle");
        final String ArmorEnchantsGUI = (String) plugin.getConfig().getString("ArmorGUITitle");
        Inventory ClickedInventory = e.getClickedInventory();
        if(ClickedInventory.getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', MainEnchantsGUI))){
            e.setCancelled(true);
            switch(e.getCurrentItem().getType()) {
                case IRON_SWORD:
                    p.closeInventory();
                    Utils.OpenMeleeMenu(p);
                    break;
                case BOW:
                    p.closeInventory();
                    Utils.OpenBowMenu(p);
                    break;
                case SHIELD:
                    p.closeInventory();
                    Utils.OpenShieldMenu(p);
                    break;
                case IRON_CHESTPLATE:
                    p.closeInventory();
                    Utils.OpenArmorMenu(p);
                    break;
            }
        }else if (ClickedInventory.getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', MeleeEnchantsGUI))){
            e.setCancelled(true);
            switch(e.getCurrentItem().getType()) {
                case BED:
                    p.closeInventory();
                    Utils.OpenMainGUI(p);
                    break;
            }
        }else if (ClickedInventory.getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', BowEnchantsGUI))) {
            e.setCancelled(true);
            switch (e.getCurrentItem().getType()) {
                case BED:
                    p.closeInventory();
                    Utils.OpenMainGUI(p);
                    break;
            }
        }else if (ClickedInventory.getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', ShieldEnchantsGUI))) {
            e.setCancelled(true);
            switch (e.getCurrentItem().getType()) {
                case BED:
                    p.closeInventory();
                    Utils.OpenMainGUI(p);
                    break;
            }
        }else if (ClickedInventory.getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', ArmorEnchantsGUI))) {
            e.setCancelled(true);
            switch (e.getCurrentItem().getType()) {
                case BED:
                    p.closeInventory();
                    Utils.OpenMainGUI(p);
                    break;
            }
        }
    }

}
