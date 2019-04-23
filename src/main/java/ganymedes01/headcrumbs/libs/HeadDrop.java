package ganymedes01.headcrumbs.libs;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.util.ResourceLocation;

public class HeadDrop
{
	public static final HeadDrop DEFAULT = new HeadDrop(Strings.MC_PREFIX + "blaze", ModelHead.INSTANCE_NO_OVERLAY);
	
	private final ResourceLocation texture;
	private final ModelHead model;

	public HeadDrop(String texture, ModelHead model)
	{
		this.texture = Utils.getResource(texture + ".png");
		this.model = model;
		if(model == null)
			throw new IllegalArgumentException("Head model for " + this + " cannot be null!");
	}

	public ResourceLocation getTexture(GameProfile profile)
	{
		return texture;
	}

	public ModelHead getModel()
	{
		return model;
	}
}
