package com.zainyest.morebones;

import com.zainyest.morebones.entity.GiantWolfSkeletonEntity;
import com.zainyest.morebones.entity.WolfSkeletonEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class MoreBones implements ModInitializer {
	public static final String MOD_ID = "morebones";

	//Entity Type registering
	//Wolf Skeleton:
	public static final EntityType<WolfSkeletonEntity> WOLF_SKELETON = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WolfSkeletonEntity::new).dimensions(EntityDimensions.fixed(0.6f, 0.8f)).build();
	//Giant Wolf Skeleton
	public static final EntityType<GiantWolfSkeletonEntity> GIANT_WOLF_SKELETON = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, GiantWolfSkeletonEntity::new).dimensions(EntityDimensions.fixed(2.0f, 2.5f)).build();
	//Bonerang
	public static final EntityType<BonerangEntity> BONERANG_ENTITY = FabricEntityTypeBuilder.<BonerangEntity>create(SpawnGroup.MISC, BonerangEntity::new).dimensions(EntityDimensions.fixed(0.25f, 0.25f)).trackRangeBlocks(4).trackedUpdateRate(10).build();

	//Item Instantiation
	//Totem of Undeath
	public static final TotemOfUndeath TOTEM_OF_UNDEATH = new TotemOfUndeath(new FabricItemSettings().group(ItemGroup.COMBAT).maxCount(1).rarity(Rarity.EPIC));
	//Bonerang
	public static final BonerangItem BONERANG_ITEM = new BonerangItem(new FabricItemSettings().group(ItemGroup.COMBAT).maxCount(1).rarity(Rarity.EPIC).maxDamage(800));

	@Override
	public void onInitialize() {

		//Item Registration
		//Totem of Undeath
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "totem_of_undeath"), TOTEM_OF_UNDEATH);
		//Bonerang
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bonerang"), BONERANG_ITEM);

		//Entity Registering
		//Wolf Skeleton
		Registry.register(Registry.ENTITY_TYPE, new Identifier(MOD_ID, "wolf_skeleton"), WOLF_SKELETON);
		//Giant Wolf Skeleton
		Registry.register(Registry.ENTITY_TYPE, new Identifier(MOD_ID, "giant_wolf_skeleton"), GIANT_WOLF_SKELETON);
		//Bonerang
		Registry.register(Registry.ENTITY_TYPE, new Identifier(MOD_ID, "bonerang"), BONERANG_ENTITY);
		System.out.println("morebones entity registered");

		//Attribute registering
		//Wolf Skeleton
		FabricDefaultAttributeRegistry.register(WOLF_SKELETON, WolfSkeletonEntity.createWolfSkeletonAttributes());
		//Giant Wolf Skeleton
		FabricDefaultAttributeRegistry.register(GIANT_WOLF_SKELETON, GiantWolfSkeletonEntity.createGiantWolfSkeletonAttributes());
		System.out.println("morebones attributes registered");
	}
}
