package ganymedes01.headcrumbs.renderers;

import ganymedes01.headcrumbs.entity.EntityCelebrity;
import ganymedes01.headcrumbs.utils.TextureUtils;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
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
}