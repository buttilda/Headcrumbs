package ganymedes01.headcrumbs.renderers;

import java.util.List;

import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;

import ganymedes01.headcrumbs.libs.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;

/**
 * Created by TheGreyGhost on 19/04/2015. This class is used to customise the
 * rendering of the camouflage block, based on the block it is copying.
 */
public class SkullItemBakedModel implements IBakedModel {

	public static final ModelResourceLocation RES_LOC = new ModelResourceLocation(Reference.MOD_ID + ":skull", "inventory");
	private final IBakedModel internal;

	public SkullItemBakedModel(IBakedModel internal) {
		this.internal = internal;
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		return internal.getQuads(state, side, rand);
	}

	@Override
	public boolean isAmbientOcclusion() {
		return internal.isAmbientOcclusion();
	}

	@Override
	public boolean isGui3d() {
		return internal.isGui3d();
	}

	public IBakedModel getInternal() {
		return internal;
	}

	@Override
	public boolean isBuiltInRenderer() {
		return true;
	}

	@Override
	public TextureAtlasSprite getParticleTexture() {
		return internal.getParticleTexture();
	}

	@Override
	public ItemOverrideList getOverrides() {
		return internal.getOverrides();
	}

	@Override
	public Pair<? extends IBakedModel, Matrix4f> handlePerspective(TransformType cameraTransformType) {
		// You can use a field on your TileEntityItemStackRenderer to store this
		// TransformType for use in renderByItem, this method is always called before
		// it.
		return Pair.of(this, internal.handlePerspective(cameraTransformType).getRight());
	}

}