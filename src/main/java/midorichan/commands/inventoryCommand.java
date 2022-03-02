package midorichan.commands;

import midorichan.InventoryViewer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class inventoryCommand implements CommandExecutor {

    private static InventoryViewer plugin = InventoryViewer.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("inventory")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(plugin.getPrefix() + "コンソールからは使用できません");
            } else {
                Player p = (Player) sender;

                if (!(p.hasPermission("midoriinventory.inventory"))) {
                    p.sendMessage(plugin.getPrefix() + "権限がありません");
                    return true;
                }

                if (args.length == 0) {
                    Inventory i = p.getInventory();
                    p.openInventory(i);
                    p.sendMessage(plugin.getPrefix() + p.getName() + "のインベントリを開きました");
                } else if (args.length == 1) {
                    String tar = args[0];
                    Player target = Bukkit.getPlayer(tar);

                    if (target == null) {
                        p.sendMessage(plugin.getPrefix() + "プレイヤー " + tar + " は見つかりませんでした");
                        return true;
                    }

                    Inventory i = target.getInventory();
                    p.openInventory(i);
                    p.sendMessage(plugin.getPrefix() + target.getName() + "のインベントリを開きました");
                } else {
                    p.sendMessage(plugin.getPrefix() + "引数が不正です");
                }
            }
        }

        return true;
    }

}
