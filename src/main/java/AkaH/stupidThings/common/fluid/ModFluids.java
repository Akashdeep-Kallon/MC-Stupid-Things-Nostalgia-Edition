package AkaH.stupidThings.common.fluid;

import AkaH.stupidThings.StupidThingsMod;
import AkaH.stupidThings.common.block.ModBlocks;
import AkaH.stupidThings.common.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, StupidThingsMod.MOD_ID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, StupidThingsMod.MOD_ID);

    public static final RegistryObject<FluidType> ACID_TYPE = FLUID_TYPES.register("acid", () -> new FluidType(FluidType.Properties.create().density(1200).viscosity(1500).canDrown(true).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)) {});
    public static final RegistryObject<ForgeFlowingFluid> SOURCE_ACID = FLUIDS.register("acid", () -> new ForgeFlowingFluid.Source(PROPERTIES));
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_ACID = FLUIDS.register("flowing_acid", () -> new ForgeFlowingFluid.Flowing(PROPERTIES));
    public static final RegistryObject<LiquidBlock> ACID_BLOCK = ModBlocks.BLOCKS.register("acid", () -> new LiquidBlock(SOURCE_ACID, net.minecraft.world.level.block.state.BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).noCollission().strength(100f).noLootTable()));

    public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ACID_TYPE, SOURCE_ACID, FLOWING_ACID)
            .bucket(ModItems.ACID_BUCKET)
            .block(ACID_BLOCK)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(2);
}
