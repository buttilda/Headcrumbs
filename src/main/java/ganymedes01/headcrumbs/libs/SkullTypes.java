package ganymedes01.headcrumbs.libs;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.utils.Utils;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.common.Loader;

public enum SkullTypes {

	player(null, null),
	blaze(Strings.MC_PREFIX + "blaze"),
	enderman(Strings.MC_PREFIX + "enderman/enderman"),
	pigman(Strings.MC_PREFIX + "zombie_pigman"),
	spider(Strings.MC_PREFIX + "spider/spider"),
	caveSpider(Strings.MC_PREFIX + "spider/cave_spider"),
	pig(Strings.MC_PREFIX + "pig/pig"),
	cow(Strings.MC_PREFIX + "cow/cow"),
	mooshroom(Strings.MC_PREFIX + "cow/mooshroom"),
	sheep(Strings.MC_PREFIX + "sheep/sheep"),
	wolf(Strings.MC_PREFIX + "wolf/wolf"),
	villager(Strings.MC_PREFIX + "villager/villager"),
	chicken(Strings.MC_PREFIX + "chicken"),
	witch(Strings.MC_PREFIX + "witch"),
	zombieVillager(Strings.MC_PREFIX + "zombie/zombie_villager"),
	ironGolem(Strings.MC_PREFIX + "iron_golem"),
	squid(Strings.MC_PREFIX + "squid"),
	wither(Strings.MC_PREFIX + "wither/wither"),
	bunnyDutch(Strings.TF_PREFIX + "bunnydutch", "TwilightForest"),
	penguin(Strings.TF_PREFIX + "penguin", "TwilightForest"),
	bighorn(Strings.TF_PREFIX + "bighorn", "TwilightForest"),
	wildDeer(Strings.TF_PREFIX + "wilddeer", "TwilightForest"),
	wildBoar(Strings.TF_PREFIX + "wildboar", "TwilightForest"),
	redcap(Strings.TF_PREFIX + "redcap", "TwilightForest"),
	druid(Strings.TF_PREFIX + "skeletondruid", "TwilightForest"),
	hedgeSpider(Strings.TF_PREFIX + "hedgespider", "TwilightForest"),
	ghast(Strings.MC_PREFIX + "ghast/ghast"),
	blizz(Strings.TE_PREFIX + "Blizz", "ThermalExpansion"),
	mistWolf(Strings.TF_PREFIX + "mistwolf", "TwilightForest"),
	miniGhast(Strings.TF_PREFIX + "towerghast", "TwilightForest"),
	guardGhast(Strings.TF_PREFIX + "towerghast_openeyes", "TwilightForest"),
	kingSpider(Strings.TF_PREFIX + "kingspider", "TwilightForest"),
	kobold(Strings.TF_PREFIX + "kobold", "TwilightForest"),
	slimeBeetle(Strings.TF_PREFIX + "slimebeetle", "TwilightForest"),
	fireBeetle(Strings.TF_PREFIX + "firebeetle", "TwilightForest"),
	pinchBeetle(Strings.TF_PREFIX + "pinchbeetle", "TwilightForest"),
	towerGolem(Strings.TF_PREFIX + "carminitegolem", "TwilightForest"),
	enderDragon(Strings.MC_PREFIX + "enderdragon/dragon"),
	hostileWolf(Strings.MC_PREFIX + "wolf/wolf_angry", "TwilightForest"),
	bunnyBrown(Strings.TF_PREFIX + "bunnybrown", "TwilightForest"),
	bunnyWhite(Strings.TF_PREFIX + "bunnywhite", "TwilightForest"),
	squirrel(Strings.TF_PREFIX + "squirrel2", "TwilightForest"),
	ocelot(Strings.MC_PREFIX + "cat/ocelot"),
	ocelotBlack(Strings.MC_PREFIX + "cat/black"),
	ocelotRed(Strings.MC_PREFIX + "cat/red"),
	ocelotSiamese(Strings.MC_PREFIX + "cat/siamese"),
	bat(Strings.MC_PREFIX + "bat"),
	slime(Strings.MC_PREFIX + "slime/slime"),
	magmaCube(Strings.MC_PREFIX + "slime/magmacube"),
	horseBlack(Strings.MC_PREFIX + "horse/horse_black"),
	horseBrown(Strings.MC_PREFIX + "horse/horse_brown"),
	horseChestnut(Strings.MC_PREFIX + "horse/horse_chestnut"),
	horseCreamy(Strings.MC_PREFIX + "horse/horse_creamy"),
	horseDarkBrown(Strings.MC_PREFIX + "horse/horse_darkbrown"),
	horseGrey(Strings.MC_PREFIX + "horse/horse_gray"),
	horseWhite(Strings.MC_PREFIX + "horse/horse_white"),
	donkey(Strings.MC_PREFIX + "horse/donkey"),
	mule(Strings.MC_PREFIX + "horse/mule"),
	horseUndead(Strings.MC_PREFIX + "horse/horse_zombie"),
	horseSkeleton(Strings.MC_PREFIX + "horse/horse_skeleton");

	private final String mod;
	private final ResourceLocation texture;
	private static final ResourceLocation ENDERMAN_EYES = Utils.getResource(Strings.MC_PREFIX + "enderman/enderman_eyes.png");
	private static final ResourceLocation SHEEP_FUR_HEAD = Utils.getResource(Strings.MC_PREFIX + "sheep/sheep_fur.png");

	SkullTypes(String texture, String mod) {
		this.mod = mod;
		this.texture = Utils.getResource(texture + ".png");
	}

	SkullTypes(String texture) {
		this(texture, null);
	}

	public boolean canShow() {
		return this != player && !Headcrumbs.enableMobsAndAnimalHeads ? false : mod == null || Loader.isModLoaded(mod);
	}

	public ResourceLocation getTexture(GameProfile name) {
		if (this == player)
			return getPlayerSkin(name);
		return texture;
	}

	public ResourceLocation getSecondTexture() {
		switch (this) {
			case enderman:
				return ENDERMAN_EYES;
			case sheep:
			case bighorn:
				return SHEEP_FUR_HEAD;
			case enderDragon:
				return Utils.getResource(Strings.MC_PREFIX + "enderdragon/dragon_eyes.png");
			case mooshroom:
				return TextureMap.locationBlocksTexture;
			default:
				return null;
		}
	}

	private static final Map<String, ResourceLocation> map = new HashMap<String, ResourceLocation>();

	private ResourceLocation getPlayerSkin(GameProfile profile) {
		if (profile != null) {
			ResourceLocation texture = map.get(profile.getName());
			if (texture == null) {
				texture = AbstractClientPlayer.getLocationSkin(profile.getName());
				AbstractClientPlayer.getDownloadImageSkin(texture, profile.getName());
				map.put(profile.getName(), texture);
			}
			return texture;
		} else
			return AbstractClientPlayer.locationStevePng;
	}
}