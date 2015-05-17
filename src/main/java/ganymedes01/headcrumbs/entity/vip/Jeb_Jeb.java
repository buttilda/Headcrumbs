package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityChicken;
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
	public String livingSound() {
		return "mob.sheep.say";
	}

	@Override
	protected String hurtSound() {
		return "mob.sheep.say";
	}

	@Override
	protected String deathSound() {
		return "mob.sheep.say";
	}

	@Override
	protected ItemStack getItem(EntityHuman entity) {
		return entity.getRNG().nextFloat() > 0.25F ? new ItemStack(Blocks.double_plant, 1, 5) : new ItemStack(Blocks.red_flower, 1, 2);
	}

	@Override
	public void onSpawn(EntityHuman entity) {
		if (!Headcrumbs.enableBaarbra)
			return;
		EntityLiving mount = entity.isChild() ? new EntityChicken(entity.worldObj) : new EntitySheep(entity.worldObj);
		mount.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
		mount.onSpawnWithEgg(null);
		if (mount instanceof EntitySheep)
			((EntitySheep) mount).setFleeceColor(BlockColored.func_150032_b(5));

		mount.setCustomNameTag(entity.isChild() ? "Omelette" : "Baabara");
		entity.worldObj.spawnEntityInWorld(mount);
		mount.playLivingSound();
		entity.mountEntity(mount);
	}
}