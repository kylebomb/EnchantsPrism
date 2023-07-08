package me.kylebomb.enchantsprism;

import me.kylebomb.enchantsprism.Commands.EnchantsCommand;
import me.kylebomb.enchantsprism.Listeners.GUIClick;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class EnchantsPrism extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("enchants").setExecutor(new EnchantsCommand());

        getServer().getPluginManager().registerEvents(new GUIClick(), this);


        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
}
