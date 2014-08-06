package ganymedes01.headcrumbs.renderers;

import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityBlockSkullRenderer extends TileEntitySpecialRenderer {

	private ModelHead model;
	private final RenderBlocks renderer = new RenderBlocks();
	public static TileEntityBlockSkullRenderer instance;

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialTicks) {
		TileEntityBlockSkull tileSkull = (TileEntityBlockSkull) tile;
		renderHead((float) x, (float) y, (float) z, tileSkull.getBlockMetadata() & 7, tileSkull.func_145906_b() * 360 / 16.0F, tileSkull.func_145904_a(), tileSkull.func_152108_a());
	}

	@Override
	public void func_147497_a(TileEntityRendererDispatcher renderer) {
		super.func_147497_a(renderer);
		instance = this;
	}

	public void renderHead(float x, float y, float z, int meta, float skullRotation, int skullType, GameProfile playerName) {
		SkullTypes type = SkullTypes.values()[skullType];
		bindTexture(type.getTexture(playerName));

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_ALPHA_TEST);

		translateHead(x, y, z, meta, skullRotation);
		skullRotation = adjustRotation(meta, skullRotation);

		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		model = ModelHead.getHead(skullType);
		model.render(skullRotation);
		renderSpecial(type, skullRotation);

		if (GL11.glIsEnabled(GL11.GL_BLEND))
			GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}

	private void renderSpecial(SkullTypes skullType, float skullRotation) {
		ResourceLocation secondTex = skullType.getSecondTexture();

		if (secondTex != null) {
			bindTexture(secondTex);
			switch (skullType) {
				case sheep:
				case bighorn:
					int c = 12;
					if (skullType == SkullTypes.bighorn)
						GL11.glColor3f(EntitySheep.fleeceColorTable[c][0], EntitySheep.fleeceColorTable[c][1], EntitySheep.fleeceColorTable[c][2]);
					model.renderOverlay(skullRotation);
					return;
				case mooshroom:
					GL11.glScaled(1, -1, 1);
					GL11.glTranslated(0, 1, 0);
					GL11.glEnable(GL11.GL_CULL_FACE);
					renderer.renderBlockAsItem(Blocks.red_mushroom, 0, 1.0F);
					GL11.glDisable(GL11.GL_CULL_FACE);
					return;
				case spider:
				case caveSpider:
				case hedgeSpider:
				case kingSpider:
				case enderDragon:
				case enderman:
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glDisable(GL11.GL_ALPHA_TEST);
					GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
					GL11.glDepthMask(true);
					char c0 = 61680;
					int j = c0 % 65536;
					int k = c0 / 65536;
					OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
					model.render(skullRotation);
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
					return;
				default:
					return;
			}
		}
	}

	private void translateHead(float x, float y, float z, int meta, float skullRotation) {
		switch (meta) {
			case 1:
				GL11.glTranslatef(x + 0.5F, y, z + 0.5F);
				break;
			case 2:
				GL11.glTranslatef(x + 0.5F, y + 0.25F, z + 0.74F);
				break;
			case 3:
				GL11.glTranslatef(x + 0.5F, y + 0.25F, z + 0.26F);
				break;
			case 4:
				GL11.glTranslatef(x + 0.74F, y + 0.25F, z + 0.5F);
				break;
			default:
				GL11.glTranslatef(x + 0.26F, y + 0.25F, z + 0.5F);
				break;
		}
	}

	protected float adjustRotation(int meta, float rotation) {
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