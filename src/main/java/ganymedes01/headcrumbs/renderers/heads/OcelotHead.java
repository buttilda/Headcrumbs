package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class OcelotHead extends ModelHead {

	public static final OcelotHead INSTANCE = new OcelotHead();

	protected OcelotHead() {
		setTextureOffset("head.main", 0, 0);
		setTextureOffset("head.nose", 0, 24);
		setTextureOffset("head.ear1", 0, 10);
		setTextureOffset("head.ear2", 6, 10);
		hideOverlay();
		head = new ModelRenderer(this, "head");
		float f1 = -2;
		float f2 = 2;
		head.addBox("main", -2.5F, -2.0F + f1, -3.0F + f2, 5, 4, 5);
		head.addBox("nose", -1.5F, 0.0F + f1, -4.0F + f2, 3, 2, 2);
		head.addBox("ear1", -2.0F, -3.0F + f1, 0.0F + f2, 1, 1, 2);
		head.addBox("ear2", 1.0F, -3.0F + f1, 0.0F + f2, 1, 1, 2);
	}

	@Override
	public float playerRenderOffset() {
		return 2;
	}
}