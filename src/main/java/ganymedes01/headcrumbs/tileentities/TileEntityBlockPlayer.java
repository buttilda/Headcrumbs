package ganymedes01.headcrumbs.tileentities;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.entity.EntityHuman;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityBlockPlayer extends TileEntitySkull {

	@SideOnly(Side.CLIENT)
	private EntityHuman human;

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(getPos().add(-1, -1, -1), getPos().add(2, 3, 2));
	}

	@SideOnly(Side.CLIENT)
	public EntityHuman getHuman() {
		GameProfile profile = getPlayerProfile();

		if (profile == null) {
			human = null;
			return null;
		}
		if (human == null) {
			human = new EntityHuman(world) {
				@Override
				public double getInterpolatedCapeX(float partialTickTime) {
					return 0;
				}

				@Override
				public double getInterpolatedCapeY(float partialTickTime) {
					return 0;
				}

				@Override
				public double getInterpolatedCapeZ(float partialTickTime) {
					return 0;
				}
			};
			human.setProfile(profile);
		}
		return human;
	}

	@Override
	public boolean canRenderBreaking() {
		return false;
	}
}