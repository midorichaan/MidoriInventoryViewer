package midorichan.commands;

import midorichan.InventoryViewer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reloadConfig implements CommandExecutor {

    private static InventoryViewer plugin = InventoryViewer.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("mireload")) {
            if (sender.hasPermission("midoriinventory.reload")) {
                plugin.reloadConfig();
                plugin.config = plugin.getConfig();

                sender.sendMessage(plugin.getPrefix() + "Configを再読み込みしました");
            } else {
                sender.sendMessage(plugin.getPrefix() + "権限がありません");
            }
        }

        return true;
    }

}
