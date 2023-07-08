package me.kylebomb.enchantsprism;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {

    public static void OpenMainGUI(Player p) {
        Plugin plugin = EnchantsPrism.getPlugin(EnchantsPrism.class);
        String MainGUITitle = plugin.getConfig().getString("MainGUITitle");
        String MeleeOptionTitle = plugin.getConfig().getString("MeleeOptionTitle");
        String BowOptionTitle = plugin.getConfig().getString("BowOptionTitle");
        String ShieldOptionTitle = plugin.getConfig().getString("ShieldOptionTitle");
        String ArmorOptionTitle = plugin.getConfig().getString("ArmorOptionTitle");
        Inventory EnchGUI = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', MainGUITitle));

        ItemStack GB = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
        ItemMeta GBM = GB.getItemMeta();
        GBM.setDisplayName(ChatColor.GRAY + "");
        GB.setItemMeta(GBM);

        for (int i = 0; i < EnchGUI.getSize(); i++) {
            if (EnchGUI.getItem(i) == null) {
                EnchGUI.setItem(i, GB);
            }
        }

        ItemStack melee = new ItemStack(Material.IRON_SWORD);
        ItemMeta mdata = melee.getItemMeta();
        mdata.setDisplayName(ChatColor.translateAlternateColorCodes('&', MeleeOptionTitle));
        mdata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        melee.setItemMeta(mdata);
        EnchGUI.setItem(10, melee);

        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bdata = bow.getItemMeta();
        bdata.setDisplayName(ChatColor.translateAlternateColorCodes('&', BowOptionTitle));
        bdata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        bow.setItemMeta(bdata);
        EnchGUI.setItem(12, bow);

        ItemStack shield = new ItemStack(Material.SHIELD);
        ItemMeta sdata = shield.getItemMeta();
        sdata.setDisplayName(ChatColor.translateAlternateColorCodes('&', ShieldOptionTitle));
        sdata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        shield.setItemMeta(sdata);
        EnchGUI.setItem(14, shield);

        ItemStack armor = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta adata = armor.getItemMeta();
        adata.setDisplayName(ChatColor.translateAlternateColorCodes('&', ArmorOptionTitle));
        adata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        armor.setItemMeta(adata);
        EnchGUI.setItem(16, armor);

        p.openInventory(EnchGUI);
    }
    public static void OpenMeleeMenu(Player p){
        Plugin plugin = EnchantsPrism.getPlugin(EnchantsPrism.class);
        String MeleeGUITitle = plugin.getConfig().getString("MeleeGUITitle");
        Inventory MeleeGUI = Bukkit.createInventory(p, 54, ChatColor.translateAlternateColorCodes('&', MeleeGUITitle));
        GlassOutline((short)14, MeleeGUI);
        goBack(MeleeGUI);
        getInfo(MeleeGUI);
        for (int i = 0; i<=28;i++){
            if (plugin.getConfig().getBoolean("MeleeEnchants." + String.valueOf(i) + ".enabled")){
                ItemStack Item = new ItemStack(Material.valueOf(plugin.getConfig().getString("MeleeEnchants." + String.valueOf(i) + ".item").toUpperCase()));
                ItemMeta Meta = Item.getItemMeta();
                List<String> lore = (List<String>)plugin.getConfig().getList("MeleeEnchants.1.lore");
                List<String> coloredLore = new ArrayList<>();
                for(String line : lore){
                    coloredLore.add(ChatColor.translateAlternateColorCodes('&', line));
                }
                Meta.setLore(coloredLore);
                if (plugin.getConfig().getBoolean("MeleeEnchants." + i + ".enchantGlint")){
                    Meta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
                }
                Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("MeleeEnchants." + String.valueOf(i) + ".name")));
                Item.setItemMeta(Meta);
                MeleeGUI.addItem(Item);
            }
        }
        p.openInventory(MeleeGUI);
    }
    public static void OpenBowMenu(Player p){
        Plugin plugin = EnchantsPrism.getPlugin(EnchantsPrism.class);
        String BowGUITitle = plugin.getConfig().getString("BowGUITitle");
        Inventory BowGUI = Bukkit.createInventory(p, 54, ChatColor.translateAlternateColorCodes('&', BowGUITitle));
        GlassOutline((short)4, BowGUI);
        goBack(BowGUI);
        getInfo(BowGUI);
        for (int i = 0; i<=28;i++){
            if (plugin.getConfig().getBoolean("BowEnchants." + String.valueOf(i) + ".enabled")){
                ItemStack Item = new ItemStack(Material.valueOf(plugin.getConfig().getString("BowEnchants." + String.valueOf(i) + ".item").toUpperCase()));
                ItemMeta Meta = Item.getItemMeta();
                List<String> lore = (List<String>)plugin.getConfig().getList("BowEnchants.1.lore");
                List<String> coloredLore = new ArrayList<>();
                for(String line : lore){
                    coloredLore.add(ChatColor.translateAlternateColorCodes('&', line));
                }
                Meta.setLore(coloredLore);
                if (plugin.getConfig().getBoolean("BowEnchants." + i + ".enchantGlint")){
                    Meta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
                }
                Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("BowEnchants." + String.valueOf(i) + ".name")));
                Item.setItemMeta(Meta);
                BowGUI.addItem(Item);
            }
        }
        p.openInventory(BowGUI);
    }

    public static void OpenShieldMenu(Player p){
        Plugin plugin = EnchantsPrism.getPlugin(EnchantsPrism.class);
        String ShieldGUITitle = plugin.getConfig().getString("ShieldGUITitle");
        Inventory ShieldGUI = Bukkit.createInventory(p, 54, ChatColor.translateAlternateColorCodes('&', ShieldGUITitle));
        GlassOutline((short)5, ShieldGUI);
        goBack(ShieldGUI);
        getInfo(ShieldGUI);
        for (int i = 0; i<=28;i++){
            if (plugin.getConfig().getBoolean("ShieldEnchants." + String.valueOf(i) + ".enabled")){
                ItemStack Item = new ItemStack(Material.valueOf(plugin.getConfig().getString("ShieldEnchants." + String.valueOf(i) + ".item").toUpperCase()));
                ItemMeta Meta = Item.getItemMeta();
                List<String> lore = (List<String>)plugin.getConfig().getList("ShieldEnchants.1.lore");
                List<String> coloredLore = new ArrayList<>();
                for(String line : lore){
                    coloredLore.add(ChatColor.translateAlternateColorCodes('&', line));
                }
                Meta.setLore(coloredLore);
                if (plugin.getConfig().getBoolean("ShieldEnchants." + i + ".enchantGlint")){
                    Meta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
                }
                Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("ShieldEnchants." + String.valueOf(i) + ".name")));
                Item.setItemMeta(Meta);
                ShieldGUI.addItem(Item);
            }
        }
        p.openInventory(ShieldGUI);
    }

    public static void OpenArmorMenu(Player p){
        Plugin plugin = EnchantsPrism.getPlugin(EnchantsPrism.class);
        String ArmorGUITitle = plugin.getConfig().getString("ArmorGUITitle");
        Inventory ArmorGUI = Bukkit.createInventory(p, 54, ChatColor.translateAlternateColorCodes('&', ArmorGUITitle));
        GlassOutline((short)11, ArmorGUI);
        goBack(ArmorGUI);
        getInfo(ArmorGUI);
        for (int i = 0; i<=28;i++){
            if (plugin.getConfig().getBoolean("ArmorEnchants." + String.valueOf(i) + ".enabled")){
                ItemStack Item = new ItemStack(Material.valueOf(plugin.getConfig().getString("ArmorEnchants." + String.valueOf(i) + ".item").toUpperCase()));
                ItemMeta Meta = Item.getItemMeta();
                List<String> lore = (List<String>)plugin.getConfig().getList("ArmorEnchants.1.lore");
                List<String> coloredLore = new ArrayList<>();
                for(String line : lore){
                    coloredLore.add(ChatColor.translateAlternateColorCodes('&', line));
                }
                Meta.setLore(coloredLore);
                if (plugin.getConfig().getBoolean("ArmorEnchants." + i + ".enchantGlint")){
                    Meta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
                }
                Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("ArmorEnchants." + String.valueOf(i) + ".name")));
                Item.setItemMeta(Meta);
                ArmorGUI.addItem(Item);
            }
        }
        p.openInventory(ArmorGUI);
    }
    public static void getInfo(Inventory gui){
        Plugin plugin = EnchantsPrism.getPlugin(EnchantsPrism.class);
        ItemStack info = new ItemStack(Material.BOOK);
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("InfoBook.name")));
        List<String> lore = (List<String>)plugin.getConfig().getList("InfoBook.lore");
        List<String> coloredLore = new ArrayList<>();
        for(String line : lore){
            coloredLore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
        infoMeta.setLore(coloredLore);
        info.setItemMeta(infoMeta);
        gui.setItem(8, info);
    }
    public static void goBack(Inventory gui){
        Plugin plugin = EnchantsPrism.getPlugin(EnchantsPrism.class);
        ItemStack goBack = new ItemStack(Material.BED, 1, (short) 0);
        ItemMeta goBackMeta = goBack.getItemMeta();
        goBackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("GoBackName")));
        goBack.setItemMeta(goBackMeta);
        gui.setItem(45, goBack);
    }
    public static void GlassOutline(Short color, Inventory gui){
        ItemStack BP = new ItemStack(Material.STAINED_GLASS_PANE, 1, color);
        ItemMeta BPM = BP.getItemMeta();
        BPM.setDisplayName(ChatColor.GRAY + "");
        BPM.addEnchant(Enchantment.MENDING, 1 , false);
        BPM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        BP.setItemMeta(BPM);
        int[] REDP = {0, 1, 2, 3, 4, 5, 6, 7, 9, 17, 18, 26, 27, 35, 36, 44, 46, 47, 48, 49, 50, 51, 52, 53};
        for (int i = 0; i < REDP.length; i++) {
            gui.setItem(REDP[i], BP);
        }
    }

}
