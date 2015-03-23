package ganymedes01.headcrumbs.renderers.heads;

public class WitherHead extends PigmanHead {

	public static final WitherHead INSTANCE = new WitherHead();

	protected WitherHead() {
	}

	@Override
	public void init() {
		hideOverlay();
	}
}