package ganymedes01.headcrumbs.renderers;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import ganymedes01.headcrumbs.utils.helpers.LycanitesHelperClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityBlockSkullRenderer extends TileEntitySpecialRenderer<TileEntityBlockSkull> {

	private ModelHead model;
	private static EntityLiving entity;

	@Override
	public void renderTileEntityAt(TileEntityBlockSkull tile, double x, double y, double z, float partialTickTime, int destroyStage) {
		renderHead((float) x, (float) y, (float) z, tile.getBlockMetadata() & 7, tile.getSkullRotation() * 360 / 16.0F, tile.getModel(), tile.getPlayerProfile());
	}

	//	public void renderHead(float x, float y, float z, ItemStack head) {
	//		float offset = SkullTypes.values()[head.getItemDamage()].model().playerRenderOffset();
	//
	//		GameProfile profile = null;
	//		if (head.hasTagCompound())
	//			if (head.getTagCompound().hasKey("SkullOwner", Constants.NBT.TAG_COMPOUND))
	//				profile = NBTUtil.readGameProfileFromNBT(head.getTagCompound().getCompoundTag("SkullOwner"));
	//			else if (head.getTagCompound().hasKey("SkullOwner", Constants.NBT.TAG_STRING))
	//				profile = new GameProfile(null, head.getTagCompound().getString("SkullOwner"));
	//
	//		renderHead(x, y, z + offset * 0.0625F, 1, 180.0F, head.getItemDamage(), profile);
	//	}

	public void renderHead(float x, float y, float z, int meta, float skullRotation, SkullTypes type, GameProfile profile) {
		if (type == SkullTypes.lycanites)
			renderLycanites(x, y, z, meta, skullRotation, type, profile);
		else
			renderNormal(x, y, z, meta, skullRotation, type, profile);
	}

	private void renderLycanites(float x, float y, float z, int meta, float skullRotation, SkullTypes type, GameProfile profile) {
		if (profile == null || !SkullTypes.lycanites.canShow()) {
			renderNormal(x, y, z, meta, skullRotation, SkullTypes.blaze, profile); // So that the heads are visible after an eventual removal of Lycanites
			return;
		}

		ModelBase model = LycanitesHelperClient.getModel(profile.getName());
		ResourceLocation tex = type.getTexture(profile);
		if (model != null && tex != null) {
			OpenGLHelper.pushMatrix();
			OpenGLHelper.disableCull();
			OpenGLHelper.enableAlpha();

			translateHead(x, y + 1.75F, z, meta);
			skullRotation = adjustRotation(meta, skullRotation);
			OpenGLHelper.scale(-1, -1, 1);
			OpenGLHelper.rotate(skullRotation, 0, 1, 0);
			bindTexture(tex);
			model.render(getEntity(), 0, 0, 0, 0, 0, -1F);

			OpenGLHelper.popMatrix();
		}
	}

	private EntityLiving getEntity() {
		if (entity == null)
			entity = new EntityLiving(Minecraft.getMinecraft().theWorld) {
			};

		return entity;
	}

	private void renderNormal(float x, float y, float z, int meta, float skullRotation, SkullTypes type, GameProfile profile) {
		bindTexture(type.getTexture(profile));

		OpenGLHelper.pushMatrix();
		OpenGLHelper.disableCull();
		OpenGLHelper.enableRescaleNormal();
		OpenGLHelper.enableAlpha();

		translateHead(x, y, z, meta);
		skullRotation = adjustRotation(meta, skullRotation);

		OpenGLHelper.scale(-1.0F, -1.0F, 1.0F);
		model = type.model();
		model.preRender(profile);
		model.render(skullRotation);
		renderSpecial(profile, skullRotation);

		if (GL11.glIsEnabled(GL11.GL_BLEND))
			OpenGLHelper.enableBlend();
		OpenGLHelper.popMatrix();
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
				OpenGLHelper.translate(x + 0.5F, y, z + 0.5F);
				break;
			case 2:
				OpenGLHelper.translate(x + 0.5F, y + 0.25F, z + 0.74F);
				break;
			case 3:
				OpenGLHelper.translate(x + 0.5F, y + 0.25F, z + 0.26F);
				break;
			case 4:
				OpenGLHelper.translate(x + 0.74F, y + 0.25F, z + 0.5F);
				break;
			default:
				OpenGLHelper.translate(x + 0.26F, y + 0.25F, z + 0.5F);
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