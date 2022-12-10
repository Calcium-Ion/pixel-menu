package work.caion.plugin.pixelmenu.menu.action;

import lombok.Getter;
import org.bukkit.event.inventory.ClickType;
import work.caion.plugin.pixelmenu.menu.condition.Condition;
import work.caion.plugin.pixelmenu.type.EnumActionType;

@Getter
public class CommandAction extends Action {

    private String[] commands;

    public CommandAction(EnumActionType action, ClickType clickType, Condition condition, String[] commands) {
        super(action, clickType, condition, player -> {
            for (String command : commands) {
                if (command.startsWith("console:")) {
                    player.getServer().dispatchCommand(player.getServer().getConsoleSender(), command.replaceFirst("console:", "").trim());
                } else if (command.startsWith("player:")) {
                    player.performCommand(command.replaceFirst("player:", "").trim());
                } else if (command.startsWith("op:")) {
                    player.setOp(true);
                    player.performCommand(command.replaceFirst("op:", "").trim());
                    player.setOp(false);
                } else if (command.startsWith("/")) {
                    player.performCommand(command.replaceFirst("/", "").trim());
                }
            }
        });
        this.commands = commands;
    }
}
