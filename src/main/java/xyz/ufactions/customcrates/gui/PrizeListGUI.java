package xyz.ufactions.customcrates.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import xyz.ufactions.customcrates.CustomCrates;
import xyz.ufactions.customcrates.crates.ICrate;
import xyz.ufactions.customcrates.crates.Prize;
import xyz.ufactions.customcrates.gui.internal.GUI;
import xyz.ufactions.customcrates.gui.internal.button.SelfSortingButton;
import xyz.ufactions.customcrates.libs.ItemBuilder;

public class PrizeListGUI extends GUI<CustomCrates> {

    public PrizeListGUI(CustomCrates plugin, ICrate crate) {
        super(plugin, "Prizes from " + crate.getDisplay(), 54, GUIFiller.NONE);

        for (Prize prize : crate.getPrizes()) {
            addButton(new SelfSortingButton<CustomCrates>(plugin, new ItemBuilder(prize.getDisplayItem())) {

                @Override
                public void onClick(Player player, ClickType type) {
                    PrizeEditorGUI gui = new PrizeEditorGUI(plugin, crate, prize);
//                    gui.setReturnGUI(opener);TODO RE-ENABLE ONCE BUG FIXED
                    gui.openInventory(player);
                }
            });
        }
    }
}