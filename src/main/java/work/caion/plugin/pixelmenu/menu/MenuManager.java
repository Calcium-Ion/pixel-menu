package work.caion.plugin.pixelmenu.menu;

import org.bukkit.entity.Player;
import work.caion.plugin.pixelmenu.PixelMenu;
import work.caion.plugin.pixelmenu.util.PlayerUtil;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {

    private List<Menu> menus;

    private static MenuManager instance;

    public static MenuManager getInstance() {
        if (instance == null) {
            instance = new MenuManager();
        }
        return instance;
    }

    public MenuManager() {
        //TODO: load shops from PixelWeb
        menus = new ArrayList<>();
    }

    public Menu getShop(String shopName) {
        for (Menu menu : menus) {
            if (menu.getName().equals(shopName)) {
                return menu;
            }
        }
        return null;
    }

    public void openShop(Player player, String shopName) {
        Menu menu = getShop(shopName);
        if (menu != null) {

        } else {
            PlayerUtil.sendMessage(player, PixelMenu.getConfigManager().getIn18n("shop.not-found"));
        }
    }
}
