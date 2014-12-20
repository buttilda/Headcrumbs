package ganymedes01.headcrumbs.renderers;

import ganymedes01.headcrumbs.entity.EntityCelebrity;
import ganymedes01.headcrumbs.utils.TextureUtils;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCelebrity extends RenderBiped {

	public RenderCelebrity() {
		super(new ModelBiped(), 0.5F, 1.0F);
	}

	@Override
	public void doRender(EntityLiving entity, double d0, double d1, double d2, float f0, float f1) {
		if (entity.getHeldItem() != null && entity.getHeldItem().getItem() == Items.bow)
			modelBipedMain.aimedBow = true;
		else
			modelBipedMain.aimedBow = false;

		super.doRender(entity, d0, d1, d2, f0, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return TextureUtils.getPlayerSkin(((EntityCelebrity) entity).getProfile());
	}

	@Override
	protected void renderEquippedItems(EntityLivingBase entity, float float0) {
		super.renderEquippedItems(entity, float0);
		if (entity.isInvisible())
			return;

		EntityCelebrity celebrity = (EntityCelebrity) entity;
		ResourceLocation cape = TextureUtils.getPlayerCape(celebrity.getProfile());
		if (cape == null)
			return;

		bindTexture(cape);
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, 0.0F, 0.125F);
		double d3 = celebrity.field_71091_bM + (celebrity.field_71094_bP - celebrity.field_71091_bM) * float0 - (celebrity.prevPosX + (celebrity.posX - celebrity.prevPosX) * float0);
		double d4 = celebrity.field_71096_bN + (celebrity.field_71095_bQ - celebrity.field_71096_bN) * float0 - (celebrity.prevPosY + (celebrity.posY - celebrity.prevPosY) * float0);
		double d0 = celebrity.field_71097_bO + (celebrity.field_71085_bR - celebrity.field_71097_bO) * float0 - (celebrity.prevPosZ + (celebrity.posZ - celebrity.prevPosZ) * float0);
		float f4 = celebrity.prevRenderYawOffset + (celebrity.renderYawOffset - celebrity.prevRenderYawOffset) * float0;
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

		float f8 = 0;//celebrity.prevCameraYaw + (celebrity.cameraYaw - celebrity.prevCameraYaw) * float0;
		f5 += MathHelper.sin((celebrity.prevDistanceWalkedModified + (celebrity.distanceWalkedModified - celebrity.prevDistanceWalkedModified) * float0) * 6.0F) * 32.0F * f8;

		if (celebrity.isSneaking())
			f5 += 25.0F;

		GL11.glRotatef(6.0F + f6 / 2.0F + f5, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(f7 / 2.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-f7 / 2.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		modelBipedMain.renderCloak(0.0625F);
		GL11.glPopMatrix();
	}
}