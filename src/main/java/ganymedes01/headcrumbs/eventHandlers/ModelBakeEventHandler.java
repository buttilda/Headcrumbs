package ganymedes01.headcrumbs.eventHandlers;

import ganymedes01.headcrumbs.renderers.SkullItemBakedModel;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModelBakeEventHandler
{

	@SubscribeEvent
	public void onModelBakeEvent(ModelBakeEvent event)
	{
		Object object = event.getModelRegistry().getObject(SkullItemBakedModel.RES_LOC);
		if(object instanceof IBakedModel)
		{
			event.getModelRegistry().putObject(SkullItemBakedModel.RES_LOC, new SkullItemBakedModel((IBakedModel) object));
		}
	}
}