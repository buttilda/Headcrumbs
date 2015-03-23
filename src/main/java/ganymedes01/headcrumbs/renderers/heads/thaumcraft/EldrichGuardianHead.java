package ganymedes01.headcrumbs.renderers.heads.thaumcraft;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class EldrichGuardianHead extends ModelHead {

	public static final EldrichGuardianHead INSTANCE = new EldrichGuardianHead();

	protected EldrichGuardianHead() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 40, 12);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
		setRotation(head, 0.0F, 0.0F, 0.0F);
		ModelRenderer hood1 = new ModelRenderer(this, 36, 28);
		hood1.addBox(-3.5F, -8.7F, 2.0F, 7, 7, 3);
		setRotation(hood1, -0.2268928F, 0.0F, 0.0F);
		ModelRenderer hood2 = new ModelRenderer(this, 22, 19);
		hood2.addBox(-3.0F, -9.0F, 2.5F, 6, 6, 3);
		setRotation(hood2, -0.3490659F, 0.0F, 0.0F);
		ModelRenderer hood3 = new ModelRenderer(this, 40, 4);
		hood3.addBox(-2.5F, -9.7F, 3.5F, 5, 5, 3);
		setRotation(hood3, -0.5759587F, 0.0F, 0.0F);

		head.addChild(hood1);
		head.addChild(hood2);
		head.addChild(hood3);

		hideOverlay();
	}
}