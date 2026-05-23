package AkaH.stupidThings.common.fluid;

import AkaH.stupidThings.StupidThingsMod;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, StupidThingsMod.MOD_ID);
    public static final DeferredRegister<?> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, StupidThingsMod.MOD_ID);
}
