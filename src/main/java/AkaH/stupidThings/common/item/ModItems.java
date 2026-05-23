package AkaH.stupidThings.common.item;

import AkaH.stupidThings.StupidThingsMod;
import AkaH.stupidThings.common.block.ModBlocks;
import AkaH.stupidThings.common.fluid.ModFluids;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StupidThingsMod.MOD_ID);

    public static final RegistryObject<Item> ACID_BUCKET = ITEMS.register("acid_bucket", () -> new BucketItem(ModFluids.SOURCE_ACID, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SMOKE_BOMB = ITEMS.register("smoke_bomb", () -> new ItemSmokeBomb(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> POCKET_SAND = ITEMS.register("pocket_sand", () -> new ItemPocketSand(new Item.Properties()));
    public static final RegistryObject<Item> RUBBER_CHICKEN = ITEMS.register("rubber_chicken", () -> new ItemRubberChicken(new Item.Properties()));

    static {
        registerBlockItem("reverse_tnt", ModBlocks.REVERSE_TNT);
        registerBlockItem("rail_explosive", ModBlocks.RAIL_EXPLOSIVE);
        registerBlockItem("cooler", ModBlocks.COOLER);
        registerBlockItem("heater", ModBlocks.HEATER);
        registerBlockItem("gravity_accelerator", ModBlocks.GRAVITY_ACCELERATOR);
        registerBlockItem("pet_rock", ModBlocks.PET_ROCK);
        registerBlockItem("mine_turtle", ModBlocks.MINE_TURTLE);
        registerBlockItem("hidden_light", ModBlocks.HIDDEN_LIGHT);

        registerSimple("anvil_backpack"); registerSimple("balloon"); registerSimple("balloon_deflated"); registerSimple("balloon_liquid");
        registerSimple("block_bomb_launcher"); registerSimple("cactus_sword"); registerSimple("item_catalog"); registerSimple("firing_can");
        registerSimple("improved_wood_hoe"); registerSimple("improved_stone_hoe"); registerSimple("improved_iron_hoe"); registerSimple("improved_gold_hoe"); registerSimple("improved_diamond_hoe");
        registerSimple("invisible_helmet"); registerSimple("invisible_chestplate"); registerSimple("invisible_leggings"); registerSimple("invisible_boots");
        registerSimple("paper_bag_hat"); registerSimple("propeller_hat"); registerSimple("rubber"); registerSimple("rubber_raw");
        registerSimple("target_chestplate"); registerSimple("upside_down_goggles"); registerSimple("worlds_smallest_violin");
    }

    private static void registerSimple(String id) { ITEMS.register(id, () -> new Item(new Item.Properties())); }
    private static void registerBlockItem(String id, RegistryObject<net.minecraft.world.level.block.Block> block) { ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties())); }
}
