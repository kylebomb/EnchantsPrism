package me.kylebomb.enchantsprism.Commands;

import me.kylebomb.enchantsprism.EnchantsPrism;
import me.kylebomb.enchantsprism.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import sun.applet.Main;

public class EnchantsCommand implements CommandExecutor {
    Plugin plugin = EnchantsPrism.getPlugin(EnchantsPrism.class);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {

            Player p = (Player) commandSender;
            Utils.OpenMainGUI(p);

        }
        return true;
    }
}
