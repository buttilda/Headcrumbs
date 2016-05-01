package ganymedes01.headcrumbs.renderers;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.utils.TextureUtils;
import net.minecraft.client.model.ModelBiped.ArmPose;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerArrow;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
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
	public void doRender(EntityHuman entity, double x, double y, double z, float entityYaw, float partialTickTime) {
		setModel(entity);

		ItemStack held = entity.getHeldItem(EnumHand.MAIN_HAND);
		if (held != null)
			if (held.getItem() instanceof ItemBow && entity.isDrawingBow())
				modelBipedMain.rightArmPose = ArmPose.BOW_AND_ARROW;
			else
				modelBipedMain.rightArmPose = ArmPose.ITEM;
		else
			modelBipedMain.rightArmPose = ArmPose.EMPTY;

		modelBipedMain.leftArmPose = ArmPose.EMPTY;

		super.doRender(entity, x, y, z, entityYaw, partialTickTime);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityHuman entity) {
		return TextureUtils.getPlayerSkin(entity);
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