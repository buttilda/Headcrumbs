package ganymedes01.headcrumbs.renderers.heads;

public class MooshroomHead extends CowHead {

	public static final MooshroomHead INSTANCE = new MooshroomHead();

	//	private RenderBlocks renderer;
	//
	//	protected MooshroomHead() {
	//	}
	//
	//	@Override
	//	public void init() {
	//		super.init();
	//		setSecondTexture(TextureMap.locationBlocksTexture);
	//		renderer = new RenderBlocks();
	//	}
	//
	//	@Override
	//	public void renderSpecial(GameProfile profile, float skullRotation) {
	//		OpenGLHelper.scale(1, -1, 1);
	//		OpenGLHelper.translate(0, 1, 0);
	//		OpenGLHelper.enableCull();
	//		renderer.renderBlockAsItem(Blocks.red_mushroom, 0, 1.0F);
	//		OpenGLHelper.disableCull();
	//	}
}