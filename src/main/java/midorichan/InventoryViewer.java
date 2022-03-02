package midorichan;

import midorichan.commands.enderchestCommand;
import midorichan.commands.inventoryCommand;
import midorichan.commands.reloadConfig;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class InventoryViewer extends JavaPlugin {

    public static FileConfiguration config = null;

    private static InventoryViewer plugin = null;
    private static String prefix = null;

    public static String getPrefix() {
        return prefix;
    }

    public static InventoryViewer getInstance() {
        return plugin;
    }

    public static FileConfiguration getConfiguration() {
        return config;
    }

    @Override
    public void onEnable() {
        plugin = this;

        //config
        this.saveDefaultConfig();
        config = this.getConfig();

        //Config vars
        prefix = config.getString("plugin-prefix", " &2>&a>&r ")
                .replace("&", "§");

        //Register commands
        Bukkit.getPluginCommand("mireload").setExecutor(new reloadConfig());
        Bukkit.getPluginCommand("inventory").setExecutor(new inventoryCommand());
        Bukkit.getPluginCommand("enderchest").setExecutor(new enderchestCommand());

        this.getLogger().info(prefix + "Enabled MidoriInventoryViewer v1.0");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(prefix + "Disabled MidoriInventoryViewer v1.0");
    }
}
