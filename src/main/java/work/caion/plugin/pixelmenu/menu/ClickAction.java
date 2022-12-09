package work.caion.plugin.pixelmenu.menu;

import lombok.Data;
import org.bukkit.event.inventory.ClickType;
import work.caion.plugin.pixelmenu.type.EnumClickAction;

@Data
public class ClickAction {

    EnumClickAction action;
    ClickType clickType;
}
