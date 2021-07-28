package com.zainyest.morebones.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.Identifier;

public class GiantSkeletonWolfRenderer extends MobEntityRenderer<GiantWolfSkeletonEntity, EntityModel<GiantWolfSkeletonEntity>> {
    public GiantSkeletonWolfRenderer(EntityRendererFactory.Context context) {
        super(context, new GiantSkeletonWolfModel(GiantSkeletonWolfModel.getTexturedModelData().createModel()), 1.5f);
    }

    @Override
    public Identifier getTexture(GiantWolfSkeletonEntity entity) {
        return new Identifier("morebones", "textures/entity/giantskeletonwolf.png");
    }
}
