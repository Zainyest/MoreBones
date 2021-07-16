package com.zainyest.morebones;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class MoreBones implements ModInitializer {
	public static final String MOD_ID = "morebones";

	//Entity Type registering
	//Wolf Skeleton:
	public static final EntityType<WolfSkeletonEntity> WOLF_SKELETON = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WolfSkeletonEntity::new).dimensions(EntityDimensions.fixed(0.6f, 0.8f)).build();
	public static final EntityType<GiantWolfSkeletonEntity> GIANT_WOLF_SKELETON = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, GiantWolfSkeletonEntity::new).dimensions(EntityDimensions.fixed(2.0f, 2.5f)).build();

	//Item Instantiation
	//Totem of Undeath
	public static final TotemOfUndeath TOTEM_OF_UNDEATH = new TotemOfUndeath(new FabricItemSettings().group(ItemGroup.COMBAT));

	@Override
	public void onInitialize() {

		//Item Registration
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "totem_of_undeath"), TOTEM_OF_UNDEATH);

		//Entity Registering
		//Wolf Skeleton
		Registry.register(Registry.ENTITY_TYPE, new Identifier(MOD_ID, "wolf_skeleton"), WOLF_SKELETON);
		//Giant Wolf Skeleton
		Registry.register(Registry.ENTITY_TYPE, new Identifier(MOD_ID, "giant_wolf_skeleton"), GIANT_WOLF_SKELETON);
		System.out.println("morebones entity registered");

		//Attribute registering
		//Wolf Skeleton
		FabricDefaultAttributeRegistry.register(WOLF_SKELETON, WolfSkeletonEntity.createWolfSkeletonAttributes());
		//Giant Wolf Skeleton
		FabricDefaultAttributeRegistry.register(GIANT_WOLF_SKELETON, GiantWolfSkeletonEntity.createGiantWolfSkeletonAttributes());
		System.out.println("morebones attributes registered");
	}
}
