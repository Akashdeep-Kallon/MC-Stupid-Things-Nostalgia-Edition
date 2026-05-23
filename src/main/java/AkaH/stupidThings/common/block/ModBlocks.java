package AkaH.stupidThings.common.block;

import AkaH.stupidThings.StupidThingsMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, StupidThingsMod.MOD_ID);

    public static final RegistryObject<Block> REVERSE_TNT = register("reverse_tnt");
    public static final RegistryObject<Block> RAIL_EXPLOSIVE = register("rail_explosive");
    public static final RegistryObject<Block> COOLER = register("cooler");
    public static final RegistryObject<Block> HEATER = register("heater");
    public static final RegistryObject<Block> GRAVITY_ACCELERATOR = register("gravity_accelerator");
    public static final RegistryObject<Block> PET_ROCK = register("pet_rock");
    public static final RegistryObject<Block> MINE_TURTLE = register("mine_turtle");
    public static final RegistryObject<Block> HIDDEN_LIGHT = BLOCKS.register("hidden_light", () -> new Block(BlockBehaviour.Properties.of().lightLevel(s -> 15).noOcclusion()));

    private static RegistryObject<Block> register(String id) {
        return BLOCKS.register(id, () -> new Block(BlockBehaviour.Properties.of()));
    }
}
