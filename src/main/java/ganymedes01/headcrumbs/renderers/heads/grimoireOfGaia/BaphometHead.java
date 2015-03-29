package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class BaphometHead extends ModelHead {

	public static final BaphometHead INSTANCE = new BaphometHead();

	protected BaphometHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer headsides = new ModelRenderer(this, 36, 26);
		headsides.addBox(-4.5F, -6.5F, -3.0F, 9, 6, 6);
		headsides.setTextureSize(64, 32);
		headsides.mirror = true;
		setRotation(headsides, 0.0F, 0.0F, 0.0F);
		ModelRenderer headhorns = new ModelRenderer(this, 36, 38);
		headhorns.addBox(-3.0F, -9.0F, -1.0F, 6, 3, 6);
		headhorns.setTextureSize(64, 32);
		headhorns.mirror = true;
		setRotation(headhorns, 0.0F, 0.0F, 0.0F);
		ModelRenderer hair = new ModelRenderer(this, 36, 14);
		hair.addBox(-5.0F, -5.5F, 2.5F, 10, 10, 2);
		hair.setTextureSize(64, 32);
		hair.mirror = true;
		setRotation(hair, 0.0F, 0.0F, 0.0F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 43);
		rightear.addBox(-4.0F, -5.0F, -1.0F, 0, 4, 4);
		rightear.setTextureSize(64, 32);
		rightear.mirror = true;
		setRotation(rightear, 0.0F, -0.5235988F, 0.0F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 43);
		leftear.addBox(4.0F, -5.0F, -1.0F, 0, 4, 4);
		leftear.setTextureSize(64, 32);
		leftear.mirror = true;
		setRotation(leftear, 0.0F, 0.5235988F, 0.0F);

		head.addChild(headsides);
		head.addChild(headhorns);
		head.addChild(hair);
		head.addChild(rightear);
		head.addChild(leftear);
	}
}