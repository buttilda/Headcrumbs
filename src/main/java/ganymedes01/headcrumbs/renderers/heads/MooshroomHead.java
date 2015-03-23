package ganymedes01.headcrumbs.renderers.heads;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;

import org.lwjgl.opengl.GL11;

public class MooshroomHead extends CowHead {

	public static final MooshroomHead INSTANCE = new MooshroomHead();

	private final RenderBlocks renderer = new RenderBlocks();

	protected MooshroomHead() {
		setSecondTexture(TextureMap.locationBlocksTexture);
	}

	@Override
	public void renderSpecial(float skullRotation) {
		GL11.glScaled(1, -1, 1);
		GL11.glTranslated(0, 1, 0);
		GL11.glEnable(GL11.GL_CULL_FACE);
		renderer.renderBlockAsItem(Blocks.red_mushroom, 0, 1.0F);
		GL11.glDisable(GL11.GL_CULL_FACE);
	}
}