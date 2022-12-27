package work.caion.plugin.pixelmenu.menu.condition;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import work.caion.plugin.pixelmenu.type.EnumConditionType;

@Getter
public class HasItemCondition extends Condition {

    private ItemStack[] item;
    private boolean checkLore;

    public HasItemCondition(ItemStack[] item, boolean checkLore, int amount) {
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
