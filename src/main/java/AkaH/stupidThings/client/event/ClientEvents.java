package AkaH.stupidThings.client.event;

import AkaH.stupidThings.StupidThingsMod;
import AkaH.stupidThings.client.gui.BlockBombLauncherScreen;
import AkaH.stupidThings.common.menu.ModMenus;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(modid = StupidThingsMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {
    public static void register() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(ClientEvents::onClientSetup);
    }

    private static void onClientSetup(net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent event) {
        event.enqueueWork(() -> MenuScreens.register(ModMenus.BLOCK_BOMB_LAUNCHER.get(), BlockBombLauncherScreen::new));
    }
}
