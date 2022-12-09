package work.caion.plugin.pixelmenu.util;

import org.bukkit.entity.Player;
import work.caion.plugin.pixelcore.util.ColorUtil;

public class PlayerUtil {

    public static void sendMessage(Player player, String path) {
        player.sendMessage(ColorUtil.replaceColor(LangUtil.getLang(path)));
    }
}
