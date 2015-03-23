package ganymedes01.headcrumbs.renderers;

import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import ganymedes01.headcrumbs.utils.HeadUtils;
import ganymedes01.headcrumbs.utils.helpers.LycanitesHelperClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.EntityLiving;
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
	public static TileEntityBlockSkullRenderer instance;

	private static EntityLiving entity;

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

	private EntityLiving getEntity() {
		if (entity == null)
			entity = new EntityLiving(Minecraft.getMinecraft().theWorld) {
			};

		return entity;
	}

	public void renderHead(float x, float y, float z, int meta, float skullRotation, int skullType, GameProfile playerName) {
		if (skullType < 0 || skullType >= SkullTypes.values().length)
			return;

		SkullTypes type = SkullTypes.values()[skullType];
		if (type == SkullTypes.lycanites)
			renderLycanites(x, y, z, meta, skullRotation, type, playerName);
		else
			renderNormal(x, y, z, meta, skullRotation, type, playerName);
	}

	private void renderLycanites(float x, float y, float z, int meta, float skullRotation, SkullTypes type, GameProfile playerName) {
		if (playerName == null || !HeadUtils.lycanites) {
			renderNormal(x, y, z, meta, skullRotation, SkullTypes.blaze, playerName); // So that the heads are visible after an eventual removal of Lycanites
			return;
		}

		ModelBase model = LycanitesHelperClient.getModel(playerName.getName());
		ResourceLocation tex = type.getTexture(playerName);
		if (model != null && tex != null) {
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glEnable(GL11.GL_ALPHA_TEST);

			translateHead(x, y + 1.75F, z, meta);
			skullRotation = adjustRotation(meta, skullRotation);
			GL11.glScaled(-1, -1, 1);
			GL11.glRotated(skullRotation, 0, 1, 0);
			bindTexture(tex);
			model.render(getEntity(), 0, 0, 0, 0, 0, -1F);

			GL11.glPopMatrix();
		}
	}

	private void renderNormal(float x, float y, float z, int meta, float skullRotation, SkullTypes type, GameProfile playerName) {
		bindTexture(type.getTexture(playerName));

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_ALPHA_TEST);

		translateHead(x, y, z, meta);
		skullRotation = adjustRotation(meta, skullRotation);

		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		model = type.model();
		model.preRender();
		model.render(skullRotation);
		renderSpecial(skullRotation);

		if (GL11.glIsEnabled(GL11.GL_BLEND))
			GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}

	private void renderSpecial(float skullRotation) {
		ResourceLocation secondTex = model.getSecondTexture();

		if (secondTex != null) {
			bindTexture(secondTex);
			model.renderSpecial(skullRotation);
		}
	}

	private void translateHead(float x, float y, float z, int meta) {
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