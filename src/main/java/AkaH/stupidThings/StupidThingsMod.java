package AkaH.stupidThings;

import AkaH.stupidThings.client.event.ClientEvents;
import AkaH.stupidThings.common.block.ModBlocks;
import AkaH.stupidThings.common.config.ModConfig;
import AkaH.stupidThings.common.entity.ModEntities;
import AkaH.stupidThings.common.fluid.ModFluids;
import AkaH.stupidThings.common.item.ModCreativeTabs;
import AkaH.stupidThings.common.item.ModItems;
import AkaH.stupidThings.common.menu.ModMenus;
import AkaH.stupidThings.common.network.ModNetwork;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(StupidThingsMod.MOD_ID)
public class StupidThingsMod {
    public static final String MOD_ID = "stupidthings";

    public StupidThingsMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modBus);
        ModItems.ITEMS.register(modBus);
        ModEntities.ENTITY_TYPES.register(modBus);
        ModFluids.FLUIDS.register(modBus);
        ModFluids.FLUID_TYPES.register(modBus);
        ModMenus.MENUS.register(modBus);
        ModCreativeTabs.TABS.register(modBus);

        modBus.addListener(this::commonSetup);

        ModConfig.register(ModLoadingContext.get());

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientEvents::register);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ModNetwork::register);
    }
}
