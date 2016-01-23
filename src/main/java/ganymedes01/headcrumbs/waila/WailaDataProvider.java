package ganymedes01.headcrumbs.waila;

import java.util.List;

import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import ganymedes01.headcrumbs.utils.HeadUtils;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class WailaDataProvider implements IWailaDataProvider {

	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
		TileEntity te;
		if (accessor.getBlock() == ModBlocks.empty) {
			World world = accessor.getWorld();
			BlockPos pos = accessor.getPosition();
			te = world.getTileEntity(pos);
		} else
			te = accessor.getTileEntity();

		if (te instanceof TileEntityBlockSkull) {
			TileEntityBlockSkull tile = (TileEntityBlockSkull) te;
			if (tile != null) {
				SkullTypes model = tile.getModel();
				ItemStack stack = model.getStack();
				if (model.usesProfile()) {
					NBTTagCompound nbt = NBTUtil.writeGameProfile(new NBTTagCompound(), tile.getPlayerProfile());
					stack.getTagCompound().setTag(HeadUtils.OWNER_TAG, nbt);
				}
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
	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, BlockPos pos) {
		return tag;
	}
}