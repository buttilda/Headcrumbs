package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class VillagerHead extends ModelHead {

	public static final VillagerHead INSTANCE64 = new VillagerHead(64);
	public static final VillagerHead INSTANCE128 = new VillagerHead(128);

	protected VillagerHead(int textureSize) {
		head = new ModelRenderer(this).setTextureSize(textureSize, textureSize);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
		overlay = new ModelRenderer(this).setTextureSize(textureSize, textureSize);
		overlay.setRotationPoint(0.0F, -2.0F, 0.0F);
		overlay.setTextureOffset(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
	}
}