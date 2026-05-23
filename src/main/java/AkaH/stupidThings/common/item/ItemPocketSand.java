package AkaH.stupidThings.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ItemPocketSand extends Item {
    public ItemPocketSand(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("Right click to throw").withStyle(ChatFormatting.GOLD));
        tooltip.add(Component.literal("Blinds nearby enemies").withStyle(ChatFormatting.GOLD));
        tooltip.add(Component.empty());
        tooltip.add(Component.literal("(King of the Hill reference)").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack held = player.getItemInHand(hand);
        if (!level.isClientSide && level instanceof ServerLevel serverLevel) {
            var look = player.getLookAngle();
            double px = player.getX() + look.x * 2.0D;
            double py = player.getY() + player.getBbHeight() * 0.6D + look.y * 2.0D;
            double pz = player.getZ() + look.z * 2.0D;

            BlockParticleOption sandCrack = new BlockParticleOption(ParticleTypes.BLOCK, Blocks.SAND.defaultBlockState());
            serverLevel.sendParticles(sandCrack, px, py, pz, 40, 0.5D, 0.25D, 0.5D, 0.0D);
            serverLevel.sendParticles(ParticleTypes.FALLING_DUST, px, py, pz, 40, 0.5D, 0.25D, 0.5D, 0.0D);

            AABB aabb = player.getBoundingBox().inflate(1.0D).move(look.scale(2.0D));
            for (LivingEntity living : level.getEntitiesOfClass(LivingEntity.class, aabb, e -> e != player)) {
                living.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0, false, true));
            }

            level.playSound(null, player.blockPosition(), SoundEvents.SAND_BREAK, SoundSource.PLAYERS, 1.0F, 1.3F + level.random.nextFloat());
        }

        player.getCooldowns().addCooldown(this, 20);
        return InteractionResultHolder.sidedSuccess(held, level.isClientSide);
    }
}
