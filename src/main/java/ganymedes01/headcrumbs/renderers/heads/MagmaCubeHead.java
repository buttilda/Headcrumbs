package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class MagmaCubeHead extends ModelHead {

	public static final MagmaCubeHead INSTANCE = new MagmaCubeHead();

	protected MagmaCubeHead() {
	}

	@Override
	public void init() {
		hideOverlay();

		head = new ModelRenderer(this, 0, 16);
		head.addBox(-2.0F, 18.0F - 24, -2.0F, 4, 4, 4);

		for (int i = 0; i < 8; i++) {
			byte x = 0;
			int y = i;

			if (i == 2) {
				x = 24;
				y = 10;
			} else if (i == 3) {
				x = 24;
				y = 19;
			}

			ModelRenderer segment = new ModelRenderer(this, x, y);
			segment.addBox(-4.0F, 16 + i - 24, -4.0F, 8, 1, 8);
			head.addChild(segment);
		}
	}
}