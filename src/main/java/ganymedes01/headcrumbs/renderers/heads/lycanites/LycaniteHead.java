package ganymedes01.headcrumbs.renderers.heads.lycanites;

import ganymedes01.headcrumbs.renderers.ModelHead;

public class LycaniteHead extends ModelHead {

	public static final LycaniteHead INSTANCE = new LycaniteHead();

	protected LycaniteHead() {
	}

	@Override
	public void init() {
		hideOverlay();
	}
}