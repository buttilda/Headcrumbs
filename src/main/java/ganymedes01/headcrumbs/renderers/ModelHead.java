package ganymedes01.headcrumbs.renderers;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;

public class ModelHead extends ModelBase {

	public static final ModelHead INSTANCE = new ModelHead();
	public static final ModelHead INSTANCE_NO_OVERLAY = new ModelHead().hideOverlay();

	protected ModelRenderer head;
	protected ModelRenderer overlay;
	private boolean renderOverlay;
	private ResourceLocation secondTex = null;

	private boolean translated = false;
	private float dx;
	private float dy;
	private float dz;
	private float dDist;
	
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
	
	public void postRender() {
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

	public void setTranslation(float dx, float dy, float dz) {
		this.translated = true;
		if (dx < 0) this.dx = -1;
		else if (dx > 0) this.dx = 1;
		this.dy = dy;
		if (dz < 0) this.dz = -1;
		else if (dz > 0) this.dz = 1;
		this.dDist = (float) Math.sqrt(Math.pow(dx, 2) + Math.pow(dz, 2));
	}
	
	public void applyTranslation() {
		if (this.translated) {
			float dx = (float) (Math.sin(head.rotateAngleY - Math.PI) * -this.dDist);
			float dz = (float) (Math.cos(head.rotateAngleY - Math.PI) * -this.dDist);
			
			if ((head.rotateAngleY >= Math.PI/4.0d * 3.0d && Math.PI/4.0d * 5.0d  >= head.rotateAngleY)
					|| (head.rotateAngleY >= Math.PI/4.0d * 7.0d || Math.PI/4.0d >= head.rotateAngleY)) {
				dx *= this.dx;
				dz *= this.dz;
			} else {
				dx *= this.dz;
				dz *= this.dx;
			}
			
			GlStateManager.translate(dx, dy, dz);
		}
	}
	
	public void render(float rotationX, float rotationY) {
		head.rotateAngleY = rotationX / (180F / (float) Math.PI);
		head.rotateAngleX = rotationY / (180F / (float) Math.PI);
		applyTranslation();
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

		GlStateManager.pushMatrix();
		GlStateManager.enableBlend();
		if (isAlphaEnabled)
			GL11.glDisable(GL11.GL_ALPHA_TEST);
		GlStateManager.blendFunc(GL11.GL_ONE, GL11.GL_ONE);
		GlStateManager.depthMask(true);
		float brightnessX = OpenGlHelper.lastBrightnessX;
		float brightnessY = OpenGlHelper.lastBrightnessY;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680, 0);

		render(skullRotation);

		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, brightnessX, brightnessY);
		GlStateManager.disableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		if (isAlphaEnabled)
			GlStateManager.enableAlpha();
		GlStateManager.popMatrix();
	}
}