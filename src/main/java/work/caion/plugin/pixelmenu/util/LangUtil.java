package work.caion.plugin.pixelmenu.util;

import work.caion.plugin.pixelcore.util.ColorUtil;
import work.caion.plugin.pixelmenu.PixelMenu;

public class LangUtil {

    public static String getLang(String path) {
        return PixelMenu.getConfigManager().getIn18n(path);
    }

    public static String getLangColor(String path) {
        return ColorUtil.replaceColor(getLang(path));
    }
}
