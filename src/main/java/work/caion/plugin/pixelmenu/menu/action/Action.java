package work.caion.plugin.pixelmenu.menu.action;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import work.caion.plugin.pixelmenu.menu.condition.Condition;
import work.caion.plugin.pixelmenu.type.EnumActionType;

import java.util.function.Consumer;

@Data
@AllArgsConstructor
public abstract class Action {

    //执行的动作
    EnumActionType action;
    //点击类型
    ClickType clickType;
    //条件
    Condition condition;
    //是否启用
    boolean enabled;
    //动作
    Consumer<Player> consumer;

    public void action(Player player) {
        if (enabled && condition.check(player)) {
            consumer.accept(player);
        }
    }

}
