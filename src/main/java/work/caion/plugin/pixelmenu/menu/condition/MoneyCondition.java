package work.caion.plugin.pixelmenu.menu.condition;

import lombok.Getter;
import org.bukkit.entity.Player;
import work.caion.plugin.pixelmenu.type.EnumConditionType;

@Getter
public class MoneyCondition extends Condition {

    private int amount;

    public MoneyCondition(int amount) {
        super(EnumConditionType.MONEY);
        this.amount = amount;
    }

    @Override
    public boolean check(Player player) {
        //TODO check money
        return false;
    }
}
