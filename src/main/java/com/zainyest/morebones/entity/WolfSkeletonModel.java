// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
package com.zainyest.morebones.entity;

import com.google.common.collect.ImmutableList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.TintableAnimalModel;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class WolfSkeletonModel<T extends WolfSkeletonEntity> extends TintableAnimalModel<T> {

	private static final String REAL_HEAD = "real_head";
	private static final String UPPER_BODY = "upper_body";
	private static final String REAL_TAIL = "real_tail";
	private final ModelPart head;
	private final ModelPart realHead;
	private final ModelPart jaw;
	private final ModelPart torso;
	private final ModelPart rightHindLeg;
	private final ModelPart leftHindLeg;
	private final ModelPart rightFrontLeg;
	private final ModelPart leftFrontLeg;
	private final ModelPart tail;
	private final ModelPart realTail;

	public WolfSkeletonModel(ModelPart root) {
		this.head = root.getChild("head");
		this.realHead = this.head.getChild("real_head");
		this.jaw = this.head.getChild("jaw");
		this.torso = root.getChild("body");
		this.rightHindLeg = root.getChild("right_hind_leg");
		this.leftHindLeg = root.getChild("left_hind_leg");
		this.rightFrontLeg = root.getChild("right_front_leg");
		this.leftFrontLeg = root.getChild("left_front_leg");
		this.tail = root.getChild("tail");
		this.realTail = this.tail.getChild("real_tail");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData bodyData = modelData.getRoot();
		float f = 13.5F;
		ModelPartData headData = bodyData.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 13.5F, -7.0F));
		headData.addChild("real_head", ModelPartBuilder.create().uv(27, 0).cuboid(-2.0F, -3.0F, -2.0F, 6.0F, 6.0F, 3.0F).uv(0, 0).cuboid(-0.5F, 0.0F, -5.0F, 3.0F, 2.0F, 3.0F), ModelTransform.NONE);
		headData.addChild("jaw", ModelPartBuilder.create().uv(23, 38).cuboid(-0.5F, 0.5F, -5.0F, 3.0F, 2.0F, 3.0F), ModelTransform.of(0.0f, 0.5f, -0.0f, 0.30f, 0.0f, 0.0f));
		bodyData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -2.0F, -3.0F, 6.0F, 6.0F, 15.0F), ModelTransform.of(0.0F, 13.0F, -4.0F, 0.0F, 0.0F, 0.0F));
		ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(0, 34).cuboid(0.0F, 0.0F, -1.0F, 1.0F, 8.0F, 1.0F);
		bodyData.addChild("right_hind_leg", modelPartBuilder, ModelTransform.pivot(-2.5F, 16.0F, 7.0F));
		bodyData.addChild("left_hind_leg", modelPartBuilder, ModelTransform.pivot(1.5F, 16.0F, 7.0F));
		bodyData.addChild("right_front_leg", modelPartBuilder, ModelTransform.pivot(-2.5F, 16.0F, -4.0F));
		bodyData.addChild("left_front_leg", modelPartBuilder, ModelTransform.pivot(1.5F, 16.0F, -4.0F));
		ModelPartData tailData = bodyData.addChild("tail", ModelPartBuilder.create(), ModelTransform.of(-1.0F, 12.0F, 8.0F, 0.62831855F, 0.0F, 0.0F));
		tailData.addChild("real_tail", ModelPartBuilder.create().uv(20, 26).cuboid(0.0F, 0.0F, -1.0F, 2.0F, 2.0F, 8.0F), ModelTransform.NONE);
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.head.pitch = headPitch * 0.017453292F;
		this.head.yaw = netHeadYaw * 0.017453292F;
		this.tail.pitch = -0.3f;
		this.jaw.pitch = 0.30f * (MathHelper.cos(ageInTicks * 0.05f) + 1.0f) * 0.5f;
	}

	@Override
	public void animateModel(T entity, float f, float g, float h) {
		if (entity.hasAngerTime()) {
			this.tail.yaw = 0.0F;
		} else {
			this.tail.yaw = MathHelper.cos(f * 0.6662F) * 1.4F * g;
		}

		if (entity.isInSittingPose()) {
			this.torso.setPivot(0.0F, 18.0F, 0.0F);
			this.torso.pitch = 0.7853982F;
			this.tail.setPivot(-1.0F, 21.0F, 6.0F);
			this.rightHindLeg.setPivot(-2.5F, 22.7F, 2.0F);
			this.rightHindLeg.pitch = 4.712389F;
			this.leftHindLeg.setPivot(0.5F, 22.7F, 2.0F);
			this.leftHindLeg.pitch = 4.712389F;
			this.rightFrontLeg.pitch = 5.811947F;
			this.rightFrontLeg.setPivot(-2.49F, 17.0F, -4.0F);
			this.leftFrontLeg.pitch = 5.811947F;
			this.leftFrontLeg.setPivot(0.51F, 17.0F, -4.0F);
		} else {
			this.torso.setPivot(0.0F, 13.0F, -4.0F);
			this.torso.pitch = 0.0F;
			this.tail.setPivot(-1.0F, 12.0F, 8.0F);
			this.rightHindLeg.setPivot(-2.5F, 16.0F, 7.0F);
			this.leftHindLeg.setPivot(1.5F, 16.0F, 7.0F);
			this.rightFrontLeg.setPivot(-2.5F, 16.0F, -4.0F);
			this.leftFrontLeg.setPivot(1.5F, 16.0F, -4.0F);
			this.rightHindLeg.pitch = MathHelper.cos(f * 0.6662F) * 1.4F * g;
			this.leftHindLeg.pitch = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * g;
			this.rightFrontLeg.pitch = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * g;
			this.leftFrontLeg.pitch = MathHelper.cos(f * 0.6662F) * 1.4F * g;
		}
	}

	@Override
	protected Iterable<ModelPart> getHeadParts() {
		return ImmutableList.of(this.head);
	}

	@Override
	protected Iterable<ModelPart> getBodyParts() {
		return ImmutableList.of(this.torso, this.rightHindLeg, this.leftHindLeg, this.rightFrontLeg, this.leftFrontLeg, this.tail);
	}
}