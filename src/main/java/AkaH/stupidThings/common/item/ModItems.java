package AkaH.stupidThings.common.item;

import AkaH.stupidThings.StupidThingsMod;
import AkaH.stupidThings.common.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StupidThingsMod.MOD_ID);
    public static final RegistryObject<Item> BALLOON = ITEMS.register("balloon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMOKE_BOMB = ITEMS.register("smoke_bomb", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> POCKET_SAND = ITEMS.register("pocket_sand", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBBER_CHICKEN = ITEMS.register("rubber_chicken", () -> new Item(new Item.Properties()));

    static {
        ModBlocks.BLOCKS.getEntries().forEach(block -> ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties())));
    }
}
