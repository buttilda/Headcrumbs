package ganymedes01.headcrumbs.libs;

public class Reference {

	public static final String MOD_ID = "headcrumbs";
	public static final String MOD_NAME = "Headcrumbs";
	public static final String DEPENDENCIES = "required-after:Forge@[12.17.0.1954,);";
	public static final String VERSION_NUMBER = "2.0.1";

	public static final String ITEM_BLOCK_TEXTURE_PATH = MOD_ID + ":";
	public static final String ENTITY_TEXTURE_PATH = ITEM_BLOCK_TEXTURE_PATH + "textures/entities/";

	public static final String CLIENT_PROXY_CLASS = "ganymedes01." + MOD_ID + ".proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "ganymedes01." + MOD_ID + ".proxy.CommonProxy";

	public static final String GUI_FACTORY_CLASS = "ganymedes01.headcrumbs.configs.ConfigGuiFactory";
}