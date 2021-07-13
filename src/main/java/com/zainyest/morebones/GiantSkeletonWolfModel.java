// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
package com.zainyest.morebones;

import com.google.common.collect.ImmutableList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class GiantSkeletonWolfModel<T extends GiantWolfSkeletonEntity> extends EntityModel<T> {
	private final ModelPart head;
	private final ModelPart skull;
	private final ModelPart jaw;

	private final ModelPart torso;

	private final ModelPart neck;
	//private final ModelPart vertebraeRidgesX;
	//private final ModelPart vertebraeRidgesY;
	//private final ModelPart vertebrae;

	private final ModelPart frontRightLeg;
	private final ModelPart frontRightThigh;
	private final ModelPart frontRightForeLeg;
	private final ModelPart frontRightPaw;

	private final ModelPart backRightLeg;
	private final ModelPart backRightThigh;
	private final ModelPart backRightKnee;
	private final ModelPart backRightPaw;

	private final ModelPart tail;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart tailEnd;

	private final ModelPart frontLeftLeg;
	private final ModelPart frontLeftThigh;
	private final ModelPart frontLeftForeLeg;
	private final ModelPart frontLeftPaw;

	private final ModelPart backLeftLeg;
	private final ModelPart backLeftThigh;
	private final ModelPart backLeftKnee;
	private final ModelPart backLeftPaw;

	public GiantSkeletonWolfModel(ModelPart root) {
		this.head = root.getChild("head");
		this.skull = this.head.getChild("skull");
		this.jaw = this.head.getChild("jaw");

		this.torso = root.getChild("torso");

		this.neck = root.getChild("neck");
		//this.vertebrae = this.neck.getChild("vertebrae");
		//this.vertebraeRidgesX = this.vertebrae.getChild("vertebraeRidgesX");
		//this.vertebraeRidgesY = this.vertebrae.getChild("vertebraeRidgesY");

		this.frontRightLeg = root.getChild("frontRightLeg");
		this.frontRightThigh = this.frontRightLeg.getChild("frontRightThigh");
		this.frontRightForeLeg = this.frontRightLeg.getChild("frontRightForeLeg");
		this.frontRightPaw = this.frontRightLeg.getChild("frontRightPaw");

		this.backRightLeg = root.getChild("backRightLeg");
		this.backRightThigh = this.backRightLeg.getChild("backRightThigh");
		this.backRightKnee = this.backRightLeg.getChild("backRightKnee");
		this.backRightPaw = this.backRightLeg.getChild("backRightPaw");

		this.tail = root.getChild("tail");
		this.tail1 = this.tail.getChild("tail1");
		this.tail2 = this.tail.getChild("tail2");
		this.tailEnd = this.tail.getChild("tailEnd");

		this.frontLeftLeg = root.getChild("frontLeftLeg");
		this.frontLeftThigh = this.frontLeftLeg.getChild("frontLeftThigh");
		this.frontLeftForeLeg = this.frontLeftLeg.getChild("frontLeftForeLeg");
		this.frontLeftPaw = this.frontLeftLeg.getChild("frontLeftPaw");

		this.backLeftLeg = root.getChild("backLeftLeg");
		this.backLeftThigh = this.backLeftLeg.getChild("backLeftThigh");
		this.backLeftKnee = this.backLeftLeg.getChild("backLeftKnee");
		this.backLeftPaw = this.backLeftLeg.getChild("backLeftPaw");

		/*
		int textureWidth = 256;
		int textureHeight = 256;
		head = new ModelPart(this);
		head.setPivot(0.0F, -21.0F, -30.0F);
		setRotationAngle(head, 0.0F, 0.5672F, 0.0F);
		head.uv(64, 0).addCuboid(-7.0F, -2.0F, -14.0F, 14.0F, 13.0F, 14.0F, 0.0F, false);
		head.uv(0, 84).addCuboid(-5.0F, 3.0F, -28.0F, 10.0F, 4.0F, 14.0F, 0.0F, false);

		lowerJaw_r1 = new ModelPart(this);
		lowerJaw_r1.setPivot(0.0F, 9.0F, -14.0F);
		head.addChild(lowerJaw_r1);
		setRotationAngle(lowerJaw_r1, 0.0873F, 0.0F, 0.0F);
		lowerJaw_r1.uv(80, 48).addCuboid(-5.0F, -2.0F, -14.0F, 10.0F, 4.0F, 14.0F, 0.0F, false);


		torso = new ModelPart(this);
		torso.setPivot(0.0F, 18.0F, -14.0F);
		torso.uv(0, 48).addCuboid(-12.0F, -36.0F, -8.0F, 24.0F, 20.0F, 16.0F, 0.0F, false);
		torso.uv(0, 0).addCuboid(-8.0F, -33.0F, 8.0F, 16.0F, 16.0F, 32.0F, 0.0F, false);
		torso.uv(25, 136).addCuboid(0.0F, -39.0F, -8.0F, 0.0F, 4.0F, 16.0F, 0.0F, false);
		torso.uv(25, 125).addCuboid(0.0F, -36.0F, 8.0F, 0.0F, 4.0F, 32.0F, 0.0F, false);


		neck = new ModelPart(this);
		neck.setPivot(0.0F, -20.0F, -26.0F);

		vertebraeRidgesX_r1 = new ModelPart(this);
		vertebraeRidgesX_r1.setPivot(0.0F, 0.9397F, -0.342F);
		neck.addChild(vertebraeRidgesX_r1);
		setRotationAngle(vertebraeRidgesX_r1, -0.3491F, 0.0F, 0.0F);
		vertebraeRidgesX_r1.uv(0, 156).addCuboid(-4.0F, 0.0F, -5.0F, 8.0F, 0.0F, 10.0F, 0.0F, false);

		vertebraeRidgesY_r1 = new ModelPart(this);
		vertebraeRidgesY_r1.setPivot(0.0F, 1.4095F, -0.513F);
		neck.addChild(vertebraeRidgesY_r1);
		setRotationAngle(vertebraeRidgesY_r1, -0.3491F, 0.0F, 0.0F);
		vertebraeRidgesY_r1.uv(25, 135).addCuboid(0.0F, -3.5F, -5.0F, 0.0F, 7.0F, 10.0F, 0.0F, false);

		vertebrae_r1 = new ModelPart(this);
		vertebrae_r1.setPivot(0.0F, 0.0F, 0.0F);
		neck.addChild(vertebrae_r1);
		setRotationAngle(vertebrae_r1, -0.3491F, 0.0F, 0.0F);
		vertebrae_r1.uv(0, 141).addCuboid(-2.0F, 0.0F, -5.0F, 4.0F, 3.0F, 10.0F, 0.0F, false);


		frontRightLeg = new ModelPart(this);
		frontRightLeg.setPivot(-14.25F, -11.0F, -13.5F);
		//foot
		frontRightLeg.uv(56, 90).addCuboid(-1.0F, 32.0F, -4.5F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		//claws
		frontRightLeg.uv(13, 212).addCuboid(1.5F, 32.0F, -7.5F, 0.0F, 3.0F, 3.0F, 0.0F, false);
		frontRightLeg.uv(13, 212).addCuboid(0.5F, 32.0F, -7.5F, 0.0F, 3.0F, 3.0F, 0.0F, false);
		frontRightLeg.uv(13, 212).addCuboid(-0.5F, 32.0F, -7.5F, 0.0F, 3.0F, 3.0F, 0.0F, false);
		//scapula
		frontRightLeg.uv(0, 220).addCuboid(1.5F, -4.0F, -4.5F, 0.0F, 8.0F, 9.0F, 0.0F, false);

		frontRightThigh_r1 = new ModelPart(this);
		frontRightThigh_r1.setPivot(0.5F, 9.0F, 0.0F);
		frontRightLeg.addChild(frontRightThigh_r1);
		setRotationAngle(frontRightThigh_r1, 0.3491F, 0.0F, 0.0F);
		frontRightThigh_r1.uv(34, 111).addCuboid(-1.5F, -8.0F, -1.5F, 3.0F, 16.0F, 3.0F, 0.0F, false);

		frontRightForeLeg_r1 = new ModelPart(this);
		frontRightForeLeg_r1.setPivot(0.0F, 23.0F, 0.5F);
		frontRightLeg.addChild(frontRightForeLeg_r1);
		setRotationAngle(frontRightForeLeg_r1, -0.1745F, 0.0F, 0.0F);
		frontRightForeLeg_r1.uv(71, 115).addCuboid(-0.5F, -8.0F, -1.0F, 2.0F, 19.0F, 3.0F, 0.0F, false);


		backRightLeg = new ModelPart(this);
		backRightLeg.setPivot(-10.75F, -9.0F, 20.5F);
		//backRightPaw
		backRightLeg.uv(106, 0).addCuboid(-1.5F, 30.0F, -1.75F, 4.0F, 3.0F, 6.0F, 0.0F, false);
		//claws
		backRightLeg.uv(13, 212).addCuboid(-1.0F, 30.0F, -4.75F, 0.0F, 3.0F, 3.0F, 0.0F, false);
		backRightLeg.uv(13, 212).addCuboid(0.0F, 30.0F, -4.75F, 0.0F, 3.0F, 3.0F, 0.0F, false);
		backRightLeg.uv(13, 212).addCuboid(1.0F, 30.0F, -4.75F, 0.0F, 3.0F, 3.0F, 0.0F, false);
		backRightLeg.uv(13, 212).addCuboid(2.0F, 30.0F, -4.75F, 0.0F, 3.0F, 3.0F, 0.0F, false);
		//backRightForeLeg
		backRightLeg.uv(0, 120).addCuboid(-0.5F, 21.0F, 1.5F, 2.0F, 11.0F, 3.0F, 0.0F, false);

		backRightThigh_r1 = new ModelPart(this);
		backRightThigh_r1.setPivot(0.5F, 6.0F, -2.5F);
		backRightLeg.addChild(backRightThigh_r1);
		setRotationAngle(backRightThigh_r1, -0.4363F, 0.0F, 0.0F);
		backRightThigh_r1.uv(102, 79).addCuboid(-2.0F, -8.0F, -2.0F, 4.0F, 17.0F, 4.0F, 0.0F, false);

		backRightKnee_r1 = new ModelPart(this);
		backRightKnee_r1.setPivot(0.5F, 17.5F, -1.0F);
		backRightLeg.addChild(backRightKnee_r1);
		setRotationAngle(backRightKnee_r1, -0.6981F, 0.0F, 0.0F);
		backRightKnee_r1.uv(72, 90).addCuboid(-1.5F, -1.5F, -6.5F, 3.0F, 3.0F, 13.0F, 0.0F, false);


		tail = new ModelPart(this);
		tail.setPivot(0.0F, 14.0F, -14.0F);
		//tail end small
		tail.uv(0, 102).addCuboid(-0.5F, -28.5F, 72.0F, 1.0F, 1.0F, 16.0F, 0.0F, false);
		//tail end ridges Small
		tail.uv(0, 199).addCuboid(-1.5F, -28.0F, 72.0F, 3.0F, 0.0F, 16.0F, 0.0F, false);
		//tail 2 small
		tail.uv(97, 27).addCuboid(-0.5F, -28.5F, 56.0F, 1.0F, 1.0F, 16.0F, 0.0F, false);
		//tail 2 ridges small
		tail.uv(0, 183).addCuboid(-1.5F, -28.0F, 56.0F, 3.0F, 0.0F, 16.0F, 0.0F, false);
		//tail Large
		tail.uv(66, 68).addCuboid(-1.0F, -29.0F, 40.0F, 2.0F, 2.0F, 16.0F, 0.0F, false);
		//tail ridges large
		tail.uv(0, 167).addCuboid(-2.0F, -28.0F, 40.0F, 4.0F, 0.0F, 16.0F, 0.0F, false);


		frontLeftLeg = new ModelPart(this);
		frontLeftLeg.setPivot(13.25F, -11.0F, -13.5F);
		//scapula
		frontLeftLeg.uv(0, 220).addCuboid(-0.5F, -4.0F, -4.5F, 0.0F, 8.0F, 9.0F, 0.0F, false);
		//foot
		frontLeftLeg.uv(56, 90).addCuboid(-1.0F, 32.0F, -4.5F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		//claws
		frontLeftLeg.uv(13, 212).addCuboid(1.5F, 32.0F, -7.5F, 0.0F, 3.0F, 3.0F, 0.0F, false);
		frontLeftLeg.uv(13, 212).addCuboid(0.5F, 32.0F, -7.5F, 0.0F, 3.0F, 3.0F, 0.0F, false);
		frontLeftLeg.uv(13, 212).addCuboid(-0.5F, 32.0F, -7.5F, 0.0F, 3.0F, 3.0F, 0.0F, false);

		frontLeftThigh_r1 = new ModelPart(this);
		frontLeftThigh_r1.setPivot(0.0F, 9.0F, 0.0F);
		frontLeftLeg.addChild(frontLeftThigh_r1);
		setRotationAngle(frontLeftThigh_r1, 0.3491F, 0.0F, 0.0F);
		frontLeftThigh_r1.uv(34, 111).addCuboid(-1.0F, -8.0F, -1.5F, 3.0F, 16.0F, 3.0F, 0.0F, false);

		frontLeftForeLeg_r1 = new ModelPart(this);
		frontLeftForeLeg_r1.setPivot(0.0F, 23.0F, 0.5F);
		frontLeftLeg.addChild(frontLeftForeLeg_r1);
		setRotationAngle(frontLeftForeLeg_r1, -0.1745F, 0.0F, 0.0F);
		frontLeftForeLeg_r1.uv(71, 115).addCuboid(-0.5F, -8.0F, -1.0F, 2.0F, 19.0F, 3.0F, 0.0F, false);

		backLeftLeg = new ModelPart(this);
		backLeftLeg.setPivot(9.75F, -9.0F, 20.5F);
		backLeftLeg.uv(106, 0).addCuboid(-1.5F, 30.0F, -1.75F, 4.0F, 3.0F, 6.0F, 0.0F, false);
		backLeftLeg.uv(13, 212).addCuboid(-1.0F, 30.0F, -4.75F, 0.0F, 3.0F, 3.0F, 0.0F, false);
		backLeftLeg.uv(13, 212).addCuboid(0.0F, 30.0F, -4.75F, 0.0F, 3.0F, 3.0F, 0.0F, false);
		backLeftLeg.uv(13, 212).addCuboid(1.0F, 30.0F, -4.75F, 0.0F, 3.0F, 3.0F, 0.0F, false);
		backLeftLeg.uv(13, 212).addCuboid(2.0F, 30.0F, -4.75F, 0.0F, 3.0F, 3.0F, 0.0F, false);
		backLeftLeg.uv(0, 120).addCuboid(-0.5F, 21.0F, 1.5F, 2.0F, 11.0F, 3.0F, 0.0F, false);

		backLeftThigh_r1 = new ModelPart(this);
		backLeftThigh_r1.setPivot(0.5F, 6.0F, -2.5F);
		backLeftLeg.addChild(backLeftThigh_r1);
		setRotationAngle(backLeftThigh_r1, -0.4363F, 0.0F, 0.0F);
		backLeftThigh_r1.uv(102, 79).addCuboid(-2.0F, -8.0F, -2.0F, 4.0F, 17.0F, 4.0F, 0.0F, false);

		backLeftKnee_r1 = new ModelPart(this);
		backLeftKnee_r1.setPivot(0.5F, 17.5F, -1.0F);
		backLeftLeg.addChild(backLeftKnee_r1);
		setRotationAngle(backLeftKnee_r1, -0.6981F, 0.0F, 0.0F);
		backLeftKnee_r1.uv(72, 90).addCuboid(-1.5F, -1.5F, -6.5F, 3.0F, 3.0F, 13.0F, 0.0F, false);

		 */
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData bodyData = modelData.getRoot();
		//head
		ModelPartData headData = bodyData.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -21.0F, -30.0F));
		headData.addChild("skull", ModelPartBuilder.create()
				.uv(64, 0).cuboid(-7.0F, -2.0F, -14.0F, 14.0F, 13.0F, 14.0F)
				.uv(0, 84).cuboid(-5.0F, 3.0F, -28.0F, 10.0F, 4.0F, 14.0F)
				.uv(0, 238).cuboid(-2.0F, 2.0F, -28.0F, 4.0F, 1.0F, 14.0F), ModelTransform.NONE);
		headData.addChild("jaw", ModelPartBuilder.create()
				.uv(80, 48).cuboid(-5.0F, -3.5F, -14.0F, 10.0F, 4.0F, 14.0F), ModelTransform.pivot(0.0F, 9.0F, -14.0F));
		//torso
		bodyData.addChild("torso", ModelPartBuilder.create()
				.uv(0, 0).cuboid(-8.0F, -33.0F, 8.0F, 16.0F, 16.0F, 32.0F)
				.uv(0, 48).cuboid(-12.0F, -36.0F, -8.0F, 24.0F, 20.0F, 16.0F)
				.uv(25, 136).cuboid(0.0F, -39.0F, -8.0F, 0.0F, 4.0F, 16.0F)
				.uv(25, 125).cuboid(0.0F, -36.0F, 8.0F, 0.0F, 4.0F, 32.0F), ModelTransform.pivot(0.0F, 18.0F, -14.0F));
		//neck
		bodyData.addChild("neck", ModelPartBuilder.create()
				.uv(0, 141).cuboid(-2.0F, 0.0F, -5.0F, 4.0F, 3.0F, 10.0F)
				.uv(0, 156).cuboid(-4.0F, 1.5F, -5.0F, 8.0F, 0.0F, 10.0F)
				.uv(25, 135).cuboid(0.0F, -2.0F, -5.0F, 0.0F, 7.0F, 10.0F), ModelTransform.pivot(0.0F, -20.0F, -26.0F));
		//legs
		//frontRightLeg
		ModelPartData frontRightLegData = bodyData.addChild("frontRightLeg", ModelPartBuilder.create(), ModelTransform.pivot(-14.25F, -11.0F, -13.5F));
		frontRightLegData.addChild("frontRightThigh", ModelPartBuilder.create()
				.uv(34, 111).cuboid(-1.5F, -8.0F, -1.5F, 3.0F, 16.0F, 3.0F)
				.uv(0, 220).cuboid(1.5F, -4.0F, -4.5F, 0.0F, 8.0F, 9.0F), ModelTransform.pivot(0.5F, 9.0F, 0.0F));
		frontRightLegData.addChild("frontRightForeLeg", ModelPartBuilder.create()
				.uv(71, 115).cuboid(-0.5F, -8.0F, -1.0F, 2.0F, 19.0F, 3.0F), ModelTransform.pivot(0.0F, 23.0F, 0.5F));
		frontRightLegData.addChild("frontRightPaw", ModelPartBuilder.create()
				.uv(56, 90).cuboid(-1.0F, 2.0F, -4.5F, 3.0F, 3.0F, 5.0F)
				.uv(13, 212).cuboid(1.5F, 2.0F, -7.5F, 0.0F, 3.0F, 3.0F)
				.uv(13, 212).cuboid(0.5F, 2.0F, -7.5F, 0.0F, 3.0F, 3.0F)
				.uv(13, 212).cuboid(-0.5F, 2.0F, -7.5F, 0.0F, 3.0F, 3.0F), ModelTransform.pivot(0.0F, 30F, 0.0F));
		//frontLeftLeg
		ModelPartData frontLeftLegData = bodyData.addChild("frontLeftLeg", ModelPartBuilder.create(), ModelTransform.pivot(13.25F, -11.0F, -13.5F));
		frontLeftLegData.addChild("frontLeftThigh", ModelPartBuilder.create()
				.uv(34, 111).cuboid(-1.5F, -8.0F, -1.5F, 3.0F, 16.0F, 3.0F)
				.uv(0, 220).cuboid(-0.5F, -4.0F, -4.5F, 0.0F, 8.0F, 9.0F), ModelTransform.pivot(0.5F, 9.0F, 0.0F));
		frontLeftLegData.addChild("frontLeftForeLeg", ModelPartBuilder.create()
				.uv(71, 115).cuboid(-0.5F, -8.0F, -1.0F, 2.0F, 19.0F, 3.0F), ModelTransform.pivot(0.0F, 23.0F, 0.5F));
		frontLeftLegData.addChild("frontLeftPaw", ModelPartBuilder.create()
				.uv(56, 90).cuboid(-1.0F, 2.0F, -4.5F, 3.0F, 3.0F, 5.0F)
				.uv(13, 212).cuboid(1.5F, 2.0F, -7.5F, 0.0F, 3.0F, 3.0F)
				.uv(13, 212).cuboid(0.5F, 2.0F, -7.5F, 0.0F, 3.0F, 3.0F)
				.uv(13, 212).cuboid(-0.5F, 2.0F, -7.5F, 0.0F, 3.0F, 3.0F), ModelTransform.pivot(0.0F, 30F, 0.0F));
		//backRightLeg
		ModelPartData backRightLegData = bodyData.addChild("backRightLeg", ModelPartBuilder.create(), ModelTransform.pivot(-10.75F, -9.0F, 20.5F));
		backRightLegData.addChild("backRightThigh", ModelPartBuilder.create()
				.uv(102, 79).cuboid(-2.0F, -8.0F, -2.0F, 4.0F, 17.0F, 4.0F), ModelTransform.pivot(0.5F, 6.0F, -2.5F));
		backRightLegData.addChild("backRightKnee", ModelPartBuilder.create()
				.uv(72, 90).cuboid(-1.5F, -1.5F, -6.5F, 3.0F, 3.0F, 13.0F), ModelTransform.pivot(0.5F, 17.5F, -1.0F));
		backRightLegData.addChild("backRightForeLeg", ModelPartBuilder.create()
				.uv(0, 120).cuboid(-0.5F, 21.0F, 1.5F, 2.0F, 11.0F, 3.0F), ModelTransform.pivot(0.0F, 0.0F, 4.5F - 4.25F));
		backRightLegData.addChild("backRightPaw", ModelPartBuilder.create()
				.uv(106, 0).cuboid(-1.5F, 0.0F, -1.75F, 4.0F, 3.0F, 6.0F)
				.uv(13, 212).cuboid(-1.0F, 0.0F, -4.75F, 0.0F, 3.0F, 3.0F)
				.uv(13, 212).cuboid(0.0F, 0.0F, -4.75F, 0.0F, 3.0F, 3.0F)
				.uv(13, 212).cuboid(1.0F, 0.0F, -4.75F, 0.0F, 3.0F, 3.0F)
				.uv(13, 212).cuboid(2.0F, 0.0F, -4.75F, 0.0F, 3.0F, 3.0F), ModelTransform.pivot(0.0F, 30F, 0.0F));
		//backLeftLeg
		ModelPartData backLeftLegData = bodyData.addChild("backLeftLeg", ModelPartBuilder.create(), ModelTransform.pivot(9.75F, -9.0F, 20.5F));
		backLeftLegData.addChild("backLeftThigh", ModelPartBuilder.create()
				.uv(102, 79).cuboid(-2.0F, -8.0F, -2.0F, 4.0F, 17.0F, 4.0F), ModelTransform.pivot(0.5F, 6.0F, -2.5F));
		backLeftLegData.addChild("backLeftKnee", ModelPartBuilder.create()
				.uv(72, 90).cuboid(-1.5F, -1.5F, -6.5F, 3.0F, 3.0F, 13.0F), ModelTransform.pivot(0.5F, 17.5F, -1.0F));
		backLeftLegData.addChild("backLeftForeLeg", ModelPartBuilder.create()
				.uv(0, 120).cuboid(-0.5F, 21.0F, 1.5F, 2.0F, 11.0F, 3.0F), ModelTransform.pivot(0.0F, 0.0F, 4.5F - 4.25F));
		backLeftLegData.addChild("backLeftPaw", ModelPartBuilder.create()
				.uv(106, 0).cuboid(-1.5F, 0.0F, -1.75F, 4.0F, 3.0F, 6.0F)
				.uv(13, 212).cuboid(-1.0F, 0.0F, -4.75F, 0.0F, 3.0F, 3.0F)
				.uv(13, 212).cuboid(0.0F, 0.0F, -4.75F, 0.0F, 3.0F, 3.0F)
				.uv(13, 212).cuboid(1.0F, 0.0F, -4.75F, 0.0F, 3.0F, 3.0F)
				.uv(13, 212).cuboid(2.0F, 0.0F, -4.75F, 0.0F, 3.0F, 3.0F), ModelTransform.pivot(0.0F, 30F, 0.0F));
		//tail
		ModelPartData tailData = bodyData.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -10.0F, 39.0F));
		tailData.addChild("tail1", ModelPartBuilder.create()
				.uv(66, 68).cuboid(-1.0F, -1.0F, -14.0F, 2.0F, 2.0F, 16.0F)
				.uv(0, 167).cuboid(-2.0F, 0.0F, -14.0F, 4.0F, 0.0F, 16.0F), ModelTransform.NONE);
		tailData.addChild("tail2", ModelPartBuilder.create()
				.uv(97, 27).cuboid(-0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 16.0F)
				.uv(0, 183).cuboid(-1.5F, 0.0F, 2.0F, 3.0F, 0.0F, 16.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		tailData.addChild("tailEnd", ModelPartBuilder.create()
				.uv(0, 102).cuboid(-0.5F, -0.5F, 18.0F, 1.0F, 1.0F, 16.0F)
				.uv(0, 199).cuboid(-1.5F, 0.0F, 18.0F, 3.0F, 0.0F, 16.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 256, 256);
	}

	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.head.pitch = headPitch * 0.017453292F;
		this.head.yaw = netHeadYaw * 0.017453292F;

		this.tail.pitch = -0.3F;
		this.frontLeftForeLeg.pitch = -0.15F;
		this.frontRightForeLeg.pitch = -0.15F;
		this.frontRightThigh.pitch = 0.2f;
		this.frontLeftThigh.pitch = 0.2f;
		this.backLeftKnee.pitch = -0.6f;
		this.backRightKnee.pitch = -0.6f;
		this.backLeftThigh.pitch = -0.4f;
		this.backRightThigh.pitch = -0.4f;

		this.jaw.pitch = 0.30f * (MathHelper.cos(ageInTicks * 0.05f) + 1.0f) * 0.5f;
	}

	@Override
	public void animateModel(T entity, float f, float g, float h) {
		if (entity.hasAngerTime()) {
			this.tail.yaw = 0.0F;
		} else {
			//this.tail.yaw = MathHelper.cos(f * 0.6662F) * 1.4F * g;
			this.tail2.yaw = MathHelper.cos(f * 0.6662F) * 1.4F * g;
			this.tailEnd.yaw = MathHelper.cos(f * 0.6662F) * 1.4F * g;
		}

		this.backRightLeg.pitch = MathHelper.cos(f * 0.2f * 0.6662F) * 1.4F * g;
		this.backLeftLeg.pitch = MathHelper.cos(f * 0.2f * 0.6662F + 3.1415927F) * 1.4F * g;
		this.frontRightLeg.pitch = MathHelper.cos(f * 0.2f * 0.6662F + 3.1415927F) * 1.4F * g;
		this.frontLeftLeg.pitch = MathHelper.cos(f * 0.2f * 0.6662F) * 1.4F * g;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		this.getHeadParts().forEach((headPart) -> {
			headPart.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		});
		this.getBodyParts().forEach((bodyPart) -> {
			bodyPart.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		});
	}

	protected Iterable<ModelPart> getHeadParts() {
		return ImmutableList.of(this.head);
	}

	protected Iterable<ModelPart> getBodyParts() {
		return ImmutableList.of(this.torso, this.backRightLeg, this.backLeftLeg, this.frontLeftLeg, this.frontRightLeg, this.tail, this.neck);
	}
}