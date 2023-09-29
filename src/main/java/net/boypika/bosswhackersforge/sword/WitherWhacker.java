package net.boypika.bosswhackersforge.sword;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class WitherWhacker extends SwordItem {
    public WitherWhacker(Tier tier, int attackDamage, float attackSpeed, Properties properties){
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        if (target instanceof WitherBoss){
            target.hurt(Objects.requireNonNull(target.getLastDamageSource()), 100000000000f);
        }
        else {
            attacker.sendSystemMessage(Component.translatable("text.item.bosswhackers.event_fail_message.wither_whacker"));
            target.heal(1f);
        }
        return true;
    }
}