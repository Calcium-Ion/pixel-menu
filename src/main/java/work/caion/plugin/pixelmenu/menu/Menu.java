package work.caion.plugin.pixelmenu.menu;

import lombok.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import work.caion.plugin.pixelmenu.menu.action.Action;

import java.util.List;

@Data
public class Menu {

    private String name;
    private String title;
    private int line;
    private List<MenuItem> items;

    public ItemStack getShowItemStack(int slot) {
        for (MenuItem item : items) {
            if (item.getSlot() == slot) {
                return item.getItemStack(false);
            }
        }
        return new ItemStack(org.bukkit.Material.AIR);
    }

    public MenuItem getMenuItem(int slot) {
        for (MenuItem item : items) {
            if (item.getSlot() == slot) {
                return item;
            }
        }
        return null;
    }

    public void onClick(Player player, int slot, ClickType clickType, ItemStack itemStack) {
        MenuItem item = getMenuItem(slot);
        if (item != null) {
            for (Action action : item.getActions()) {
                if (action.getClickType() == clickType) {
                    action.action(player);
                }
            }
        }
    }
}
