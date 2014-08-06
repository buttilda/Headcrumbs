package ganymedes01.headcrumbs.eventHandlers;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.renderers.TileEntityBlockSkullRenderer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTUtil;
import net.minecraftforge.client.event.RenderPlayerEvent;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPlayerHandler {

	@SubscribeEvent
	public void renderPlayerEvent(RenderPlayerEvent.Pre event) {
		if (event.entityPlayer != null) {
			ModelBiped model = event.renderer.modelBipedMain;
			if (model == null)
				return;

			ItemStack head = event.entityPlayer.inventory.armorItemInSlot(3);
			if (head != null && head.getItem() == ModItems.skull)
				setHiddenState(model, true);
			else
				setHiddenState(model, false);
		}
	}

	@SubscribeEvent
	public void renderHelmetEvent(RenderPlayerEvent.Specials.Post event) {
		if (event.entityPlayer != null) {
			ModelBiped model = event.renderer.modelBipedMain;

			ItemStack head = event.entityPlayer.inventory.armorItemInSlot(3);
			if (head != null && head.getItem() == ModItems.skull) {
				GL11.glColor3f(1.0F, 1.0F, 1.0F);

				setHiddenState(model, false);
				model.bipedHead.postRender(0.0625F);
				setHiddenState(model, true);

				GL11.glPushMatrix();
				GL11.glScalef(1.0F, -1.0F, -1.0F);

				float offset = 0.0F;
				switch (head.getItemDamage()) {
					case 7:
						offset = 1.0F;
						break;
					case 10:
					case 12:
						offset = 2.0F;
						break;
					case 18:
						offset = 3.0F;
						break;
					case 21:
						offset = 2.0f;
						break;
				}

				TileEntityBlockSkullRenderer.instance.renderHead(-0.5F, 0.0F, -0.5F + offset * 0.0625F, 1, 180.0F, head.getItemDamage(), head.hasTagCompound() ? NBTUtil.func_152459_a(head.getTagCompound().getCompoundTag("Owner")) : null);
				GL11.glPopMatrix();
			}
		}
	}

	private void setHiddenState(ModelBiped model, boolean isHidden) {
		model.bipedHead.isHidden = isHidden;
		model.bipedHeadwear.isHidden = isHidden;
	}
}