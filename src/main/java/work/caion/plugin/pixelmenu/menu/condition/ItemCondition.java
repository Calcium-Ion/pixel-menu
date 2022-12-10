package work.caion.plugin.pixelmenu.menu.condition;

import lombok.Data;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import work.caion.plugin.pixelmenu.type.EnumConditionType;

@Getter
public class ItemCondition extends Condition {

    private ItemStack[] item;
    private boolean checkLore;

    public ItemCondition(ItemStack[] item, boolean checkLore, int amount) {
        super(EnumConditionType.HAS_ITEM);
        this.item = item;
        this.checkLore = checkLore;
    }

    @Override
    public boolean check(Player player) {
        //TODO check has item
        return false;
    }

}
