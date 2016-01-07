package ganymedes01.headcrumbs.renderers;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.api.IHumanEntity;
import ganymedes01.headcrumbs.utils.TextureUtils;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderHuman extends RenderBiped {

	private static final ModelHuman STEVE = new ModelHuman(false);
	private static final ModelHuman ALEX = new ModelHuman(true);

	public RenderHuman() {
		super(STEVE, 0.5F, 1.0F);
	}

	@Override
	protected int shouldRenderPass(EntityLiving entity, int pass, float partialTickTime) {
		setModel(entity);
		return super.shouldRenderPass(entity, pass, partialTickTime);
	}

	@Override
	public void doRender(EntityLiving entity, double x, double y, double z, float f0, float partialTickTime) {
		setModel(entity);

		if (entity.getHeldItem() != null && entity.getHeldItem().getItem() instanceof ItemBow)
			modelBipedMain.aimedBow = true;
		else
			modelBipedMain.aimedBow = false;

		boolean isWearingHead = isWearingHelmet(entity);
		modelBipedMain.bipedHead.isHidden = isWearingHead;
		modelBipedMain.bipedHeadwear.isHidden = isWearingHead;

		super.doRender(entity, x, y, z, f0, partialTickTime);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return TextureUtils.getPlayerSkin(((IHumanEntity) entity).getProfile());
	}

	@Override
	protected void renderEquippedItems(EntityLiving entity, float partialTickTime) {
		setModel(entity);
		super.renderEquippedItems(entity, partialTickTime);

		IHumanEntity human = (IHumanEntity) entity;

		// Head equip
		if (isWearingHelmet(entity)) {
			OpenGLHelper.pushMatrix();
			ItemStack helmet = entity.func_130225_q(3);
			modelBipedMain.bipedHead.postRender(0.0625F);

			if (modelBipedMain.isChild)
				OpenGLHelper.translate(0, 0.75F, 0);

			OpenGLHelper.scale(1.0F, -1.0F, -1.0F);
			TileEntityBlockSkullRenderer.instance.renderHead(-0.5F, 0.0F, -0.5F, helmet);
			OpenGLHelper.popMatrix();
		}

		if (entity.isInvisible())
			return;

		// Ears
		ResourceLocation skin = getEntityTexture(entity);
		if (entity.getCommandSenderName().equals("deadmau5") && skin != AbstractClientPlayer.locationStevePng) {
			bindTexture(skin);

			OpenGLHelper.pushMatrix();
			if (entity.isChild()) {
				float f6 = 2.0F;
				OpenGLHelper.scale(1.5F / f6, 1.5F / f6, 1.5F / f6);
				OpenGLHelper.translate(0.0F, 16.0F * 0.0625F, 0.0F);
			}
			for (int i = 0; i < 2; i++) {
				OpenGLHelper.pushMatrix();
				modelBipedMain.bipedHead.postRender(0.0625F);
				OpenGLHelper.translate(0.375F * (i * 2 - 1), 0.0F, 0.0F);
				OpenGLHelper.translate(0.0F, -0.375F, 0.0F);
				float scale = 4F / 3F;
				OpenGLHelper.scale(scale, scale, scale);

				modelBipedMain.bipedEars.rotateAngleX = 0;
				modelBipedMain.bipedEars.rotateAngleY = 0;
				modelBipedMain.bipedEars.rotateAngleZ = 0;
				modelBipedMain.bipedEars.rotationPointX = 0;
				modelBipedMain.bipedEars.rotationPointY = 0;
				modelBipedMain.bipedEars.rotationPointZ = 0;
				modelBipedMain.bipedEars.render(0.0625F);

				OpenGLHelper.popMatrix();
			}
			OpenGLHelper.popMatrix();
		}

		// Cape
		ResourceLocation cape = TextureUtils.getPlayerCape(human.getProfile());
		if (cape != null && !entity.isChild()) {
			bindTexture(cape);
			OpenGLHelper.pushMatrix();
			OpenGLHelper.translate(0.0F, 0.0F, 0.125F);
			double d3 = human.getInterpolatedCapeX(partialTickTime);
			double d4 = human.getInterpolatedCapeY(partialTickTime);
			double d0 = human.getInterpolatedCapeZ(partialTickTime);
			float f4 = entity.prevRenderYawOffset + (entity.renderYawOffset - entity.prevRenderYawOffset) * partialTickTime;
			double d1 = MathHelper.sin(f4 * (float) Math.PI / 180.0F);
			double d2 = -MathHelper.cos(f4 * (float) Math.PI / 180.0F);
			float f5 = (float) d4 * 10.0F;

			if (f5 < -6.0F)
				f5 = -6.0F;

			if (f5 > 32.0F)
				f5 = 32.0F;

			float f6 = (float) (d3 * d1 + d0 * d2) * 100.0F;
			float f7 = (float) (d3 * d2 - d0 * d1) * 100.0F;

			if (f6 < 0.0F)
				f6 = 0.0F;

			if (entity.isSneaking())
				f5 += 25.0F;

			OpenGLHelper.rotate(6.0F + f6 / 2.0F + f5, 1.0F, 0.0F, 0.0F);
			OpenGLHelper.rotate(f7 / 2.0F, 0.0F, 0.0F, 1.0F);
			OpenGLHelper.rotate(-f7 / 2.0F, 0.0F, 1.0F, 0.0F);
			OpenGLHelper.rotate(180.0F, 0.0F, 1.0F, 0.0F);
			modelBipedMain.renderCloak(0.0625F);
			OpenGLHelper.popMatrix();
		}
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float float0) {
		OpenGLHelper.scale(0.9375F, 0.9375F, 0.9375F);
	}

	private boolean isWearingHelmet(EntityLiving entity) {
		ItemStack helmet = entity.func_130225_q(3);
		return helmet != null && helmet.getItem() == ModItems.skull;
	}

	private void setModel(EntityLiving human) {
		if (Headcrumbs.use18PlayerModel) {
			boolean isAlex = TextureUtils.isAlexModel(getEntityTexture(human));
			mainModel = modelBipedMain = isAlex ? ALEX : STEVE;
		}
	}
}