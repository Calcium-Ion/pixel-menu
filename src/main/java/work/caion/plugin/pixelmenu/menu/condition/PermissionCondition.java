package work.caion.plugin.pixelmenu.menu.condition;

import org.bukkit.entity.Player;
import work.caion.plugin.pixelmenu.type.EnumConditionType;

public class PermissionCondition extends Condition {

    private String permission;

    public PermissionCondition(String permission) {
        super(EnumConditionType.PERMISSION);
        this.permission = permission;
    }

    @Override
    public boolean check(Player player) {
        return player.hasPermission(permission);
    }
}
