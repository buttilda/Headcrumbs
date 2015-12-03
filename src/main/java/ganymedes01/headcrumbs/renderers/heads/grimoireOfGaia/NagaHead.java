package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

public class NagaHead extends ModelHead {

	public static final NagaHead INSTANCE = new NagaHead();

	protected NagaHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;

		hideOverlay();
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -5.0F, -3.0F, 6, 5, 7);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		ModelRenderer headnose1 = new ModelRenderer(this, 0, 12);
		headnose1.addBox(-1.0F, -4.0F, -5.0F, 2, 1, 2);
		headnose1.setTextureSize(128, 64);
		headnose1.mirror = true;
		setRotation(headnose1, 0.0F, 0.0F, 0.0F);
		ModelRenderer headnose2 = new ModelRenderer(this, 0, 15);
		headnose2.addBox(-2.0F, -3.0F, -6.0F, 4, 2, 3);
		headnose2.setTextureSize(128, 64);
		headnose2.mirror = true;
		setRotation(headnose2, 0.0F, 0.0F, 0.0F);
		ModelRenderer headjaw = new ModelRenderer(this, 0, 20);
		headjaw.addBox(-2.5F, -2.0F, -6.5F, 5, 3, 6);
		headjaw.setTextureSize(128, 64);
		headjaw.mirror = true;
		setRotation(headjaw, 0.0F, 0.0F, 0.0F);
		ModelRenderer headtendrils = new ModelRenderer(this, 0, 29);
		headtendrils.addBox(-3.0F, -1.0F, -6.5F, 6, 6, 6);
		headtendrils.setTextureSize(128, 64);
		headtendrils.mirror = true;
		setRotation(headtendrils, 0.0F, 0.0F, 0.0F);
		ModelRenderer rightfin = new ModelRenderer(this, 19, -3);
		rightfin.addBox(-3.0F, -5.0F, 0.0F, 0, 5, 3);
		rightfin.setTextureSize(128, 64);
		rightfin.mirror = true;
		setRotation(rightfin, 0.0F, -0.5235988F, 0.0F);
		ModelRenderer leftfin = new ModelRenderer(this, 19, -3);
		leftfin.addBox(3.0F, -5.0F, 0.0F, 0, 5, 3);
		leftfin.setTextureSize(128, 64);
		leftfin.mirror = true;
		setRotation(leftfin, 0.0F, 0.5235988F, 0.0F);

		head.addChild(headnose1);
		head.addChild(headnose1);
		head.addChild(headnose2);
		head.addChild(headjaw);
		head.addChild(headtendrils);
		head.addChild(rightfin);
		head.addChild(leftfin);
	}

	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		GL11.glTranslatef(0, 0.35F, 0);
	}
}