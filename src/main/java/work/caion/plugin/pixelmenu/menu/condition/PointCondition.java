package work.caion.plugin.pixelmenu.menu.condition;

import lombok.Getter;
import org.bukkit.entity.Player;
import work.caion.plugin.pixelmenu.type.EnumConditionType;

@Getter
public class PointCondition extends Condition {

    private int point;

    public PointCondition(int point) {
        super(EnumConditionType.POINT);
        this.point = point;
    }

    @Override
    public boolean check(Player player) {
        //TODO check point
        return false;
    }
}
