package AkaH.stupidThings.client.gui;

import AkaH.stupidThings.common.menu.BlockBombLauncherMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class BlockBombLauncherScreen extends AbstractContainerScreen<BlockBombLauncherMenu> {
    public BlockBombLauncherScreen(BlockBombLauncherMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) { }
}
