package me.kylebomb.enchantsprism.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class EnchantsCommands implements CommandExecutor {
    Plugin plugin = EnchantMenu.getPlugin(EnchantMenu.class);
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){

            Player p = (Player) commandSender;
            Inventory EnchGUI = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("MainGUIName")));
            ItemStack GB = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
            for (int i = 0; i<EnchGUI.getSize();i++){
                if (EnchGUI.getItem(i) == null)
                {
                    EnchGUI.addItem(GB);
                }
            }
            ItemStack melee = new ItemStack(Material.IRON_SWORD);
            ItemMeta mdata = melee.getItemMeta();
            mdata.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("MeleeOptionName")));

        }
        return true;
    }
}
