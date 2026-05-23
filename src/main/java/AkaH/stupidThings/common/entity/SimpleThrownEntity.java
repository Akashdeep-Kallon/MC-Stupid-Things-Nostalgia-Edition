package AkaH.stupidThings.common.entity;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class SimpleThrownEntity extends ThrowableItemProjectile {
    public SimpleThrownEntity(EntityType<? extends SimpleThrownEntity> type, Level level) { super(type, level); }

    @Override
    protected Item getDefaultItem() { return Items.SNOWBALL; }

    @Override
    public Packet<?> getAddEntityPacket() { return NetworkHooks.getEntitySpawningPacket(this); }
}
