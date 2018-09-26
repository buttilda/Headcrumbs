package ganymedes01.headcrumbs.renderers;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityBlockSkullRenderer extends TileEntitySpecialRenderer<TileEntityBlockSkull> {

	public static final TileEntityBlockSkullRenderer INSTANCE = new TileEntityBlockSkullRenderer();
	private ModelHead model;

	@Override
	public void func_192841_a(TileEntityBlockSkull tile, double x, double y, double z, float partialTickTime, int destroyStage, float p_192841_10_) {
		renderHead((float) x, (float) y, (float) z, tile.getBlockMetadata() & 7, tile.getSkullRotation() * 360 / 16.0F, tile.getModel(), tile.getPlayerProfile(), destroyStage);
	}

	private void renderHead(float x, float y, float z, int meta, float skullRotation, SkullTypes type, GameProfile profile, int destroyStage) {
		if (destroyStage >= 0) {
			bindTexture(DESTROY_STAGES[destroyStage]);
			GlStateManager.matrixMode(5890);
			GlStateManager.pushMatrix();
			GlStateManager.scale(4.0F, 2.0F, 1.0F);
			GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
			GlStateManager.matrixMode(5888);
		} else
			bindTexture(type.getTexture(profile));

		GlStateManager.pushMatrix();
		GlStateManager.disableCull();
		GlStateManager.enableRescaleNormal();
		GlStateManager.enableAlpha();

		translateHead(x, y, z, meta);
		skullRotation = adjustRotation(meta, skullRotation);

		GlStateManager.scale(-1.0F, -1.0F, 1.0F);
		model = type.model();
		model.preRender(profile);
		model.render(skullRotation);
		renderSpecial(profile, skullRotation);

		if (GL11.glIsEnabled(GL11.GL_BLEND))
			GlStateManager.enableBlend();
		GlStateManager.popMatrix();

		if (destroyStage >= 0) {
			GlStateManager.matrixMode(5890);
			GlStateManager.popMatrix();
			GlStateManager.matrixMode(5888);
		}
	}

	private void renderSpecial(GameProfile profile, float skullRotation) {
		ResourceLocation secondTex = model.getSecondTexture();

		if (secondTex != null)
			bindTexture(secondTex);
		model.renderSpecial(profile, skullRotation);
	}

	private void translateHead(float x, float y, float z, int meta) {
		switch (meta) {
		case 1:
			GlStateManager.translate(x + 0.5F, y, z + 0.5F);
			break;
		case 2:
			GlStateManager.translate(x + 0.5F, y + 0.25F, z + 0.74F);
			break;
		case 3:
			GlStateManager.translate(x + 0.5F, y + 0.25F, z + 0.26F);
			break;
		case 4:
			GlStateManager.translate(x + 0.74F, y + 0.25F, z + 0.5F);
			break;
		default:
			GlStateManager.translate(x + 0.26F, y + 0.25F, z + 0.5F);
			break;
		}
	}

	private float adjustRotation(int meta, float rotation) {
		switch (meta) {
		case 1:
		case 2:
			return rotation;
		case 3:
			return 180.0F;
		case 4:
			return 270.0F;
		default:
			return 90.0F;
		}
	}
}