package ganymedes01.headcrumbs.items;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import ganymedes01.headcrumbs.utils.HeadUtils;
import ganymedes01.headcrumbs.utils.Utils;
import ganymedes01.headcrumbs.utils.helpers.LycanitesHelper;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Skull extends ItemSkull {

	public Skull() {
		setMaxDamage(0);
		setHasSubtypes(true);
		setCreativeTab(Headcrumbs.tab);
		setUnlocalizedName(Utils.getUnlocalizedName("head"));
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (side == 0)
			return false;
		else if (!world.getBlock(x, y, z).getMaterial().isSolid())
			return false;
		else if (Headcrumbs.enablePlayerStatues && stack.getItemDamage() == SkullTypes.player.ordinal() && isValidStructure(world, x, y, z)) {
			GameProfile profile = null;

			if (stack.hasTagCompound()) {
				NBTTagCompound nbt = stack.getTagCompound();
				if (nbt.hasKey("SkullOwner", 10))
					profile = NBTUtil.func_152459_a(nbt.getCompoundTag("SkullOwner"));
			}

			if (profile != null) {
				world.setBlock(x, y, z, ModBlocks.blockPlayer, 1, 3);
				Utils.doBreakParticles(world, x, y, z, Blocks.soul_sand, 0);
				world.setBlock(x, y - 1, z, ModBlocks.blockEmpty);
				Utils.doBreakParticles(world, x, y - 1, z, Blocks.soul_sand, 0);

				TileEntityBlockSkull tile = Utils.getTileEntity(world, x, y, z, TileEntityBlockSkull.class);
				if (tile != null) {

					tile.setType(stack.getItemDamage(), profile);
					tile.func_145903_a(MathHelper.floor_double(player.rotationYaw * 16.0F / 360.0F + 0.5D) & 15);
					world.notifyBlockChange(x, y, z, ModBlocks.blockPlayer);
				}

				stack.stackSize--;
				return true;
			}
		}

		if (side == 1)
			y++;
		if (side == 2)
			z--;
		if (side == 3)
			z++;
		if (side == 4)
			x--;
		if (side == 5)
			x++;

		if (!player.canPlayerEdit(x, y, z, side, stack))
			return false;
		else if (!ModBlocks.blockSkull.canPlaceBlockAt(world, x, y, z))
			return false;
		else if (!world.isRemote) {
			world.setBlock(x, y, z, ModBlocks.blockSkull, side, 2);

			int angle = 0;
			if (side == 1)
				angle = MathHelper.floor_double(player.rotationYaw * 16.0F / 360.0F + 0.5D) & 15;

			TileEntityBlockSkull tile = Utils.getTileEntity(world, x, y, z, TileEntityBlockSkull.class);

			if (tile != null) {
				GameProfile profile = null;

				if (stack.hasTagCompound()) {
					NBTTagCompound nbt = stack.getTagCompound();
					if (nbt.hasKey("SkullOwner", 10))
						profile = NBTUtil.func_152459_a(nbt.getCompoundTag("SkullOwner"));
				}

				tile.setType(stack.getItemDamage(), profile);
				tile.func_145903_a(angle);
				world.notifyBlockChange(x, y, z, ModBlocks.blockSkull);
			}

			stack.stackSize--;
		}
		return true;
	}

	private boolean isValidStructure(World world, int x, int y, int z) {
		return world.getBlock(x, y, z) == Headcrumbs.clay && world.getBlock(x, y - 1, z) == Headcrumbs.clay;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		SkullTypes type = SkullTypes.values()[Math.max(Math.min(stack.getItemDamage(), SkullTypes.values().length - 1), 0)];
		return "item." + Utils.getUnlocalizedName(type.name());
	}

	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) {
		return armorType == 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (SkullTypes skull : SkullTypes.values())
			if (skull.canShow() && skull != SkullTypes.lycanites) {
				list.add(new ItemStack(item, 1, skull.ordinal()));

				if (!Headcrumbs.hidePlayerHeadsFromTab)
					if (skull == SkullTypes.player)
						list.addAll(HeadUtils.players);
			}
		if (HeadUtils.lycanites)
			list.addAll(LycanitesHelper.getStacks());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		return itemIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("SkullOwner", 10)) {
			String name = NBTUtil.func_152459_a(stack.getTagCompound().getCompoundTag("SkullOwner")).getName();
			boolean isLycanites = stack.getItemDamage() == SkullTypes.lycanites.ordinal();
			boolean isPlayer = stack.getItemDamage() == SkullTypes.player.ordinal();
			if (isLycanites || isPlayer)
				return StatCollector.translateToLocalFormatted("item.skull.player.name", isLycanites ? LycanitesHelper.capitaliseString(name) : name);
		}
		return super.getItemStackDisplayName(stack);
	}
}