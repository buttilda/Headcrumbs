package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;

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
	public void onSpawn(EntityHuman entity, DifficultyInstance difficulty) {
		if (!Headcrumbs.enableBaarbra)
			return;
		EntityLiving mount = entity.isChild() ? new EntityChicken(entity.worldObj) : new EntitySheep(entity.worldObj);
		mount.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
		mount.onInitialSpawn(difficulty, null);
		if (mount instanceof EntitySheep)
			((EntitySheep) mount).setFleeceColor(EnumDyeColor.PURPLE);

		mount.setCustomNameTag(entity.isChild() ? "Omelette" : "Baabara");
		entity.worldObj.spawnEntityInWorld(mount);
		mount.playLivingSound();
		entity.mountEntity(mount);
	}
}