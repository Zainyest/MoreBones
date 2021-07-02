package com.zainyest.morebones;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.TintableAnimalModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class WolfSkeletonRenderer extends MobEntityRenderer<WolfSkeletonEntity, TintableAnimalModel<WolfSkeletonEntity>> {
    public WolfSkeletonRenderer(EntityRendererFactory.Context context) {
        super(context, new WolfSkeletonModel(WolfSkeletonModel.getTexturedModelData().createModel()), 0.5f);
        System.out.println("morebones WolfSkeletonRenderer");
        //WolfSkeletonModel(context.getPart(MoreBonesClient.WOLF_SKELETON_MODEL))
    }

    //public void render(WolfSkeletonEntity wolfSkeletonEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
    //}

    @Override
    public Identifier getTexture(WolfSkeletonEntity entity) {
        return new Identifier("morebones", "textures/entity/wolfskeleton.png");
    }
}
