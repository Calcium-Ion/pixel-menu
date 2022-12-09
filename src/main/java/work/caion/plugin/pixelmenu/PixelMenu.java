package work.caion.plugin.pixelmenu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import work.caion.plugin.pixelmenu.config.ConfigManager;
import work.caion.plugin.pixelmenu.menu.ShopManager;

public class PixelMenu extends JavaPlugin {

    //instance
    private static PixelMenu instance;

    //config instance
    private static ConfigManager configManager;

    public static PixelMenu getInstance() {
        return instance;
    }

    //get config instance
    public static ConfigManager getConfigManager() {
        return configManager;
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        reloadConfig();
        configManager = new ConfigManager(getConfig().getString("lang"));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return true;
    }

    public void openShop(Player player, String shopName) {
        ShopManager.getInstance().openShop(player, shopName);
    }
}
