package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import ganymedes01.headcrumbs.renderers.heads.WolfHead;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import org.lwjgl.opengl.GL11;

public class MistWolfHead extends WolfHead {

	public static final MistWolfHead INSTANCE = new MistWolfHead();

	protected MistWolfHead() {
	}

	@Override
	public void preRender() {
		GL11.glScaled(1.5, 1.5, 1.5);
	}

	@Override
	public void preRenderItem(ItemRenderType type) {
		GL11.glTranslated(0, -0.25, 0);
	}
}