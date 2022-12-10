package work.caion.plugin.pixelmenu.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

public class InventoryManager implements Listener {

    private final HashMap<String, MenuInventory> playerOpenedInventory;

    public InventoryManager() {
        playerOpenedInventory = new HashMap<>();
    }

    private Inventory generateInventory(Player player, Menu menu) {
        int size = menu.getLine() * 9;
        Inventory inventory = Bukkit.createInventory(player, size, menu.getTitle());
        for (int i = 0; i < size; i++) {
            inventory.setItem(i, menu.getShowItemStack(i));
        }
        return inventory;
    }

    public Inventory openInventory(Player player, Menu menu) {
        Inventory inventory = generateInventory(player, menu);
        player.openInventory(inventory);
        playerOpenedInventory.put(player.getName(), new MenuInventory(menu, inventory));
        return inventory;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getClickedInventory();
        if (inventory == null) {
            return;
        }
        if (playerOpenedInventory.containsKey(player.getName())) {
            if (inventory.equals(playerOpenedInventory.get(player.getName()).getInventory())) {
                event.setCancelled(true);

                if (event.getCurrentItem() == null || event.getCurrentItem().getType().equals(org.bukkit.Material.AIR)) {
                    return;
                }
                Menu menu = playerOpenedInventory.get(player.getName()).getMenu();
                if (event.getSlotType().equals(InventoryType.SlotType.CONTAINER)) {
                    menu.onClick(player, event.getSlot(), event.getClick(), event.getCurrentItem());
                }
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        playerOpenedInventory.remove(event.getPlayer().getName());
    }
}
