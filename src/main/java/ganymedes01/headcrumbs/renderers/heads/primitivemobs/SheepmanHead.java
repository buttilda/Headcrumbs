package ganymedes01.headcrumbs.renderers.heads.primitivemobs;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class SheepmanHead extends ModelHead {

	public static final SheepmanHead INSTANCE = new SheepmanHead();

	protected SheepmanHead() {
		super(64);
	}

	@Override
	public void init() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, -5.0F, 6, 6, 8);
		head.setTextureSize(64, 64);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 0, 14);
		overlay.addBox(-3.5F, -6.5F, -4.1F, 7, 7, 8);
		overlay.setTextureSize(64, 64);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
	}
}