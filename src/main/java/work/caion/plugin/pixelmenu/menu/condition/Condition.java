package work.caion.plugin.pixelmenu.menu.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.entity.Player;
import work.caion.plugin.pixelmenu.type.EnumConditionType;

@Data
@AllArgsConstructor
public abstract class Condition {

    EnumConditionType conditionType;

    public abstract boolean check(Player player);
}
