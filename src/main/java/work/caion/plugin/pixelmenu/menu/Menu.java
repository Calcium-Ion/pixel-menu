package work.caion.plugin.pixelmenu.menu;

import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import work.caion.plugin.pixelcore.util.ColorUtil;
import work.caion.plugin.pixelmenu.type.EnumClickAction;
import work.caion.plugin.pixelmenu.type.EnumMoneyType;
import work.caion.plugin.pixelmenu.util.LangUtil;

import java.util.List;

@Data
public class Menu {

    private String name;
    private String title;
    private int line;
    private List<ShopItem> items;

    public ItemStack getShowItemStack(int slot) {
        for (ShopItem item : items) {
            if (item.getSlot() == slot) {
                return item.getItemStack(false);
            }
        }
        return new ItemStack(org.bukkit.Material.AIR);
    }

    public ShopItem getShopItem(int slot) {
        for (ShopItem item : items) {
            if (item.getSlot() == slot) {
                return item;
            }
        }
        return null;
    }

    public void onClick(Player player, int slot, ClickType clickType, ItemStack itemStack) {
        ShopItem item = getShopItem(slot);
        if (item != null) {
            boolean find = false;
            for (ClickAction clickAction : item.getClickActions()) {
                if (clickAction.getClickType() == clickType) {
                    find = true;
                    runAction(player, clickAction, item);
                }
            }
            if (!find) {
                for (ClickAction clickAction : item.getClickActions()) {
                    if (clickAction.getClickType() == ClickType.LEFT) {
                        runAction(player, clickAction, item);
                    }
                }
            }
        }
    }

    public boolean takeMoney(Player player, ShopItem item) {
        if (item.isUseMoney()) {
            if (item.getMoneyType() == EnumMoneyType.POINT) {

            } else if (item.getMoneyType()== EnumMoneyType.MONEY) {

            }
            return false;
        }
        return true;
    }

    public void runAction(Player player, ClickAction clickAction, ShopItem item) {
        if (clickAction.getAction() == EnumClickAction.RUN_COMMAND) {
            for (String command : item.getCommands()) {
                if (takeMoney(player, item)) runCommand(player, command);
            }
        } else if (clickAction.getAction() == EnumClickAction.BUY_ITEM) {
            ItemStack itemStack = item.getItemStack(true);
            if (itemStack != null) {
                if (takeMoney(player, item)) {
                    player.getInventory().addItem(itemStack);
                }
            } else {
                player.sendMessage(LangUtil.getLangColor("item.can-not-buy"));
            }
        } else if (clickAction.getAction() == EnumClickAction.SELL_ITEM) {
            ItemStack itemStack = item.getItemStack(true);
            if (itemStack != null) {
                //TODO take item from player and give money
            } else {
                player.sendMessage(LangUtil.getLangColor("item.can-not-sell"));
            }
        }
    }

    public void runCommand(Player player, String command) {
        if (command.startsWith("tell:")) {
            player.sendMessage(ColorUtil.replaceColor(command.substring(5)));
        } else if (command.startsWith("command:")) {
            player.performCommand(command.substring(8));
        } else if (command.startsWith("console:")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.substring(8));
        }
    }
}
