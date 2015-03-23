package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.client.model.ModelRenderer;

public class SheepHead extends ModelHead {

	public static final SheepHead INSTANCE = new SheepHead();

	protected SheepHead() {

	}

	@Override
	public void init() {
		setSecondTexture(Utils.getResource(Strings.MC_PREFIX + "sheep/sheep_fur.png"));

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -7.0F, -4.5F, 6, 6, 8, 0.0F);
		overlay = new ModelRenderer(this, 0, 0);
		overlay.addBox(-3.0F, -7.0F, -2.5F, 6, 6, 6, 0.6F);
		hideOverlay();
	}

	@Override
	public void renderSpecial(float skullRotation) {
		renderOverlay(skullRotation);
	}
}