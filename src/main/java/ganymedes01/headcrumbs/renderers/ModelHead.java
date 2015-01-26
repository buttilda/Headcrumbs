package ganymedes01.headcrumbs.renderers;

import ganymedes01.headcrumbs.libs.SkullTypes;

import java.util.HashMap;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.model.ModelRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelHead extends ModelBase {

	private static HashMap<SkullTypes, ModelHead> heads;

	private ModelRenderer head;
	private ModelRenderer overlay;
	private boolean renderOverlay;

	private ModelHead() {
		this(32);
	}

	private ModelHead(int height) {
		textureWidth = 64;
		textureHeight = height;
		renderOverlay = true;
		head = new ModelRenderer(this, 0, 0);
		overlay = new ModelRenderer(this, 32, 0);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		overlay.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
		overlay.setRotationPoint(0.0F, 0.0F, 0.0F);
	}

	public static ModelHead getHead(SkullTypes type) {
		if (heads == null) {
			heads = new HashMap<SkullTypes, ModelHead>();
			for (SkullTypes skull : SkullTypes.values())
				heads.put(skull, new ModelHead().setHeadType(skull));
		}

		transform(type);
		return heads.get(type);
	}

	private static void transform(SkullTypes skull) {
		switch (skull) {
			case squid:
			case pinky:
				GL11.glScaled(2F / 3F, 2F / 3F, 2F / 3F);
				break;
			case mistWolf:
			case winterWolf:
				GL11.glScaled(1.5, 1.5, 1.5);
				break;
			case bat:
			case fireBat:
			case enderDragon:
				GL11.glScaled(0.5, 0.5, 0.5);
				break;
			case slime:
			case mazeSlime:
			case thaumicSlime:
				GL11.glEnable(GL11.GL_NORMALIZE);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				break;
			case enderminy:
				GL11.glScalef(1, 0.5F, 1);
				break;
			default:
				break;
		}
	}

	private ModelHead hideOverlay() {
		renderOverlay = false;
		return this;
	}

	public void render(float rotationX) {
		render(rotationX, 0.0F);
	}

	public void render(float rotationX, float rotationY) {
		head.rotateAngleY = rotationX / (180F / (float) Math.PI);
		head.rotateAngleX = rotationY / (180F / (float) Math.PI);
		head.render(0.0625F);
		if (renderOverlay)
			renderOverlay(rotationX, rotationY);
	}

	public void renderOverlay(float rotationX) {
		renderOverlay(rotationX, 0.0F);
	}

	public void renderOverlay(float rotationX, float rotationY) {
		overlay.rotateAngleY = rotationX / (180F / (float) Math.PI);
		overlay.rotateAngleX = rotationY / (180F / (float) Math.PI);
		overlay.render(0.0625F);
	}

	private ModelHead setHeadType(SkullTypes type) {
		switch (type) {
			case enderman:
			case enderminy:
				setEnderman();
				break;
			case pigman:
				return new ModelHead(64);
			case spider:
			case caveSpider:
			case hedgeSpider:
			case kingSpider:
			case swarmSpider:
			case towerBroodling:
			case heatscarSpider:
				setSpider();
				break;
			case pig:
			case taintedPig:
				setPig();
				break;
			case mooshroom:
			case cow:
			case taintedCow:
				setCow();
				break;
			case sheep:
			case taintedSheep:
				setSheep();
				break;
			case wolf:
			case mistWolf:
			case hostileWolf:
			case winterWolf:
				setWolf();
				break;
			case direWolf:
				setDireWolf();
				break;
			case villager:
			case taintedVillager:
				setVillager(64);
				break;
			case chicken:
			case taintedChicken:
				setChicken();
				break;
			case witch:
			case witherWitch:
				setWitch();
				break;
			case zombieVillager:
				setZombieVillager();
				break;
			case ironGolem:
				setVillager(128);
				break;
			case squid:
				setSquid();
				break;
			case wither:
			case angryZombie:
				return new ModelHead(64).hideOverlay();
			case bunnyDutch:
			case bunnyBrown:
			case bunnyWhite:
				setBunny();
				break;
			case penguin:
				setPenguin();
				break;
			case bighorn:
				setBighorn();
				break;
			case wildDeer:
				setDeer();
				break;
			case wildBoar:
				setBoar();
				break;
			case redcap:
				setRedcap();
				break;
			case ghast:
			case miniGhast:
			case guardGhast:
				setGhast();
				break;
			case kobold:
				setKobold();
				break;
			case slimeBeetle:
				setSlimeBeetle();
				break;
			case fireBeetle:
				setFireBeetle();
				break;
			case pinchBeetle:
				setPinchBeetle();
				break;
			case towerGolem:
				setTowerGolem();
				break;
			case enderDragon:
				setEnderDragon();
				break;
			case squirrel:
				setSquirrel();
				break;
			case ocelot:
			case ocelotBlack:
			case ocelotRed:
			case ocelotSiamese:
			case witherCat:
				setOcelot();
				break;
			case bat:
			case fireBat:
				setBat();
				break;
			case slime:
			case mazeSlime:
			case thaumicSlime:
				setSlime();
				break;
			case magmaCube:
				setMagmaCube();
				break;
			case horseBlack:
			case horseBrown:
			case horseChestnut:
			case horseCreamy:
			case horseDarkBrown:
			case horseGrey:
			case horseWhite:
			case horseSkeleton:
			case horseUndead:
				setHorse(false);
				break;
			case donkey:
			case mule:
				setHorse(true);
				break;
			case snowMan:
				setSnowman();
				break;
			case silverfish:
			case towerwoodBorer:
				setSilverfish();
				break;
			case imp:
				setImp();
				break;
			case nitroCreeper:
			case concussionCreeper:
			case fallenKnight:
				hideOverlay();
				break;
			case pech:
				setPech();
				break;
			case eldritchGuardian:
				setEldrichGuardian();
				break;
			case pinky:
				setPinky();
				break;
			case behemoth:
				setBehemoth();
				break;
			case belph:
				setBelph();
				break;
			case blaze:
			case blizz:
			case druid:
			case player:
			case taintedCreeper:
			default:
				break;
		}
		return this;
	}

	private void setDireWolf() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -3.0F, -4.0F, 6, 6, 6, 0);
		head.setRotationPoint(2, -3F, 0);
		head.setTextureOffset(16, 18).addBox(-2.5F, -5.0F, -1.5F, 1, 2, 2, 0);
		head.setTextureOffset(16, 18).addBox(1.5F, -5.0F, -1.5F, 1, 2, 2, 0);
		head.setTextureOffset(0, 14).addBox(-1.5F, 0.0F, -7.0F, 3, 3, 4, 0);
		hideOverlay();
	}

	private void setPinky() {
		textureWidth = 128;
		textureHeight = 64;

		float f1 = 11;
		float f2 = -3;
		float f3 = 6;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-5F, -4F, -9F + f3, 10, 11, 9);
		head.setRotationPoint(0F, -4F + f2, -11F + f1);
		setRotation(head, 0.7853982F, 0F, 0F);

		ModelRenderer topjaw = new ModelRenderer(this, 38, 0);
		head.addChild(topjaw);
		topjaw.addBox(-6F, 0F, -12F, 12, 6, 6);
		topjaw.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(topjaw, -0.7853982F + 0.2094395F, 0F, 0F);

		ModelRenderer topteeth = new ModelRenderer(this, 38, 12);
		head.addChild(topteeth);
		topteeth.addBox(-5F, 5F, -11F, 10, 3, 0);
		topteeth.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(topteeth, -0.7853982F + 0.2094395F, 0F, 0F);

		ModelRenderer leftmouth = new ModelRenderer(this, 120, 0);
		head.addChild(leftmouth);
		leftmouth.addBox(4.9F, -2F, -11F, 1, 8, 3);
		leftmouth.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(leftmouth, -0.7853982F + 0.7853982F, 0F, 0F);

		ModelRenderer rightmouth = new ModelRenderer(this, 120, 0);
		head.addChild(rightmouth);
		rightmouth.mirror = true;
		rightmouth.addBox(-5.9F, -2F, -11F, 1, 8, 3);
		rightmouth.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(rightmouth, -0.7853982F + 0.7853982F, 0F, 0F);
		rightmouth.mirror = false;

		ModelRenderer bottomjaw = new ModelRenderer(this, 74, 0);
		head.addChild(bottomjaw);
		bottomjaw.addBox(-6F, 8F, -13F, 12, 4, 12);
		bottomjaw.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(bottomjaw, -0.7853982F + 0.4537856F, 0F, 0F);

		ModelRenderer bottomteeth = new ModelRenderer(this, 38, 15);
		bottomjaw.addChild(bottomteeth);
		bottomteeth.addBox(-5F, 5F, -12F, 10, 4, 0);
		bottomteeth.setRotationPoint(0F, 0F, 0F);
		setRotation(bottomteeth, -0.4537856F + 0.4537856F, 0F, 0F);

		ModelRenderer lefthorn01 = new ModelRenderer(this, 110, 17);
		head.addChild(lefthorn01);
		lefthorn01.addBox(5F, -2F, -7F, 4, 4, 3);
		lefthorn01.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(lefthorn01, -0.7853982F + 0.4537856F, 0F, 0F);

		ModelRenderer lefthorn02 = new ModelRenderer(this, 110, 17);
		head.addChild(lefthorn02);
		lefthorn02.addBox(-1F, -2F, -15F, 3, 2, 6);
		lefthorn02.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(lefthorn02, (float) Math.toRadians(-8), (float) Math.toRadians(-49), (float) Math.toRadians(3));

		ModelRenderer lefthorn03 = new ModelRenderer(this, 110, 17);
		head.addChild(lefthorn03);
		lefthorn03.addBox(13F, -3F, -9F, 2, 2, 7);
		lefthorn03.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(lefthorn03, (float) Math.toRadians(-4), (float) Math.toRadians(30), (float) Math.toRadians(-3));

		ModelRenderer righthorn01 = new ModelRenderer(this, 110, 17);
		head.addChild(righthorn01);
		righthorn01.mirror = true;
		righthorn01.addBox(-9F, -2F, -7F, 4, 4, 3);
		righthorn01.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(righthorn01, -0.7853982F + 0.4537856F, 0F, 0F);
		righthorn01.mirror = false;

		ModelRenderer righthorn02 = new ModelRenderer(this, 110, 17);
		head.addChild(righthorn02);
		righthorn02.mirror = true;
		righthorn02.addBox(-2F, -2F, -15F, 3, 2, 6);
		righthorn02.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(righthorn02, (float) Math.toRadians(-8), (float) Math.toRadians(49), (float) Math.toRadians(-3));
		righthorn02.mirror = false;

		ModelRenderer righthorn03 = new ModelRenderer(this, 110, 17);
		head.addChild(righthorn03);
		righthorn03.mirror = true;
		righthorn03.addBox(-15F, -3F, -9F, 2, 2, 7);
		righthorn03.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(righthorn03, (float) Math.toRadians(-4), (float) Math.toRadians(-30), (float) Math.toRadians(3));
		righthorn03.mirror = false;

		hideOverlay();
	}

	private void setBehemoth() {
		textureWidth = 128;
		textureHeight = 128;

		float f1 = 22;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -10F + f1, -4F, 8, 10, 8);
		head.setRotationPoint(0F, -21F, 0F);
		head.setTextureSize(128, 128);
		setRotation(head, 0F, 0F, 0F);

		ModelRenderer mouth = new ModelRenderer(this, 32, 0);
		head.addChild(mouth);
		mouth.addBox(-2F, -2F, -4.5F, 4, 3, 2);
		mouth.setRotationPoint(0F, 0F + f1, 0F);
		mouth.setTextureSize(128, 128);
		setRotation(mouth, 0.2094395F, 0F, 0F);

		ModelRenderer lefthorn01 = new ModelRenderer(this, 32, 5);
		head.addChild(lefthorn01);
		lefthorn01.addBox(3F, -5F, -0.5F, 5, 5, 6);
		lefthorn01.setRotationPoint(0F, 0F + f1, 0F);
		lefthorn01.setTextureSize(128, 128);
		setRotation(lefthorn01, 0.1745329F, 0.3141593F, -0.4363323F);

		ModelRenderer lefthorn02 = new ModelRenderer(this, 50, 0);
		head.addChild(lefthorn02);
		lefthorn02.addBox(-3F, -10F, 6F, 3, 7, 4);
		lefthorn02.setRotationPoint(0F, 0F + f1, 0F);
		lefthorn02.setTextureSize(128, 128);
		setRotation(lefthorn02, 1.204277F, -0.1396263F, 1.012291F);

		ModelRenderer lefthorn03 = new ModelRenderer(this, 53, 0);
		head.addChild(lefthorn03);
		lefthorn03.addBox(3.5F, -7.5F, 11F, 2, 7, 2);
		lefthorn03.setRotationPoint(0F, 0F + f1, 0F);
		lefthorn03.setTextureSize(128, 128);
		setRotation(lefthorn03, 1.989675F, 0F, 0.5235988F);

		ModelRenderer righthorn01 = new ModelRenderer(this, 32, 5);
		head.addChild(righthorn01);
		righthorn01.mirror = true;
		righthorn01.addBox(-8F, -5F, -0.5F, 5, 5, 6);
		righthorn01.setRotationPoint(0F, 0F + f1, 0F);
		righthorn01.setTextureSize(128, 128);
		setRotation(righthorn01, 0.1745329F, -0.3141593F, 0.4363323F);
		righthorn01.mirror = false;

		ModelRenderer righthorn02 = new ModelRenderer(this, 50, 0);
		head.addChild(righthorn02);
		righthorn02.mirror = true;
		righthorn02.addBox(0F, -10F, 6F, 3, 7, 4);
		righthorn02.setRotationPoint(0F, 0F + f1, 0F);
		righthorn02.setTextureSize(128, 128);
		setRotation(righthorn02, 1.204277F, 0.1396263F, -1.012291F);
		righthorn02.mirror = false;

		ModelRenderer righthorn03 = new ModelRenderer(this, 53, 0);
		head.addChild(righthorn03);
		righthorn03.mirror = true;
		righthorn03.addBox(-5.5F, -7.5F, 11F, 2, 7, 2);
		righthorn03.setRotationPoint(0F, 0F + f1, 0F);
		righthorn03.setTextureSize(128, 128);
		setRotation(righthorn03, 1.989675F, 0F, -0.5235988F);
		righthorn03.mirror = false;

		hideOverlay();
	}

	private void setBelph() {
		textureWidth = 64;
		textureHeight = 32;

		float f1 = -4;
		float f2 = 3;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F + f1, -5F + f2, 6, 10, 6);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);

		hideOverlay();
	}

	private void setEldrichGuardian() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 40, 12);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
		setRotation(head, 0.0F, 0.0F, 0.0F);
		ModelRenderer hood1 = new ModelRenderer(this, 36, 28);
		hood1.addBox(-3.5F, -8.7F, 2.0F, 7, 7, 3);
		setRotation(hood1, -0.2268928F, 0.0F, 0.0F);
		ModelRenderer hood2 = new ModelRenderer(this, 22, 19);
		hood2.addBox(-3.0F, -9.0F, 2.5F, 6, 6, 3);
		setRotation(hood2, -0.3490659F, 0.0F, 0.0F);
		ModelRenderer hood3 = new ModelRenderer(this, 40, 4);
		hood3.addBox(-2.5F, -9.7F, 3.5F, 5, 5, 3);
		setRotation(hood3, -0.5759587F, 0.0F, 0.0F);

		head.addChild(hood1);
		head.addChild(hood2);
		head.addChild(hood3);

		hideOverlay();
	}

	private void setPech() {
		textureWidth = 128;
		textureHeight = 64;
		float f1 = -2.0F;
		float f2 = 4.0F;
		head = new ModelRenderer(this, 2, 11);
		head.addBox(-3.5F, -5.0F + f1, -5.0F + f2, 7, 5, 5);
		overlay = new ModelRenderer(this, 1, 21);
		overlay.addBox(-4.0F, -1.0F + f1, -6.0F + f2, 8, 3, 5);
	}

	private void setImp() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-5F, -8F, -4F, 10, 8, 8, 0.0F);
		hideOverlay();
	}

	private void setSilverfish() {
		float f = -1.9F;
		float f1 = -24;
		head = new ModelRenderer(this, 0, 0);

		ModelRenderer[] silverfishBodyParts = new ModelRenderer[7];
		ModelRenderer[] silverfishWings;
		int[][] silverfishBoxLength = new int[][] { { 3, 2, 2 }, { 4, 3, 2 }, { 6, 4, 3 }, { 3, 3, 3 }, { 2, 2, 3 }, { 2, 1, 2 }, { 1, 1, 2 } };
		int[][] silverfishTexturePositions = new int[][] { { 0, 0 }, { 0, 4 }, { 0, 9 }, { 0, 16 }, { 0, 22 }, { 11, 0 }, { 13, 4 } };

		float[] field_78170_c = new float[7];

		for (int i = 0; i < silverfishBodyParts.length; ++i) {
			silverfishBodyParts[i] = new ModelRenderer(this, silverfishTexturePositions[i][0], silverfishTexturePositions[i][1]);
			silverfishBodyParts[i].addBox(silverfishBoxLength[i][0] * -0.5F, 0.0F + f1, silverfishBoxLength[i][2] * -0.5F, silverfishBoxLength[i][0], silverfishBoxLength[i][1], silverfishBoxLength[i][2]);
			silverfishBodyParts[i].setRotationPoint(0.0F, 24 - silverfishBoxLength[i][1], f);
			field_78170_c[i] = f;

			if (i < silverfishBodyParts.length - 1)
				f += (silverfishBoxLength[i][2] + silverfishBoxLength[i + 1][2]) * 0.5F;

			if (i < 3)
				head.addChild(silverfishBodyParts[i]);
		}

		silverfishWings = new ModelRenderer[2];
		silverfishWings[0] = new ModelRenderer(this, 20, 0);
		silverfishWings[0].addBox(-5.0F, 0.0F + f1, silverfishBoxLength[2][2] * -0.5F, 10, 8, silverfishBoxLength[2][2]);
		silverfishWings[0].setRotationPoint(0.0F, 16.0F, field_78170_c[2]);
		silverfishWings[1] = new ModelRenderer(this, 20, 18);
		silverfishWings[1].addBox(-3.0F, 0.0F + f1, silverfishBoxLength[4][2] * -0.5F, 6, 5, silverfishBoxLength[1][2]);
		silverfishWings[1].setRotationPoint(0.0F, 19.0F, field_78170_c[1]);

		head.addChild(silverfishWings[0]);
		head.addChild(silverfishWings[1]);
		hideOverlay();
	}

	private void setSnowman() {
		textureWidth = 64;
		textureHeight = 64;
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		hideOverlay();
	}

	private void setHorse(boolean isMule) {
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this, 0, 0);

		float f1 = -2;
		float f2 = -4;
		ModelRenderer head2 = new ModelRenderer(this, 0, 0);
		head2.addBox(-2.5F, -10.0F + f2, -1.5F + f1, 5, 5, 7);
		ModelRenderer mouthTop = new ModelRenderer(this, 24, 18);
		mouthTop.addBox(-2.0F, -10.0F + f2, -7.0F + f1, 4, 3, 6);
		ModelRenderer mouthBottom = new ModelRenderer(this, 24, 27);
		mouthBottom.addBox(-2.0F, -7.0F + f2, -6.5F + f1, 4, 2, 5);
		ModelRenderer neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-2.05F, -9.8F + f2, -2.0F + f1, 4, 14, 8);
		ModelRenderer mane = new ModelRenderer(this, 58, 0);
		mane.addBox(-1.0F, -11.5F + f2, 5.0F + f1, 2, 16, 4);

		if (isMule) {
			ModelRenderer muleLeftEar = new ModelRenderer(this, 0, 12);
			muleLeftEar.addBox(-2.0F, -16.0F + f2, 4.0F + f1, 2, 7, 1);
			ModelRenderer muleRightEar = new ModelRenderer(this, 0, 12);
			muleRightEar.addBox(0.0F, -16.0F + f2, 4.0F + f1, 2, 7, 1);
			setRotation(muleLeftEar, 0, 0, -0.06F);
			setRotation(muleRightEar, 0, 0, 0.06F);

			head.addChild(muleRightEar);
			head.addChild(muleLeftEar);
		} else {
			ModelRenderer horseLeftEar = new ModelRenderer(this, 0, 0);
			horseLeftEar.addBox(0.45F, -12.0F + f2, 4.0F + f1, 2, 3, 1);
			ModelRenderer horseRightEar = new ModelRenderer(this, 0, 0);
			horseRightEar.addBox(-2.45F, -12.0F + f2, 4.0F + f1, 2, 3, 1);

			head.addChild(horseRightEar);
			head.addChild(horseLeftEar);
		}

		head.addChild(head2);
		head.addChild(neck);
		head.addChild(mane);
		head.addChild(mouthTop);
		head.addChild(mouthBottom);

		hideOverlay();
	}

	private void setMagmaCube() {
		hideOverlay();

		head = new ModelRenderer(this, 0, 16);
		head.addBox(-2.0F, 18.0F - 24, -2.0F, 4, 4, 4);

		for (int i = 0; i < 8; i++) {
			byte x = 0;
			int y = i;

			if (i == 2) {
				x = 24;
				y = 10;
			} else if (i == 3) {
				x = 24;
				y = 19;
			}

			ModelRenderer segment = new ModelRenderer(this, x, y);
			segment.addBox(-4.0F, 16 + i - 24, -4.0F, 8, 1, 8);
			head.addChild(segment);
		}
	}

	private void setSlime() {
		float f1 = -24;
		head = new ModelRenderer(this, 0, 16);
		head.addBox(-3.0F, 17.0F + f1, -3.0F, 6, 6, 6);
		ModelRenderer slimeRightEye = new ModelRenderer(this, 32, 0);
		slimeRightEye.addBox(-3.25F, 18.0F + f1, -3.5F, 2, 2, 2);
		ModelRenderer slimeLeftEye = new ModelRenderer(this, 32, 4);
		slimeLeftEye.addBox(1.25F, 18.0F + f1, -3.5F, 2, 2, 2);
		ModelRenderer slimeMouth = new ModelRenderer(this, 32, 8);
		slimeMouth.addBox(0.0F, 21.0F + f1, -3.5F, 1, 1, 1);

		head.addChild(slimeMouth);
		head.addChild(slimeRightEye);
		head.addChild(slimeLeftEye);

		overlay = new ModelRenderer(this, 0, 0);
		overlay.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
	}

	private void setBat() {
		textureWidth = 64;
		textureHeight = 64;
		hideOverlay();
		float f1 = -3;
		float f2 = 5;
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -3.0F + f1, -3.0F + f2, 6, 6, 6);
		ModelRenderer ear1 = new ModelRenderer(this, 24, 0);
		ear1.addBox(-4.0F, -6.0F + f1, -2.0F + f2, 3, 4, 1);
		head.addChild(ear1);
		ModelRenderer ear2 = new ModelRenderer(this, 24, 0);
		ear2.mirror = true;
		ear2.addBox(1.0F, -6.0F + f1, -2.0F + f2, 3, 4, 1);
		head.addChild(ear2);
	}

	private void setOcelot() {
		setTextureOffset("head.main", 0, 0);
		setTextureOffset("head.nose", 0, 24);
		setTextureOffset("head.ear1", 0, 10);
		setTextureOffset("head.ear2", 6, 10);
		hideOverlay();
		head = new ModelRenderer(this, "head");
		float f1 = -2;
		float f2 = 2;
		head.addBox("main", -2.5F, -2.0F + f1, -3.0F + f2, 5, 4, 5);
		head.addBox("nose", -1.5F, 0.0F + f1, -4.0F + f2, 3, 2, 2);
		head.addBox("ear1", -2.0F, -3.0F + f1, 0.0F + f2, 1, 1, 2);
		head.addBox("ear2", 1.0F, -3.0F + f1, 0.0F + f2, 1, 1, 2);
	}

	private void setSquirrel() {
		textureWidth = 32;
		textureHeight = 32;
		hideOverlay();
		setTextureOffset("head.head", 0, 0);
		setTextureOffset("head.ear2", 16, 0);
		setTextureOffset("head.ear1", 16, 0);

		head = new ModelRenderer(this, "head");
		head.setRotationPoint(0.0f, 0.0f, 0.0f);
		setRotation(head, 0.0f, 0.0f, 0.0f);
		float f = 3;
		float f2 = 1;
		head.addBox("head", -2.0f, -5.0f + f2, -3.0f + f, 4, 4, 4);
		head.addBox("ear2", -2.0f, -6.0f + f2, -0.5f + f, 1, 1, 1);
		head.addBox("ear1", 1.0f, -6.0f + f2, -0.5f + f, 1, 1, 1);
	}

	private void setTowerGolem() {
		textureWidth = 128;
		textureHeight = 64;
		hideOverlay();
		head = new ModelRenderer(this, 0, 0);
		head.setRotationPoint(0.0f, 0.0f, 0.0f);
		float f = 2;
		head.setTextureOffset(0, 0).addBox(-3.5f, -10.0f + f, -3.0f + f, 7, 8, 6);
		head.setTextureOffset(0, 14).addBox(-4.0f, -6.0f + f, -3.5f + f, 8, 4, 6);
	}

	private void setPinchBeetle() {
		hideOverlay();
		float f = 4;
		float f2 = -2;
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0f, -4.0f + f2, -6.0f + f, 8, 6, 6);
		head.setRotationPoint(0.0f, 0.0f, 0.0f);
		ModelRenderer jaw1a = new ModelRenderer(this, 40, 6);
		jaw1a.addBox(-1.0f, -1.0f, -1.5f, 8, 2, 3);
		jaw1a.setRotationPoint(-3.0f, 1.0f + f2, -6.0f + f);
		setRotation(jaw1a, 0.0f, 2.635447f, 0.0f);
		ModelRenderer jaw1b = new ModelRenderer(this, 40, 10);
		jaw1b.addBox(-1.0f, -1.0f, -1.0f, 10, 2, 2);
		jaw1b.setRotationPoint(7.0f, 0.0f, 0.0f);
		setRotation(jaw1b, 0.0f, -1.047197f, 0.0f);
		ModelRenderer jaw2a = new ModelRenderer(this, 40, 6);
		jaw2a.addBox(-1.0f, -1.0f, -1.5f, 8, 2, 3);
		jaw2a.setRotationPoint(3.0f, 1.0f + f2, -6.0f + f);
		setRotation(jaw2a, 0.0f, 0.541052f, 0.0f);
		ModelRenderer jaw2b = new ModelRenderer(this, 40, 10);
		jaw2b.addBox(-1.0f, -1.0f, -1.0f, 10, 2, 2);
		jaw2b.setRotationPoint(7.0f, 0.0f, 0.0f);
		setRotation(jaw2b, 0.0f, 1.047197f, 0.0f);
		ModelRenderer antenna1 = new ModelRenderer(this, 42, 4);
		antenna1.addBox(0.0f, -0.5f, -0.5f, 10, 1, 1);
		antenna1.setRotationPoint(1.0f, -3.0f + f2, -5.0f + f);
		setRotation(antenna1, 0.0f, 1.047198f, -0.296706f);
		ModelRenderer antenna2 = new ModelRenderer(this, 42, 4);
		antenna2.addBox(0.0f, -0.5f, -0.5f, 10, 1, 1);
		antenna2.setRotationPoint(-1.0f, -3.0f + f2, -5.0f + f);
		setRotation(antenna2, 0.0f, 2.094395f, 0.296706f);
		ModelRenderer eye1 = new ModelRenderer(this, 15, 12);
		eye1.addBox(-1.5f, -1.5f, -1.5f, 3, 3, 3);
		eye1.setRotationPoint(-3.0f, -2.0f + f2, -5.0f + f);
		ModelRenderer eye2 = new ModelRenderer(this, 15, 12);
		eye2.addBox(-1.5f, -1.5f, -1.5f, 3, 3, 3);
		eye2.setRotationPoint(3.0f, -2.0f + f2, -5.0f + f);
		ModelRenderer tooth1a = new ModelRenderer(this, 0, 0);
		tooth1a.addBox(0.0f, -0.5f, -0.0f, 2, 1, 1);
		tooth1a.setRotationPoint(9.0f, 0.0f, 0.0f);
		setRotation(tooth1a, 0.0f, -0.5235987f, 0.0f);
		ModelRenderer tooth1b = new ModelRenderer(this, 0, 0);
		tooth1b.addBox(-2.5f, -0.5f, -0.0f, 2, 1, 1);
		tooth1b.setRotationPoint(6.0f, 0.0f, 0.0f);
		setRotation(tooth1b, 0.0f, 1.5707963f, 0.0f);
		ModelRenderer tooth1c = new ModelRenderer(this, 0, 0);
		tooth1c.addBox(-2.5f, -0.5f, -0.0f, 2, 1, 1);
		tooth1c.setRotationPoint(3.0f, 0.0f, 0.0f);
		setRotation(tooth1c, 0.0f, 1.5707963f, 0.0f);
		ModelRenderer tooth2a = new ModelRenderer(this, 0, 0);
		tooth2a.addBox(0.0f, -0.5f, -1.0f, 2, 1, 1);
		tooth2a.setRotationPoint(9.0f, 0.0f, 0.0f);
		setRotation(tooth2a, 0.0f, 0.5235987f, 0.0f);
		ModelRenderer tooth2b = new ModelRenderer(this, 0, 0);
		tooth2b.addBox(-2.5f, -0.5f, -1.0f, 2, 1, 1);
		tooth2b.setRotationPoint(6.0f, 0.0f, 0.0f);
		setRotation(tooth2b, 0.0f, -1.5707963f, 0.0f);
		ModelRenderer tooth2c = new ModelRenderer(this, 0, 0);
		tooth2c.addBox(-2.5f, -0.5f, -1.0f, 2, 1, 1);
		tooth2c.setRotationPoint(3.0f, 0.0f, 0.0f);
		setRotation(tooth2c, 0.0f, -1.5707963f, 0.0f);
		head.addChild(jaw1a);
		jaw1a.addChild(jaw1b);
		jaw1b.addChild(tooth1a);
		jaw1b.addChild(tooth1b);
		jaw1b.addChild(tooth1c);
		jaw2b.addChild(tooth2a);
		jaw2b.addChild(tooth2b);
		jaw2b.addChild(tooth2c);
		head.addChild(jaw2a);
		jaw2a.addChild(jaw2b);
		head.addChild(antenna1);
		head.addChild(antenna2);
		head.addChild(eye1);
		head.addChild(eye2);
	}

	private void setFireBeetle() {
		hideOverlay();
		float f = 4;
		float f2 = -2;
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0f, -4.0f + f2, -6.0f + f, 8, 6, 6);
		head.setRotationPoint(0.0f, 0.0f, 0.0f);
		ModelRenderer jaw1a = new ModelRenderer(this, 0, 0);
		jaw1a.addBox(0.0f, 0.0f, -2.0f, 1, 1, 2);
		jaw1a.setRotationPoint(-3.0f, 0.0f + f2, -6.0f + f);
		setRotation(jaw1a, 0.3490659f, 0.0f, 0.0f);
		ModelRenderer jaw1b = new ModelRenderer(this, 0, 0);
		jaw1b.addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
		jaw1b.setRotationPoint(0.0f, 0.0f + f2, -2.0f + f);
		setRotation(jaw1b, 0.0f, 1.570796f, 0.0f);
		ModelRenderer jaw2a = new ModelRenderer(this, 0, 0);
		jaw2a.addBox(-1.0f, 0.0f, -2.0f, 1, 1, 2);
		jaw2a.setRotationPoint(3.0f, 0.0f + f2, -6.0f + f);
		setRotation(jaw2a, 0.3490659f, 0.0f, 0.0f);
		ModelRenderer jaw2b = new ModelRenderer(this, 0, 0);
		jaw2b.addBox(0.0f, 0.0f, -2.0f, 1, 1, 2);
		jaw2b.setRotationPoint(0.0f, 0.0f + f2, -2.0f + f);
		setRotation(jaw2b, 0.0f, 1.570796f, 0.0f);
		ModelRenderer antenna1 = new ModelRenderer(this, 42, 4);
		antenna1.addBox(0.0f, -0.5f, -0.5f, 10, 1, 1);
		antenna1.setRotationPoint(1.0f, -3.0f + f2, -5.0f + f);
		setRotation(antenna1, 0.0f, 1.047198f, -0.296706f);
		ModelRenderer antenna2 = new ModelRenderer(this, 42, 4);
		antenna2.addBox(0.0f, -0.5f, -0.5f, 10, 1, 1);
		antenna2.setRotationPoint(-1.0f, -3.0f + f2, -5.0f + f);
		setRotation(antenna2, 0.0f, 2.094395f, 0.296706f);
		ModelRenderer eye1 = new ModelRenderer(this, 15, 12);
		eye1.addBox(-1.5f, -1.5f, -1.5f, 3, 3, 3);
		eye1.setRotationPoint(-3.0f, -2.0f + f2, -5.0f + f);
		ModelRenderer eye2 = new ModelRenderer(this, 15, 12);
		eye2.addBox(-1.5f, -1.5f, -1.5f, 3, 3, 3);
		eye2.setRotationPoint(3.0f, -2.0f + f2, -5.0f + f);
		head.addChild(jaw1a);
		jaw1a.addChild(jaw1b);
		head.addChild(jaw2a);
		jaw2a.addChild(jaw2b);
		head.addChild(antenna1);
		head.addChild(antenna2);
		head.addChild(eye1);
		head.addChild(eye2);
	}

	private void setSlimeBeetle() {
		textureHeight = 64;

		hideOverlay();
		float f = 4;
		float f2 = -2;
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0f, -4.0f + f2, -6.0f + f, 8, 6, 6);
		head.setRotationPoint(0.0f, 0.0f, 0.0f);
		ModelRenderer antenna1 = new ModelRenderer(this, 38, 4);
		antenna1.addBox(0.0f, -0.5f, -0.5f, 12, 1, 1);
		antenna1.setRotationPoint(1.0f, -3.0f + f2, -5.0f + f);
		antenna1.rotateAngleX = 0.0f;
		antenna1.rotateAngleY = 1.047198f;
		antenna1.rotateAngleZ = -0.296706f;
		ModelRenderer antenna2 = new ModelRenderer(this, 38, 4);
		antenna2.addBox(0.0f, -0.5f, -0.5f, 12, 1, 1);
		antenna2.setRotationPoint(-1.0f, -3.0f + f2, -5.0f + f);
		antenna2.rotateAngleX = 0.0f;
		antenna2.rotateAngleY = 2.094395f;
		antenna2.rotateAngleZ = 0.296706f;
		ModelRenderer eye1 = new ModelRenderer(this, 15, 12);
		eye1.addBox(-1.5f, -1.5f, -1.5f, 3, 3, 3);
		eye1.setRotationPoint(-3.0f, -2.0f + f2, -5.0f + f);
		ModelRenderer eye2 = new ModelRenderer(this, 15, 12);
		eye2.addBox(-1.5f, -1.5f, -1.5f, 3, 3, 3);
		eye2.setRotationPoint(3.0f, -2.0f + f2, -5.0f + f);
		ModelRenderer mouth = new ModelRenderer(this, 17, 12);
		mouth.addBox(-1.0f, -1.0f, -1.0f, 2, 2, 1);
		mouth.setRotationPoint(0.0f, 1.0f + f2, -6.0f + f);
		head.addChild(antenna1);
		head.addChild(antenna2);
		head.addChild(eye1);
		head.addChild(eye2);
		head.addChild(mouth);
	}

	private void setPig() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		head.setTextureOffset(16, 16).addBox(-2.0F, -4.0F, -5.0F, 4, 3, 1, 0.0F);
		hideOverlay();
	}

	private void setCow() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -8.0F, -2.0F, 8, 8, 6, 0.0F);
		head.setTextureOffset(22, 0).addBox(-5.0F, -9.0F, 0.0F, 1, 3, 1, 0.0F);
		head.setTextureOffset(22, 0).addBox(4.0F, -9.0F, 0.0F, 1, 3, 1, 0.0F);
		hideOverlay();
	}

	private void setSpider() {
		head = new ModelRenderer(this, 32, 4);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		hideOverlay();
	}

	private void setSheep() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -7.0F, -4.5F, 6, 6, 8, 0.0F);
		overlay = new ModelRenderer(this, 0, 0);
		overlay.addBox(-3.0F, -7.0F, -2.5F, 6, 6, 6, 0.6F);
		hideOverlay();
	}

	private void setWolf() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, 0.0F, 6, 6, 4, 0.0F);

		head.setTextureOffset(16, 14).addBox(-3.0F, -8.0F, 2.0F, 2, 2, 1, 0.0F);
		head.setTextureOffset(16, 14).addBox(1.0F, -8.0F, 2.0F, 2, 2, 1, 0.0F);
		head.setTextureOffset(0, 10).addBox(-1.5F, -3.0F, -3.0F, 3, 3, 4, 0.0F);
		hideOverlay();
	}

	private void setEnderman() {
		ModelEnderman model = new ModelEnderman();
		head = model.bipedHead;
		overlay = model.bipedHeadwear;
		head.setRotationPoint(0F, 0F, 0F);
		overlay.setRotationPoint(0F, 0F, 0F);
	}

	private void setVillager(int textureSize) {
		head = new ModelRenderer(this).setTextureSize(textureSize, textureSize);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
		overlay = new ModelRenderer(this).setTextureSize(textureSize, textureSize);
		overlay.setRotationPoint(0.0F, -2.0F, 0.0F);
		overlay.setTextureOffset(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
	}

	private void setChicken() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-2.0F, -6.0F, 1.0F, 4, 6, 3, 0.0F);
		overlay = new ModelRenderer(this, 14, 0);
		overlay.addBox(-2.0F, -4.0F, -1.0F, 4, 2, 2, 0.0F);
		ModelRenderer overlay2 = new ModelRenderer(this, 14, 4);
		overlay2.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 2, 0.0F);
		overlay.addChild(overlay2);
	}

	private void setWitch() {
		head = new ModelRenderer(this).setTextureSize(64, 128);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);

		overlay = new ModelRenderer(this).setTextureSize(64, 128);
		overlay.setRotationPoint(0.0F, -2.0F, 0.0F);
		overlay.setTextureOffset(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);

		ModelRenderer wart = new ModelRenderer(this).setTextureSize(64, 128);
		wart.setRotationPoint(0.0F, -2.0F, 0.0F);
		wart.setTextureOffset(0, 0).addBox(0.0F, 3.0F, -6.75F, 1, 1, 1, -0.25F);
		overlay.addChild(wart);

		ModelRenderer hatBase = new ModelRenderer(this).setTextureSize(64, 128);
		hatBase.setRotationPoint(-5.0F, -10.03125F, -5.0F);
		hatBase.setTextureOffset(0, 64).addBox(0.0F, 0.0F, 0.0F, 10, 2, 10);
		hatBase.rotateAngleX = head.rotateAngleX;
		hatBase.rotateAngleY = head.rotateAngleY;
		head.addChild(hatBase);

		ModelRenderer hat1 = new ModelRenderer(this).setTextureSize(64, 128);
		hat1.setRotationPoint(1.75F, -4.0F, 2.0F);
		hat1.setTextureOffset(0, 76).addBox(0.0F, 0.0F, 0.0F, 7, 4, 7);
		hat1.rotateAngleX = -0.05235988F;
		hat1.rotateAngleZ = 0.02617994F;
		hatBase.addChild(hat1);

		ModelRenderer hat2 = new ModelRenderer(this).setTextureSize(64, 128);
		hat2.setRotationPoint(1.75F, -4.0F, 2.0F);
		hat2.setTextureOffset(0, 87).addBox(0.0F, 0.0F, 0.0F, 4, 4, 4);
		hat2.rotateAngleX = -0.10471976F;
		hat2.rotateAngleZ = 0.05235988F;
		hat1.addChild(hat2);

		ModelRenderer hat3 = new ModelRenderer(this).setTextureSize(64, 128);
		hat3.setRotationPoint(1.75F, -2.0F, 2.0F);
		hat3.setTextureOffset(0, 95).addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.25F);
		hat3.rotateAngleX = -0.20943952F;
		hat3.rotateAngleZ = 0.10471976F;
		hat2.addChild(hat3);
	}

	private void setZombieVillager() {
		head = new ModelRenderer(this).setTextureSize(64, 64);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 32).addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
		overlay = new ModelRenderer(this).setTextureSize(64, 64);
		overlay.setRotationPoint(0.0F, -2.0F, 0.0F);
		overlay.setTextureOffset(24, 32).addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
	}

	private void setSquid() {
		head = new ModelRenderer(this).setTextureSize(64, 32);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addBox(-6.0F, -16F, -6.0F + 0.25F, 12, 16, 12);
		hideOverlay();
	}

	private void setBunny() {
		hideOverlay();

		setTextureOffset("head.head", 0, 0);
		setTextureOffset("head.ear2", 16, 0);
		setTextureOffset("head.ear1", 16, 0);

		head = new ModelRenderer(this, "head").setTextureSize(32, 32);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.rotateAngleX = 0.0F;
		head.rotateAngleY = 0.0F;
		head.rotateAngleZ = 0.0F;
		head.mirror = true;
		head.addBox("head", -2.0F, -4.0F, 0.0F, 4, 4, 4);
		head.addBox("ear2", -2.5F, -8.0F, 2.5F, 2, 4, 1);
		head.addBox("ear1", 0.5F, -8.0F, 2.5F, 2, 4, 1);
	}

	private void setPenguin() {
		head = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
		head.addBox(-3.5F, -5.0F, -3.5F, 7, 5, 7);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);

		overlay = new ModelRenderer(this, 0, 13);
		overlay.addBox(-1.0F, -2.0F, -5.0F, 2, 1, 2);
		overlay.setRotationPoint(0.0F, 0.0F, 0.0F);
	}

	private void setBighorn() {
		setSheep();
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -7.0F, -4.5F, 6, 6, 7, 0.0F);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);

		head.setTextureOffset(28, 16).addBox(-5.0F, -7.0F, -1.0F, 2, 2, 2, 0.0F);
		head.setTextureOffset(16, 13).addBox(-6.0F, -8.0F, 0.0F, 2, 2, 4, 0.0F);
		head.setTextureOffset(16, 19).addBox(-7.0F, -7.0F, 3.0F, 2, 5, 2, 0.0F);
		head.setTextureOffset(18, 27).addBox(-8.0F, -3.0F, 1.0F, 2, 2, 3, 0.0F);
		head.setTextureOffset(28, 27).addBox(-9.0F, -4.0F, 0.0F, 2, 2, 1, 0.0F);

		head.setTextureOffset(28, 16).addBox(3.0F, -7.0F, -1.0F, 2, 2, 2, 0.0F);
		head.setTextureOffset(16, 13).addBox(4.0F, -8.0F, 0.0F, 2, 2, 4, 0.0F);
		head.setTextureOffset(16, 19).addBox(5.0F, -7.0F, 3.0F, 2, 5, 2, 0.0F);
		head.setTextureOffset(18, 27).addBox(6.0F, -3.0F, 1.0F, 2, 2, 3, 0.0F);
		head.setTextureOffset(28, 27).addBox(7.0F, -4.0F, 0.0F, 2, 2, 1, 0.0F);

		overlay = new ModelRenderer(this, 0, 0);
		overlay.addBox(-3.0F, -7.0F, -2.5F, 6, 6, 6, 0.6F);
		hideOverlay();
	}

	private void setDeer() {
		hideOverlay();

		head = new ModelRenderer(this, 0, 5);
		head.addBox(-2.0F, -8.0F, -2.0F, 4, 6, 6, 0.0F);
		head.setRotationPoint(0.0F, 2.0F, 0.0F);

		head.setTextureOffset(52, 0).addBox(-1.5F, -5.0F, -5.0F, 3, 3, 3, 0.0F);

		head.setTextureOffset(20, 0);
		head.addBox(-3.0F, -10.0F, 2.0F, 2, 2, 2, 0.0F);
		head.addBox(-3.0F, -10.0F, 2.0F, 2, 2, 2, 0.0F);
		head.addBox(-4.0F, -10.0F, 3.0F, 1, 1, 3, 0.0F);
		head.addBox(-5.0F, -11.0F, 5.0F, 1, 1, 5, 0.0F);
		head.addBox(-5.0F, -14.0F, 7.0F, 1, 4, 1, 0.0F);
		head.addBox(-6.0F, -17.0F, 6.0F, 1, 4, 1, 0.0F);
		head.addBox(-6.0F, -13.0F, 4.0F, 1, 1, 3, 0.0F);
		head.addBox(-6.0F, -14.0F, 1.0F, 1, 1, 4, 0.0F);
		head.addBox(-7.0F, -15.0F, -2.0F, 1, 1, 4, 0.0F);
		head.addBox(-6.0F, -16.0F, -5.0F, 1, 1, 4, 0.0F);
		head.addBox(-7.0F, -18.0F, 3.0F, 1, 5, 1, 0.0F);
		head.addBox(-6.0F, -19.0F, -2.0F, 1, 5, 1, 0.0F);

		head.addBox(1.0F, -10.0F, 2.0F, 2, 2, 2, 0.0F);
		head.addBox(3.0F, -10.0F, 3.0F, 1, 1, 3, 0.0F);
		head.addBox(4.0F, -11.0F, 5.0F, 1, 1, 5, 0.0F);
		head.addBox(4.0F, -14.0F, 6.0F, 1, 4, 1, 0.0F);
		head.addBox(5.0F, -17.0F, 7.0F, 1, 4, 1, 0.0F);
		head.addBox(5.0F, -13.0F, 4.0F, 1, 1, 3, 0.0F);
		head.addBox(5.0F, -14.0F, 1.0F, 1, 1, 4, 0.0F);
		head.addBox(6.0F, -15.0F, -2.0F, 1, 1, 4, 0.0F);
		head.addBox(5.0F, -16.0F, -5.0F, 1, 1, 4, 0.0F);
		head.addBox(6.0F, -18.0F, 3.0F, 1, 5, 1, 0.0F);
		head.addBox(5.0F, -19.0F, -2.0F, 1, 5, 1, 0.0F);
	}

	private void setBoar() {
		hideOverlay();

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -2.0F, -2.0F, 8, 7, 6, 0.0F);
		head.setRotationPoint(0.0F, -5.0F, 0.0F);

		head.setTextureOffset(28, 0).addBox(-3.0F, 1.0F, -5.0F, 6, 4, 3, 0.0F);

		head.setTextureOffset(17, 17).addBox(3.0F, 2.0F, -5.0F, 1, 2, 1, 0.0F);
		head.setTextureOffset(17, 17).addBox(-4.0F, 2.0F, -5.0F, 1, 2, 1, 0.0F);
	}

	private void setRedcap() {
		head = new ModelRenderer(this, 0, 0);
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.4F, -7.0F, -4.0F, 7, 7, 7, 0.0F);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);

		overlay = new ModelRenderer(this, 32, 0);
		overlay.addBox(-2.0F, -8.0F, -3.0F, 4, 5, 7, 0.0F);
		overlay.setRotationPoint(0.0F, 0.0F, 0.0F);

		ModelRenderer goblinRightEar = new ModelRenderer(this, 48, 20);
		goblinRightEar.addBox(3.0F, -7.0F, -1.0F, 2, 3, 1, 0.0F);
		goblinRightEar.setRotationPoint(0.0F, 0.0F, 0.0F);

		ModelRenderer goblinLeftEar = new ModelRenderer(this, 48, 24);
		goblinLeftEar.addBox(-5.0F, -7.0F, -1.0F, 2, 3, 1, 0.0F);
		goblinLeftEar.setRotationPoint(0.0F, 0.0F, 0.0F);

		head.addChild(goblinLeftEar);
		head.addChild(goblinRightEar);
	}

	private void setGhast() {
		hideOverlay();
		textureWidth = 32;
		textureHeight = 16;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
	}

	private void setEnderDragon() {
		float f1 = -14.0F;
		float f2 = -8.0F;
		textureWidth = 256;
		textureHeight = 256;

		setTextureOffset("head.upperhead", 112, 30);
		setTextureOffset("head.upperlip", 176, 44);
		setTextureOffset("head.scale", 0, 0);
		setTextureOffset("head.nostril", 112, 0);
		setTextureOffset("jaw.jaw", 176, 65);

		head = new ModelRenderer(this, "head");
		head.addBox("upperlip", -6.0F, -1.0F + f2, -8.0F + f1, 12, 5, 16);
		head.addBox("upperhead", -8.0F, -8.0F + f2, 6.0F + f1, 16, 16, 16);
		head.mirror = true;
		head.addBox("scale", -5.0F, -12.0F + f2, 12.0F + f1, 2, 4, 6);
		head.addBox("nostril", -5.0F, -3.0F + f2, -6.0F + f1, 2, 2, 4);
		head.mirror = false;
		head.addBox("scale", 3.0F, -12.0F + f2, 12.0F + f1, 2, 4, 6);
		head.addBox("nostril", 3.0F, -3.0F + f2, -6.0F + f1, 2, 2, 4);
		overlay = new ModelRenderer(this, "jaw");
		overlay.setRotationPoint(0.0F, 4.0F + f2, 8.0F + f1);
		overlay.addBox("jaw", -6.0F, 0.0F, -16.0F, 12, 4, 16);
		overlay.rotateAngleX = 0.2F;
		head.addChild(overlay);
		hideOverlay();
	}

	private void setKobold() {
		float f = 1.0F;
		hideOverlay();
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.5f, -7.0f + f, -3.0f + f, 7, 6, 6);
		head.setRotationPoint(0.0f, 0.0f, 0.0f);
		ModelRenderer rightear = new ModelRenderer(this, 48, 20);
		rightear.addBox(0.0f, -4.0f, 0.0f, 4, 4, 1);
		rightear.setRotationPoint(3.5f, -3.0f + f, -1.0f + f);
		rightear.rotateAngleY = 0.2617994f;
		rightear.rotateAngleZ = -0.3490659f;
		head.addChild(rightear);
		ModelRenderer leftear = new ModelRenderer(this, 48, 25);
		leftear.addBox(-4.0f, -4.0f, 0.0f, 4, 4, 1);
		leftear.setRotationPoint(-3.5f, -3.0f + f, -1.0f + f);
		leftear.rotateAngleY = -0.2617994f;
		leftear.rotateAngleZ = 0.3490659f;
		head.addChild(leftear);
		ModelRenderer snout = new ModelRenderer(this, 28, 0);
		snout.addBox(-1.5f, -2.0f, -2.0f, 3, 2, 3);
		snout.setRotationPoint(0.0f, -2.0f + f, -3.0f + f);
		head.addChild(snout);
		ModelRenderer jaw = new ModelRenderer(this, 28, 5);
		jaw.addBox(-1.5f, 0.0f, -2.0f, 3, 1, 3);
		jaw.setRotationPoint(0.0f, -2.0f + f, -3.0f + f);
		jaw.rotateAngleX = 0.20944f;
		head.addChild(jaw);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}