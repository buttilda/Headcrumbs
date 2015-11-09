package ganymedes01.headcrumbs.blocks;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import ganymedes01.headcrumbs.utils.HeadUtils;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import thaumcraft.api.crafting.IInfusionStabiliser;

@Optional.Interface(iface = "thaumcraft.api.crafting.IInfusionStabiliser", modid = "Thaumcraft")
public class BlockSkull extends BlockContainer implements IInfusionStabiliser {

	public BlockSkull() {
		this(Material.circuits);
		setBlockName(Utils.getUnlocalisedName("betterSkull"));
	}

	protected BlockSkull(Material material) {
		super(material);
		setHardness(1.0F);
		setStepSound(soundTypePiston);
	}

	@Override
	@Optional.Method(modid = "Thaumcraft")
	public boolean canStabaliseInfusion(World world, int x, int y, int z) {
		return true;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess access, int x, int y, int z) {
		int meta = access.getBlockMetadata(x, y, z) & 7;
		switch (meta) {
			case 1:
			default:
				setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
				break;
			case 2:
				setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
				break;
			case 3:
				setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
				break;
			case 4:
				setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
				break;
			case 5:
				setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		setBlockBoundsBasedOnState(world, x, y, z);
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		world.setBlockMetadataWithNotify(x, y, z, MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 2.5D) & 3, 2);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBlockSkull();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return ModItems.skull;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
		Item item = getItem(world, x, y, z);

		if (item == null)
			return null;

		ItemStack stack = new ItemStack(item, 1, getDamageValue(world, x, y, z));
		TileEntityBlockSkull tile = Utils.getTileEntity(world, x, y, z, TileEntityBlockSkull.class);
		if (tile != null)
			if ((tile.func_145904_a() == SkullTypes.player.ordinal() || tile.func_145904_a() == SkullTypes.lycanites.ordinal()) && tile.func_152108_a() != null) {
				stack = HeadUtils.createHeadFor(tile.func_152108_a());
				stack.setItemDamage(tile.func_145904_a());
			}

		return stack;
	}

	@Override
	public int getDamageValue(World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		return tile != null && tile instanceof TileEntityBlockSkull ? ((TileEntityBlockSkull) tile).func_145904_a() : super.getDamageValue(world, x, y, z);
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!player.capabilities.isCreativeMode) {
			ArrayList<ItemStack> drops = getDrops(world, x, y, z, meta, 0);
			if (ForgeEventFactory.fireBlockHarvesting(drops, world, this, x, y, z, meta, 0, 1.0F, false, player) > 0.0F)
				for (ItemStack stack : drops)
					Utils.dropStack(world, x, y, z, stack);
		}
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

		TileEntityBlockSkull tile = Utils.getTileEntity(world, x, y, z, TileEntityBlockSkull.class);
		if (tile == null)
			return drops;

		ItemStack stack = new ItemStack(ModItems.skull, 1, tile.func_145904_a());

		if ((tile.func_145904_a() == SkullTypes.player.ordinal() || tile.func_145904_a() == SkullTypes.lycanites.ordinal()) && tile.func_152108_a() != null) {
			stack = HeadUtils.createHeadFor(tile.func_152108_a());
			stack.setItemDamage(tile.func_145904_a());
		}

		drops.add(stack);

		return drops;
	}

	@Override
	public int quantityDropped(Random rand) {
		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return Blocks.soul_sand.getBlockTextureFromSide(side);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getItemIconName() {
		return Blocks.skull.getItemIconName();
	}
}