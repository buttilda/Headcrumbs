package ganymedes01.headcrumbs.utils.helpers;

import java.util.function.Function;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.utils.HeadUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.TinkerRegistry;

public class TConstructHelper {

	public static void registerHeadDrop(Class<? extends EntityLivingBase> clazz, Function<EntityLivingBase, ItemStack> callback) {
		TinkerRegistry.registerHeadDrop(clazz, callback);
	}
	
	public static void registerHeadDrop(Class<? extends EntityLivingBase> clazz, ItemStack head) {
		TinkerRegistry.registerHeadDrop(clazz, head);
	}
	
	public static void registerHeadDrop(Class<? extends EntityLivingBase> clazz) {
		TinkerRegistry.registerHeadDrop(clazz, (e) -> {
			return HeadUtils.getHeadfromEntity(e);
		});
	}
	
}
