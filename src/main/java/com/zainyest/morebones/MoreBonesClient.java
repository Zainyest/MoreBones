package com.zainyest.morebones;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class MoreBonesClient implements ClientModInitializer {

    public static final EntityModelLayer WOLF_SKELETON_MODEL = new EntityModelLayer(new Identifier(MoreBones.MOD_ID, "wolf_skeleton"), "main");

    @Override
    public void onInitializeClient() {
        System.out.println("morebones CLIENT RENDER REGISTRY");
        //Entity renderer registering:
        //Wolf Skeleton
        EntityRendererRegistry.INSTANCE.register(MoreBones.WOLF_SKELETON, WolfSkeletonRenderer::new);
        System.out.println("morebones renderer registered");
        //Model Layer registering
        //Wolf Skeleton
        EntityModelLayerRegistry.registerModelLayer(WOLF_SKELETON_MODEL, WolfSkeletonModel::getTexturedModelData);
        System.out.println("morebones model layers registered");
    }
}
