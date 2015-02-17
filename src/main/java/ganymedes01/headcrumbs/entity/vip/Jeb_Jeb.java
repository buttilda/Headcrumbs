package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.entity.EntityCelebrity;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class Jeb_Jeb extends VIPHandler {

	@Override
	protected int minDropAmount() {
		return 1;
	}

	@Override
	protected int maxBaseDropAmount() {
		return 5;
	}

	@Override
	protected ItemStack getItem(EntityCelebrity entity) {
		return entity.getRNG().nextFloat() > 0.25F ? new ItemStack(Blocks.double_plant, 1, 5) : new ItemStack(Blocks.red_flower, 1, 2);
	}

	@Override
	public void onSpawn(EntityCelebrity entity) {
		if (!Headcrumbs.enableBaarbra)
			return;
		EntitySheep sheep = new EntitySheep(entity.worldObj);
		sheep.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
		sheep.onSpawnWithEgg(null);
		sheep.setFleeceColor(BlockColored.func_150032_b(5));

		sheep.setCustomNameTag("Baabara");
		entity.worldObj.spawnEntityInWorld(sheep);
		sheep.playLivingSound();
		entity.mountEntity(sheep);
	}
}