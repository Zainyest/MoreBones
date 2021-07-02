package com.zainyest.morebones;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class MoreBones implements ModInitializer {
	public static final String MOD_ID = "morebones";

	//Entity Type registering
	//Wolf Skeleton:
	public static final EntityType<WolfSkeletonEntity> WOLF_SKELETON = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WolfSkeletonEntity::new).dimensions(EntityDimensions.fixed(0.6f, 0.8f)).build();

	@Override
	public void onInitialize() {
		//Entity Registering
		//Wolf Skeleton
		Registry.register(Registry.ENTITY_TYPE, new Identifier(MOD_ID, "wolf_skeleton"), WOLF_SKELETON);
		System.out.println("morebones Entity registered");
		//Attribute registering
		//Wolf Skeleton:
		FabricDefaultAttributeRegistry.register(WOLF_SKELETON, WolfSkeletonEntity.createWolfSkeletonAttributes());
		System.out.println("morebones attributes registered");
	}
}
