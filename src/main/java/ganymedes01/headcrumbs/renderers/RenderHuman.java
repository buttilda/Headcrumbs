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