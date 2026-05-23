package AkaH.stupidThings.common.item;

import AkaH.stupidThings.StupidThingsMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.Registries;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StupidThingsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAIN = TABS.register("main", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.stupidthings.main"))
            .icon(() -> new ItemStack(net.minecraft.world.item.Items.SLIME_BALL))
            .build());

    @Mod.EventBusSubscriber(modid = StupidThingsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class TabEvents {
        @SubscribeEvent
        public static void buildContents(BuildCreativeModeTabContentsEvent event) {
            if (event.getTab() == MAIN.get()) ModItems.ITEMS.getEntries().forEach(ro -> event.accept(ro.get()));
        }
    }
}
