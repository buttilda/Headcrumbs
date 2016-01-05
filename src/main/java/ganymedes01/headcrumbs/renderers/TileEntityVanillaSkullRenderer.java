package ganymedes01.headcrumbs.renderers;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;

@SideOnly(Side.CLIENT)
public class TileEntityVanillaSkullRenderer extends TileEntitySkullRenderer {

	@Override
	public void func_152674_a(float x, float y, float z, int meta, float skullRotation, int type, GameProfile profile) {
		if (type == 3)
			TileEntityBlockSkullRenderer.instance.renderHead(x, y, z, meta, skullRotation, SkullTypes.player.ordinal(), profile);
		else
			super.func_152674_a(x, y, z, meta, skullRotation, type, profile);
	}
}