package ganymedes01.headcrumbs.waila;

import java.util.List;

import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import ganymedes01.headcrumbs.utils.HeadUtils;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class WailaDataProvider implements IWailaDataProvider {

	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
		TileEntity te;
		if (accessor.getBlock() == ModBlocks.blockEmpty) {
			World world = accessor.getWorld();
			MovingObjectPosition mop = accessor.getPosition();
			te = world.getTileEntity(mop.blockX, mop.blockY + 1, mop.blockZ);
		} else
			te = accessor.getTileEntity();

		if (te instanceof TileEntityBlockSkull) {
			TileEntityBlockSkull tile = (TileEntityBlockSkull) te;
			if ((tile.func_145904_a() == SkullTypes.player.ordinal() || tile.func_145904_a() == SkullTypes.lycanites.ordinal()) && tile.func_152108_a() != null) {
				ItemStack stack = new ItemStack(ModItems.skull, 1, ModBlocks.blockSkull.getDamageValue(tile.getWorldObj(), tile.xCoord, tile.yCoord, tile.zCoord));
				stack = HeadUtils.createHeadFor(tile.func_152108_a());
				stack.setItemDamage(tile.func_145904_a());
				return stack;
			}
		}
		return null;
	}

	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return currenttip;
	}

	@Override
	public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return currenttip;
	}

	@Override
	public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return currenttip;
	}

	@Override
	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z) {
		return tag;
	}
}