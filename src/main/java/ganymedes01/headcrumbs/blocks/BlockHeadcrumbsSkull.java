package ganymedes01.headcrumbs.blocks;

import java.util.ArrayList;
import java.util.List;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.ModBlocks.IHasCustomItem;
import ganymedes01.headcrumbs.items.ItemHeadcrumbsSkull;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

//@Optional.Interface(iface = "thaumcraft.api.crafting.IInfusionStabiliser", modid = "Thaumcraft")
public class BlockHeadcrumbsSkull extends BlockSkull
	implements IHasCustomItem/* , IInfusionStabiliser */ {

    public BlockHeadcrumbsSkull() {
	setHardness(1.0F);
	setSoundType(SoundType.STONE);
	setCreativeTab(Headcrumbs.tab);
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
	    EntityPlayer player) {
	TileEntityBlockSkull tile = Utils.getTileEntity(world, pos, TileEntityBlockSkull.class);
	if (tile != null) {
	    SkullTypes model = tile.getModel();
	    return model.getStack();
	}
	return null;
    }

    /*
     * @Override
     * 
     * @SideOnly(Side.CLIENT) public void getSubBlocks(Item item, CreativeTabs
     * tab, List<ItemStack> list) { for (SkullTypes skull : SkullTypes.values())
     * if (skull.canShow()) list.add(skull.getStack()); }
     */

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
	return new TileEntityBlockSkull();
    }

    @Override
    public boolean canDispenserPlace(World world, BlockPos pos, ItemStack stack) {
	return false;
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
	List<ItemStack> list = new ArrayList<ItemStack>();
	if (!state.getValue(NODROP).booleanValue()) {
	    TileEntityBlockSkull tile = Utils.getTileEntity(world, pos, TileEntityBlockSkull.class);

	    if (tile != null) {
		SkullTypes model = tile.getModel();
		list.add(model.getStack());
	    }
	}
	return list;
    }

    @Override
    public ItemBlock getItemBlock() {
	return new ItemHeadcrumbsSkull(this);
    }
}