package com.zainyest.morebones;

import com.zainyest.morebones.entity.GiantWolfSkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class TotemOfUndeath extends Item {
    public TotemOfUndeath(Settings settings) {
        super(settings);
    }

    //very temporary usage atm

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.ITEM_TOTEM_USE, 1.0F, 0.5F);
        GiantWolfSkeletonEntity giantWolfSkeletonEntity = new GiantWolfSkeletonEntity(MoreBones.GIANT_WOLF_SKELETON, world);
        giantWolfSkeletonEntity.setPosition(playerEntity.getPos().x, playerEntity.getPos().y, playerEntity.getPos().z);
        giantWolfSkeletonEntity.setYaw(playerEntity.getYaw());
        world.spawnEntity(giantWolfSkeletonEntity);
        world.emitGameEvent(playerEntity, GameEvent.ENTITY_PLACE, new BlockPos(giantWolfSkeletonEntity.getPos()));
        world.sendEntityStatus(playerEntity, (byte)35);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
