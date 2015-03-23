package ganymedes01.headcrumbs.renderers;

import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.utils.HeadUtils;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ItemSkullRender implements IItemRenderer {

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return type != ItemRenderType.FIRST_PERSON_MAP;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack stack, Object... data) {
		int skullType = stack.getItemDamage();
		if (skullType < 0 || skullType >= SkullTypes.values().length)
			return;

		GameProfile profile = null;
		boolean isVanilla = stack.getItem() == Items.skull;

		if (stack.hasTagCompound()) {
			profile = HeadUtils.getGameProfile(stack);
			if (isVanilla) {
				skullType = SkullTypes.player.ordinal();
				isVanilla = false;
			}
		}

		if (!isVanilla)
			SkullTypes.values()[skullType].model().preRenderItem(type);

		switch (type) {
			case ENTITY:
				renderSkull(-0.25F, -0.5F, -0.5F, skullType, profile, isVanilla);
				break;
			case EQUIPPED:
				renderSkull(0.5F, 0.0F, 0.0F, skullType, profile, isVanilla);
				break;
			case EQUIPPED_FIRST_PERSON:
				renderSkull(0.5F, 0.35F, 0.25F, skullType, profile, isVanilla);
				break;
			case INVENTORY:
				GL11.glScaled(1.5, 1.5, 1.5);
				renderSkull(0.75F, 0.30F, 0.5F, skullType, profile, isVanilla);
				break;
			default:
				break;
		}
	}

	private void renderSkull(float x, float y, float z, int type, GameProfile name, boolean isVanilla) {
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);
		if (isVanilla)
			TileEntitySkullRenderer.field_147536_b.func_152674_a(0, 0, 0, 0, 0, type, name);
		else
			TileEntityBlockSkullRenderer.instance.renderHead(0, 0, 0, 0, 0, type, name);
		GL11.glPopMatrix();
	}
}