package work.caion.plugin.pixelmenu.menu.action;

import lombok.Getter;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import work.caion.plugin.pixelmenu.menu.condition.Condition;
import work.caion.plugin.pixelmenu.type.EnumActionType;

@Getter
public class GiveItemAction extends Action {

    private ItemStack[] items;

    public GiveItemAction(EnumActionType action, ClickType clickType, Condition condition, ItemStack[] items) {
        super(action, clickType, condition, player -> {
            for (ItemStack item : items) {
                player.getInventory().addItem(item);
            }
        });
        this.items = items;
    }

}
