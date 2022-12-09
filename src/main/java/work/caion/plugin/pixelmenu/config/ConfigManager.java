package work.caion.plugin.pixelmenu.config;

import org.bukkit.configuration.file.YamlConfiguration;
import work.caion.plugin.pixelmenu.PixelMenu;

import java.io.File;

public class ConfigManager {

    String langName;

    File langConfigFile;

    YamlConfiguration langConfig;

    public ConfigManager(String langName) {
        this.langName = langName;
        this.langConfigFile = new File(PixelMenu.getInstance().getDataFolder(), "lang/" + langName + ".yml");
        if (!langConfigFile.exists()) {
            PixelMenu.getInstance().saveResource("lang/" + langName + ".yml", false);
            langConfig = YamlConfiguration.loadConfiguration(langConfigFile);
        }
    }

    public String getIn18n(String path) {
        return langConfig.getString(path);
    }
}
