package ganymedes01.headcrumbs.renderers.heads.primitivemobs;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class JuggernautHead extends ModelHead {

	public static final JuggernautHead INSTANCE = new JuggernautHead();

	protected JuggernautHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 8, 17);
		head.addBox(-3.0F, -5.0F, -0.5F, 6, 5, 5);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		hideOverlay();
	}

	@Override
	public float playerRenderOffset() {
		return 2;
	}
}