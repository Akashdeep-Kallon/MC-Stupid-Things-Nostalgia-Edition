package AkaH.stupidThings.common.entity;

import AkaH.stupidThings.StupidThingsMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, StupidThingsMod.MOD_ID);

    public static final RegistryObject<EntityType<?>> BALLOON = register("balloon");
    public static final RegistryObject<EntityType<?>> BALLOON_LIQUID = register("balloon_liquid");
    public static final RegistryObject<EntityType<?>> BLOCK_BOMB = register("block_bomb");
    public static final RegistryObject<EntityType<?>> REVERSE_TNT_PRIMED = register("reverse_tnt_primed");
    public static final RegistryObject<EntityType<?>> SMOKE_BOMB = register("smoke_bomb");

    private static RegistryObject<EntityType<?>> register(String id) {
        return ENTITY_TYPES.register(id, () -> EntityType.Builder.of((type, level) -> null, MobCategory.MISC).sized(0.5F, 0.5F).build(id));
    }
}
