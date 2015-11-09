package ganymedes01.headcrumbs.renderers;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

public class ModelHead extends ModelBase {

	public static final ModelHead INSTANCE = new ModelHead();
	public static final ModelHead INSTANCE_NO_OVERLAY = new ModelHead().hideOverlay();

	protected ModelRenderer head;
	protected ModelRenderer overlay;
	private boolean renderOverlay;
	private ResourceLocation secondTex = null;

	public ModelHead() {
		this(32);
	}

	protected ModelHead(int height) {
		textureWidth = 64;
		textureHeight = height;
		renderOverlay = true;
		head = new ModelRenderer(this, 0, 0);
		overlay = new ModelRenderer(this, 32, 0);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		overlay.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
		overlay.setRotationPoint(0.0F, 0.0F, 0.0F);
	}

	public void init() {
	}

	public void preRender(GameProfile profile) {
	}

	public void renderSpecial(GameProfile profile, float skullRotation) {
	}

	public void preRenderItem(GameProfile profile, ItemRenderType type) {
	}

	public final ResourceLocation getSecondTexture() {
		return secondTex;
	}

	protected void setSecondTexture(ResourceLocation texture) {
		secondTex = texture;
	}

	public float playerRenderOffset() {
		return 0;
	}

	protected ModelHead hideOverlay() {
		renderOverlay = false;
		return this;
	}

	public void render(float rotationX) {
		render(rotationX, 0.0F);
	}

	public void render(float rotationX, float rotationY) {
		head.rotateAngleY = rotationX / (180F / (float) Math.PI);
		head.rotateAngleX = rotationY / (180F / (float) Math.PI);
		head.render(0.0625F);
		if (renderOverlay)
			renderOverlay(rotationX, rotationY);
	}

	public void renderOverlay(float rotationX) {
		renderOverlay(rotationX, 0.0F);
	}

	public void renderOverlay(float rotationX, float rotationY) {
		overlay.rotateAngleY = rotationX / (180F / (float) Math.PI);
		overlay.rotateAngleX = rotationY / (180F / (float) Math.PI);
		overlay.render(0.0625F);
	}

	protected void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void renderLitUp(float skullRotation) {
		boolean isAlphaEnabled = GL11.glIsEnabled(GL11.GL_ALPHA_TEST);

		OpenGLHelper.pushMatrix();
		OpenGLHelper.enableBlend();
		if (isAlphaEnabled)
			GL11.glDisable(GL11.GL_ALPHA_TEST);
		OpenGLHelper.blendFunc(GL11.GL_ONE, GL11.GL_ONE);
		OpenGLHelper.depthMask(true);
		float brightnessX = OpenGlHelper.lastBrightnessX;
		float brightnessY = OpenGlHelper.lastBrightnessY;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680, 0);

		render(skullRotation);

		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, brightnessX, brightnessY);
		OpenGLHelper.disableBlend();
		OpenGLHelper.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		if (isAlphaEnabled)
			OpenGLHelper.enableAlpha();
		OpenGLHelper.popMatrix();
	}
}