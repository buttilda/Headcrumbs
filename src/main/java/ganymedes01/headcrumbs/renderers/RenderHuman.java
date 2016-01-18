package ganymedes01.headcrumbs.renderers;

import ganymedes01.headcrumbs.api.IHumanEntity;
import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.utils.TextureUtils;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerArrow;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.item.ItemBow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHuman extends RenderBiped<EntityHuman> {

	private static final ModelPlayer STEVE = new ModelPlayer(0, false);
	private static final ModelPlayer ALEX = new ModelPlayer(0, true);

	public RenderHuman(RenderManager renderManager) {
		super(renderManager, STEVE, 0.5F, 1.0F);

		addLayer(new LayerBipedArmor(this));
		addLayer(new LayerHeldItem(this));
		addLayer(new LayerArrow(this));
		addLayer(new LayerHumanDeadmau5Head(this));
		addLayer(new LayerHumanCape(this));
		addLayer(new LayerCustomHead(getMainModel().bipedHead));
	}

	@Override
	public ModelPlayer getMainModel() {
		return (ModelPlayer) super.getMainModel();
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.0F, 0.1875F, 0.0F);
	}

	@Override
	public void doRender(EntityHuman entity, double x, double y, double z, float f0, float partialTickTime) {
		setModel(entity);

		if (entity.getHeldItem() != null && entity.getHeldItem().getItem() instanceof ItemBow)
			modelBipedMain.aimedBow = true;
		else
			modelBipedMain.aimedBow = false;

		super.doRender(entity, x, y, z, f0, partialTickTime);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityHuman entity) {
		return TextureUtils.getPlayerSkin(((IHumanEntity) entity).getProfile());
	}

	//	@Override
	//	protected void renderEquippedItems(EntityHuman entity, float partialTickTime) {
	//		setModel(entity);
	//		super.renderEquippedItems(entity, partialTickTime);
	//
	//		IHumanEntity human = entity;
	//
	//		// Head equip
	//		if (isWearingHelmet(entity)) {
	//			OpenGLHelper.pushMatrix();
	//			ItemStack helmet = entity.getEquipmentInSlot(4);
	//			modelBipedMain.bipedHead.postRender(0.0625F);
	//
	//			if (modelBipedMain.isChild)
	//				OpenGLHelper.translate(0, 0.75F, 0);
	//
	//			OpenGLHelper.scale(1.0F, -1.0F, -1.0F);
	//			TileEntityBlockSkullRenderer.instance.renderHead(-0.5F, 0.0F, -0.5F, helmet);
	//			OpenGLHelper.popMatrix();
	//		}
	//
	//		if (entity.isInvisible())
	//			return;
	//
	//		// Ears
	//		ResourceLocation skin = getEntityTexture(entity);
	//		if (entity.getName().equals("deadmau5") && skin != AbstractClientPlayer.locationStevePng) {
	//			bindTexture(skin);
	//
	//			OpenGLHelper.pushMatrix();
	//			if (entity.isChild()) {
	//				float f6 = 2.0F;
	//				OpenGLHelper.scale(1.5F / f6, 1.5F / f6, 1.5F / f6);
	//				OpenGLHelper.translate(0.0F, 16.0F * 0.0625F, 0.0F);
	//			}
	//			for (int i = 0; i < 2; i++) {
	//				OpenGLHelper.pushMatrix();
	//				modelBipedMain.bipedHead.postRender(0.0625F);
	//				OpenGLHelper.translate(0.375F * (i * 2 - 1), 0.0F, 0.0F);
	//				OpenGLHelper.translate(0.0F, -0.375F, 0.0F);
	//				float scale = 4F / 3F;
	//				OpenGLHelper.scale(scale, scale, scale);
	//
	//				modelBipedMain.bipedEars.rotateAngleX = 0;
	//				modelBipedMain.bipedEars.rotateAngleY = 0;
	//				modelBipedMain.bipedEars.rotateAngleZ = 0;
	//				modelBipedMain.bipedEars.rotationPointX = 0;
	//				modelBipedMain.bipedEars.rotationPointY = 0;
	//				modelBipedMain.bipedEars.rotationPointZ = 0;
	//				modelBipedMain.bipedEars.render(0.0625F);
	//
	//				OpenGLHelper.popMatrix();
	//			}
	//			OpenGLHelper.popMatrix();
	//		}
	//
	//		// Cape
	//		ResourceLocation cape = TextureUtils.getPlayerCape(human.getProfile());
	//		if (cape != null && !entity.isChild()) {
	//			bindTexture(cape);
	//			OpenGLHelper.pushMatrix();
	//			OpenGLHelper.translate(0.0F, 0.0F, 0.125F);
	//			double d3 = human.getInterpolatedCapeX(partialTickTime);
	//			double d4 = human.getInterpolatedCapeY(partialTickTime);
	//			double d0 = human.getInterpolatedCapeZ(partialTickTime);
	//			float f4 = entity.prevRenderYawOffset + (entity.renderYawOffset - entity.prevRenderYawOffset) * partialTickTime;
	//			double d1 = MathHelper.sin(f4 * (float) Math.PI / 180.0F);
	//			double d2 = -MathHelper.cos(f4 * (float) Math.PI / 180.0F);
	//			float f5 = (float) d4 * 10.0F;
	//
	//			if (f5 < -6.0F)
	//				f5 = -6.0F;
	//
	//			if (f5 > 32.0F)
	//				f5 = 32.0F;
	//
	//			float f6 = (float) (d3 * d1 + d0 * d2) * 100.0F;
	//			float f7 = (float) (d3 * d2 - d0 * d1) * 100.0F;
	//
	//			if (f6 < 0.0F)
	//				f6 = 0.0F;
	//
	//			if (entity.isSneaking())
	//				f5 += 25.0F;
	//
	//			OpenGLHelper.rotate(6.0F + f6 / 2.0F + f5, 1.0F, 0.0F, 0.0F);
	//			OpenGLHelper.rotate(f7 / 2.0F, 0.0F, 0.0F, 1.0F);
	//			OpenGLHelper.rotate(-f7 / 2.0F, 0.0F, 1.0F, 0.0F);
	//			OpenGLHelper.rotate(180.0F, 0.0F, 1.0F, 0.0F);
	//			modelBipedMain.renderCloak(0.0625F);
	//			OpenGLHelper.popMatrix();
	//		}
	//	}

	@Override
	protected void preRenderCallback(EntityHuman entity, float float0) {
		GlStateManager.scale(0.9375F, 0.9375F, 0.9375F);
	}

	private void setModel(EntityHuman human) {
		String type = TextureUtils.getPlayerSkinType(human.getProfile());
		boolean isAlex = "slim".equals(type);
		mainModel = modelBipedMain = isAlex ? ALEX : STEVE;
	}
}