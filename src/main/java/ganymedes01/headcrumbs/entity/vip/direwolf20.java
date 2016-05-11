package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import ganymedes01.headcrumbs.libs.Reference;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class direwolf20 extends VIPHandler {

	private static SoundEvent takeItEasy;
	static {
		ResourceLocation resLoc = Utils.getResource(Reference.MOD_ID, "takeiteasy");
		takeItEasy = new SoundEvent(resLoc);
		takeItEasy.setRegistryName(resLoc);
		GameRegistry.register(takeItEasy);
	}

	@Override
	public void onSpawn(EntityHuman entity, DifficultyInstance difficulty) {
		Item wrench = Item.itemRegistry.getObject(new ResourceLocation("BuildCraft|Core", "wrenchItem"));
		if (wrench != null)
			entity.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(wrench));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return takeItEasy;
	}

	@Override
	protected SoundEvent hurtSound() {
		return takeItEasy;
	}

	@Override
	protected SoundEvent deathSound() {
		return takeItEasy;
	}

	public static void makeDirestick(EntityHuman human, EntityPlayer player, ItemStack stack) {
		if (!"direwolf20".equals(human.getUsername())) {
			ItemStack stick = new ItemStack(Items.stick);
			stick.setStackDisplayName("Direstick");
			stick.getTagCompound().setBoolean("IsDirestick", true);

			if (--stack.stackSize <= 0)
				player.setHeldItem(EnumHand.MAIN_HAND, stick);
			else
				player.inventory.addItemStackToInventory(stick);
		}
	}

	public static void takeItEasy(EntityPlayer player) {
		if (!player.worldObj.isRemote)
			player.worldObj.playSound(null, player.posX, player.posY, player.posZ, takeItEasy, SoundCategory.NEUTRAL, 1.0F, 1.0F);
	}
}