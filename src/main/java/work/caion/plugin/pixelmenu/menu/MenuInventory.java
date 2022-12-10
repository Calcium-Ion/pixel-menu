package work.caion.plugin.pixelmenu.menu;

import lombok.Data;
import org.bukkit.inventory.Inventory;

@Data
public class MenuInventory {

    private Menu menu;

    private Inventory inventory;

    public MenuInventory(Menu menu, Inventory inventory) {
        this.menu = menu;
        this.inventory = inventory;
    }
}
