package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.renderers.ModelHead;

public class ElementalCreepersHelper extends HeadDropHelper
{

	public static final String MOD_ID = "elementalcreepers";

	public ElementalCreepersHelper()
	{
		super(MOD_ID);

		super.registerMobHead("cakecreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("cookiecreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("darkcreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("earthcreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("endercreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("eucreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("firecreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("fireworkcreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("friendlycreeper", "friendlycreeper0", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("furnacecreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("hydrogencreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("icecreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("illusioncreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("lightcreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("lightningcreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("magmacreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("psychiccreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("reversecreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("rfcreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("sandstonecreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("spidercreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("springcreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("stonecreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("warpcreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("windcreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("watercreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("zombiecreeper", ModelHead.INSTANCE_NO_OVERLAY);
	}

	@Override
	public String getTextureLocBase()
	{
		return modID + ":textures/entities/";
	}
}