package AkaH.stupidThings.common.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;

public class BlockBombLauncherMenu extends AbstractContainerMenu {
    private final SimpleContainer container;

    public BlockBombLauncherMenu(int id, Inventory playerInventory, FriendlyByteBuf data) {
        this(id, playerInventory, new SimpleContainer(1));
    }

    public BlockBombLauncherMenu(int id, Inventory playerInventory, SimpleContainer container) {
        super(ModMenus.BLOCK_BOMB_LAUNCHER.get(), id);
        this.container = container;
        this.addSlot(new Slot(container, 0, 80, 35));
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
