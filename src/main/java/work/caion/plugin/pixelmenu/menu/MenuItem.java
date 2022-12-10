package work.caion.plugin.pixelmenu.menu;

import lombok.Data;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import work.caion.plugin.pixelcore.util.ColorUtil;
import work.caion.plugin.pixelmenu.menu.action.Action;
import work.caion.plugin.pixelmenu.util.LangUtil;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

@Data
public class MenuItem {

    private int slot;
    private String item;
    private String name;
    private int amount;
    private Action[] actions;
    private HashMap<Enchantment, Integer> enchantments;
    private ItemFlag[] flags;
    private String[] lore;

    @Nullable
    public ItemStack getItemStack(boolean safeMod) {
        boolean getMaterialFailed = false;
        Material material = Material.getMaterial(item);
        if (material == null) {
            material = Material.getMaterial(item, true);
            if (material == null) {
                material = Material.STONE;
                getMaterialFailed = true;
            }
        }
        ArrayList<String> loreList = new ArrayList<>();
        for (String lore : lore) {
            loreList.add(ColorUtil.replaceColor(lore));
        }

        if (getMaterialFailed) {
            loreList.add(LangUtil.getLangColor("item.material-not-found") + item);
            if (safeMod) {
                return null;
            }
        }

        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtil.replaceColor(name));
        enchantments.forEach((enchantment, integer) -> {
            itemMeta.addEnchant(enchantment, integer, false);
        });
        itemMeta.addItemFlags(flags);
        itemMeta.setLore(loreList);

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
