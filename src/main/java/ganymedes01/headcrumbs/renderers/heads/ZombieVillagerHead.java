package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class ZombieVillagerHead extends ModelHead {

	public static final ZombieVillagerHead INSTANCE = new ZombieVillagerHead();

	protected ZombieVillagerHead() {
	}

	@Override
	public void init() {
		head = new ModelRenderer(this).setTextureSize(64, 64);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 32).addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
		overlay = new ModelRenderer(this).setTextureSize(64, 64);
		overlay.setRotationPoint(0.0F, -2.0F, 0.0F);
		overlay.setTextureOffset(24, 32).addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
	}
}