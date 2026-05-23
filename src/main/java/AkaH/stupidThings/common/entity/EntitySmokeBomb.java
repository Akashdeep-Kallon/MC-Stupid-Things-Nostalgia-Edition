package AkaH.stupidThings.common.entity;

import AkaH.stupidThings.common.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.List;

public class EntitySmokeBomb extends ThrowableItemProjectile {
    public EntitySmokeBomb(net.minecraft.world.entity.EntityType<? extends EntitySmokeBomb> type, Level level) {
        super(type, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SMOKE_BOMB.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (result.getEntity() instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0));
        }
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!level().isClientSide) {
            List<LivingEntity> entities = level().getEntitiesOfClass(LivingEntity.class, new AABB(blockPosition()).inflate(4.0D));
            for (LivingEntity living : entities) {
                living.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0));
            }
            ((ServerLevel) level()).sendParticles(ParticleTypes.CLOUD, getX(), getY(), getZ(), 40, 0.5D, 0.5D, 0.5D, 0.02D);
            discard();
        }
    }
}
