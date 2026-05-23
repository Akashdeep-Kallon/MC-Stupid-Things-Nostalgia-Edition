package AkaH.stupidThings.common.entity;

import AkaH.stupidThings.StupidThingsMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, StupidThingsMod.MOD_ID);

    // PORT: placeholders until full entity behavior is migrated from 1.12.2.
    public static final RegistryObject<EntityType<SimpleThrownEntity>> BALLOON = register("balloon");
    public static final RegistryObject<EntityType<SimpleThrownEntity>> BALLOON_LIQUID = register("balloon_liquid");
    public static final RegistryObject<EntityType<SimpleThrownEntity>> BLOCK_BOMB = register("block_bomb");
    public static final RegistryObject<EntityType<SimpleThrownEntity>> REVERSE_TNT_PRIMED = register("reverse_tnt_primed");
    public static final RegistryObject<EntityType<EntitySmokeBomb>> SMOKE_BOMB = ENTITY_TYPES.register("smoke_bomb", () -> EntityType.Builder.<EntitySmokeBomb>of(EntitySmokeBomb::new, MobCategory.MISC).sized(0.25F, 0.25F).build("smoke_bomb"));

    private static RegistryObject<EntityType<SimpleThrownEntity>> register(String id) {
        return ENTITY_TYPES.register(id, () -> EntityType.Builder.<SimpleThrownEntity>of(SimpleThrownEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).build(id));
    }
}
