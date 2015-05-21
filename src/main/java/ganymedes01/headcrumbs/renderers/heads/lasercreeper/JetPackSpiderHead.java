package ganymedes01.headcrumbs.renderers.heads.lasercreeper;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class JetPackSpiderHead extends ModelHead {

	public static final JetPackSpiderHead INSTANCE = new JetPackSpiderHead();

	protected JetPackSpiderHead() {
	}

	@Override
	public void init() {
		textureWidth = 64;
		textureHeight = 128;
		float f0 = 4;
		float f1 = -4;

		head = new ModelRenderer(this, 32, 4);
		head.addBox(-4F, -4F + f1, -8F + f0, 8, 8, 8);
		overlay = new ModelRenderer(this, 0, 68);
		overlay.addBox(-5F, 2F + f1, -11F + f0, 10, 2, 10);

		ModelRenderer jawFront = new ModelRenderer(this, 35, 63);
		jawFront.addBox(-4F, 2F + f1, -12F + f0, 8, 2, 1);
		ModelRenderer rightToothBot = new ModelRenderer(this, 23, 63);
		rightToothBot.addBox(-5F, 0F + f1, -10F + f0, 1, 2, 2);
		ModelRenderer rightToothTop = new ModelRenderer(this, 30, 63);
		rightToothTop.addBox(-5F, -1F + f1, -9.5F + f0, 1, 1, 1);
		ModelRenderer frontRToothBot = new ModelRenderer(this, 23, 63);
		frontRToothBot.addBox(-3F, 0F + f1, -11F + f0, 2, 2, 1);
		ModelRenderer frontRToothTop = new ModelRenderer(this, 30, 63);
		frontRToothTop.addBox(-2.5F, -1F + f1, -11F + f0, 1, 1, 1);
		ModelRenderer frontLToothBot = new ModelRenderer(this, 23, 63);
		frontLToothBot.addBox(1F, 0F + f1, -11F + f0, 2, 2, 1);
		ModelRenderer frontLToothTop = new ModelRenderer(this, 30, 63);
		frontLToothTop.addBox(1.5F, -1F + f1, -11F + f0, 1, 1, 1);
		ModelRenderer leftToothBot = new ModelRenderer(this, 23, 63);
		leftToothBot.addBox(4F, 0F + f1, -10F + f0, 1, 2, 2);
		ModelRenderer leftToothTop = new ModelRenderer(this, 30, 63);
		leftToothTop.addBox(4F, -1F + f1, -9.5F + f0, 1, 1, 1);
		ModelRenderer visorMain = new ModelRenderer(this, 0, 63);
		visorMain.addBox(-5F, -2F + f1, -9F + f0, 10, 3, 1);
		ModelRenderer visorRight = new ModelRenderer(this, 41, 68);
		visorRight.addBox(-5F, -2F + f1, -8F + f0, 1, 3, 2);
		ModelRenderer visorLeft = new ModelRenderer(this, 48, 68);
		visorLeft.addBox(4F, -2F + f1, -8F + f0, 1, 3, 2);

		head.addChild(visorMain);
		head.addChild(visorRight);
		head.addChild(visorLeft);
		overlay.addChild(jawFront);
		overlay.addChild(rightToothBot);
		overlay.addChild(rightToothTop);
		overlay.addChild(frontRToothBot);
		overlay.addChild(frontRToothTop);
		overlay.addChild(frontLToothBot);
		overlay.addChild(frontLToothTop);
		overlay.addChild(leftToothBot);
		overlay.addChild(leftToothTop);
	}
}