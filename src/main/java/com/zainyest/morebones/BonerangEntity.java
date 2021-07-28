package com.zainyest.morebones;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class BonerangEntity extends ProjectileEntity {
    public BonerangEntity(EntityType<? extends BonerangEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();

        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), 5.0F); // deals damage

        if (entity instanceof LivingEntity) { // checks if entity is an instance of LivingEntity (meaning it is not a boat or minecart)
            ((LivingEntity) entity).addStatusEffect((new StatusEffectInstance(StatusEffects.BLINDNESS, 20 * 3, 0))); // applies a status effect
            ((LivingEntity) entity).addStatusEffect((new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 3, 2))); // applies a status effect
            ((LivingEntity) entity).addStatusEffect((new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 3, 1))); // applies a status effect
            entity.playSound(SoundEvents.BLOCK_BONE_BLOCK_FALL, 2F, 0.5F); // plays a sound for the entity hit only
        }
    }

    @Override
    protected ItemStack asItemStack() {
        return null;
    }

    protected void onCollision(HitResult hitResult) { // called on collision with a block
        //TODO make this return to thrower
        super.onCollision(hitResult);
        if (!this.world.isClient) { // checks if the world is client
            this.world.sendEntityStatus(this, (byte)3); // particle?
            this.remove(RemovalReason.KILLED); // kills the projectile
        }
    }

    @Override
    protected void initDataTracker() {

    }
}
