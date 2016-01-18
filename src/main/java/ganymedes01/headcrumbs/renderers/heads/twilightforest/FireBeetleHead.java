package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class FireBeetleHead extends ModelHead {

	public static final FireBeetleHead INSTANCE = new FireBeetleHead();

	protected FireBeetleHead() {
	}

	@Override
	public void init() {
		hideOverlay();
		float f = 4;
		float f2 = -2;
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0f, -4.0f + f2, -6.0f + f, 8, 6, 6);
		head.setRotationPoint(0.0f, 0.0f, 0.0f);
		ModelRenderer jaw1a = new ModelRenderer(this, 0, 0);
		jaw1a.addBox(0.0f, 0.0f, -2.0f, 1, 1, 2);
		jaw1a.setRotationPoint(-3.0f, 0.0f + f2, -6.0f + f);
		setRotation(jaw1a, 0.3490659f, 0.0f, 0.0f);
		ModelRenderer jaw1b = new ModelRenderer(this, 0, 0);
		jaw1b.addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
		jaw1b.setRotationPoint(0.0f, 0.0f + f2, -2.0f + f);
		setRotation(jaw1b, 0.0f, 1.570796f, 0.0f);
		ModelRenderer jaw2a = new ModelRenderer(this, 0, 0);
		jaw2a.addBox(-1.0f, 0.0f, -2.0f, 1, 1, 2);
		jaw2a.setRotationPoint(3.0f, 0.0f + f2, -6.0f + f);
		setRotation(jaw2a, 0.3490659f, 0.0f, 0.0f);
		ModelRenderer jaw2b = new ModelRenderer(this, 0, 0);
		jaw2b.addBox(0.0f, 0.0f, -2.0f, 1, 1, 2);
		jaw2b.setRotationPoint(0.0f, 0.0f + f2, -2.0f + f);
		setRotation(jaw2b, 0.0f, 1.570796f, 0.0f);
		ModelRenderer antenna1 = new ModelRenderer(this, 42, 4);
		antenna1.addBox(0.0f, -0.5f, -0.5f, 10, 1, 1);
		antenna1.setRotationPoint(1.0f, -3.0f + f2, -5.0f + f);
		setRotation(antenna1, 0.0f, 1.047198f, -0.296706f);
		ModelRenderer antenna2 = new ModelRenderer(this, 42, 4);
		antenna2.addBox(0.0f, -0.5f, -0.5f, 10, 1, 1);
		antenna2.setRotationPoint(-1.0f, -3.0f + f2, -5.0f + f);
		setRotation(antenna2, 0.0f, 2.094395f, 0.296706f);
		ModelRenderer eye1 = new ModelRenderer(this, 15, 12);
		eye1.addBox(-1.5f, -1.5f, -1.5f, 3, 3, 3);
		eye1.setRotationPoint(-3.0f, -2.0f + f2, -5.0f + f);
		ModelRenderer eye2 = new ModelRenderer(this, 15, 12);
		eye2.addBox(-1.5f, -1.5f, -1.5f, 3, 3, 3);
		eye2.setRotationPoint(3.0f, -2.0f + f2, -5.0f + f);
		head.addChild(jaw1a);
		jaw1a.addChild(jaw1b);
		head.addChild(jaw2a);
		jaw2a.addChild(jaw2b);
		head.addChild(antenna1);
		head.addChild(antenna2);
		head.addChild(eye1);
		head.addChild(eye2);
	}

	@Override
	public float playerRenderOffset() {
		return 1;
	}

	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		if (type == ItemRenderType.INVENTORY)
			GlStateManager.translate(0, 0.25, 0.5);
	}
}