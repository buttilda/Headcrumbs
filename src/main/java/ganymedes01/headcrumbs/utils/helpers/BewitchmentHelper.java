package ganymedes01.headcrumbs.utils.helpers;

import com.bewitchment.common.entity.living.EntityLizard;
import com.bewitchment.common.entity.living.EntityOwl;
import com.bewitchment.common.entity.living.EntityRaven;
import com.bewitchment.common.entity.living.EntitySnake;
import com.bewitchment.common.entity.living.EntityToad;
import com.bewitchment.common.entity.living.EntityWerewolf;
import com.bewitchment.common.entity.spirit.demon.EntityBafometyr;
import com.bewitchment.common.entity.spirit.demon.EntityBaphomet;
import com.bewitchment.common.entity.spirit.demon.EntityCambion;
import com.bewitchment.common.entity.spirit.demon.EntityCleaver;
import com.bewitchment.common.entity.spirit.demon.EntityDemon;
import com.bewitchment.common.entity.spirit.demon.EntityDemoness;
import com.bewitchment.common.entity.spirit.demon.EntityDruden;
import com.bewitchment.common.entity.spirit.demon.EntityFeuerwurm;
import com.bewitchment.common.entity.spirit.demon.EntityHellhound;
import com.bewitchment.common.entity.spirit.demon.EntityImp;
import com.bewitchment.common.entity.spirit.demon.EntityLeonard;
import com.bewitchment.common.entity.spirit.demon.EntityShadowPerson;
import com.bewitchment.common.entity.spirit.ghost.EntityBlackDog;
import com.bewitchment.common.entity.spirit.ghost.EntityGhost;

import ganymedes01.headcrumbs.libs.HeadDrop;
import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.living.LizardHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.living.OwlHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.living.RavenHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.living.SnakeHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.living.ToadHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.living.WerewolfHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.BafometyrHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.BaphometHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.CambionHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.CleaverHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.DemonHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.DemonessHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.DrudenHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.FeuerwurmHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.HellhoundHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.ImpHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.LeonardHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.ShadowPersonClassicHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.ghost.BlackDogHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.ghost.GhostHead;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class BewitchmentHelper extends HeadDropHelper{
	
	public static final String MOD_ID = "bewitchment";
	
	public BewitchmentHelper() {
		super(MOD_ID);
		
		//living
		super.registerMobHead("lizard", "lizard_0", LizardHead.INSTANCE);
		super.registerMobHead("owl", "owl_0", OwlHead.INSTANCE);
		super.registerMobHead("raven", RavenHead.INSTANCE);
		super.registerMobHead("snake", "snake_0", SnakeHead.INSTANCE);
		super.registerMobHead("toad", "toad_0", ToadHead.INSTANCE);
		super.registerMobHead("werewolf", "werewolf/werewolf_brown", WerewolfHead.INSTANCE);
		
		//demon
		super.registerMobHead("bafometyr", BafometyrHead.INSTANCE);
		super.registerMobHead("baphomet", BaphometHead.INSTANCE);
		super.registerMobHead("cambion", "cambion_0", CambionHead.INSTANCE);
		super.registerMobHead("cleaver", CleaverHead.INSTANCE);
		super.registerMobHead("demoness", "demoness_0", DemonessHead.INSTANCE);
		super.registerMobHead("demon", "demon_0", DemonHead.INSTANCE);
		super.registerMobHead("druden", "drude_3", DrudenHead.INSTANCE);
		super.registerMobHead("feuerwurm", "feuerwurm_0", FeuerwurmHead.INSTANCE);
		super.registerMobHead("hellhound", "hellhound_0", HellhoundHead.INSTANCE);
		super.registerMobHead("imp", "imp_0", ImpHead.INSTANCE);
		super.registerMobHead("leonard", LeonardHead.INSTANCE);
		super.registerMobHead("shadow_person", "shadowperson", ShadowPersonClassicHead.INSTANCE);
		
		//ghost
		super.registerMobHead("black_dog", "black_dog_0", BlackDogHead.INSTANCE);
		super.registerMobHead("ghost", "ghost_1", GhostHead.INSTANCE);
	}
	
	@Override
	public String getTextureLocBase() {
		return Strings.BW_PREFIX;
	}
	
	@Override
	public ItemStack getHeadForEntity(String entityName, Entity ent) {
		
		System.out.println(ent);
		System.out.println(ent.getDataManager());
		return super.getHeadForEntity(entityName, ent);
	}
	
	@Override
	public HeadDrop getHeadDropForEntity(String entityName) {
		
		return super.getHeadDropForEntity(entityName);
	}
	
	@Override
	public void registerTinkersHeadDrops() {
		TConstructHelper.registerHeadDrop(EntityLizard.class);
		TConstructHelper.registerHeadDrop(EntityOwl.class);
		TConstructHelper.registerHeadDrop(EntityRaven.class);
		TConstructHelper.registerHeadDrop(EntitySnake.class);
		TConstructHelper.registerHeadDrop(EntityToad.class);
		TConstructHelper.registerHeadDrop(EntityWerewolf.class);
		TConstructHelper.registerHeadDrop(EntityBafometyr.class);
		TConstructHelper.registerHeadDrop(EntityBaphomet.class);
		TConstructHelper.registerHeadDrop(EntityCambion.class);
		TConstructHelper.registerHeadDrop(EntityCleaver.class);
		TConstructHelper.registerHeadDrop(EntityDemoness.class);
		TConstructHelper.registerHeadDrop(EntityDemon.class);
		TConstructHelper.registerHeadDrop(EntityDruden.class);
		TConstructHelper.registerHeadDrop(EntityFeuerwurm.class);
		TConstructHelper.registerHeadDrop(EntityHellhound.class);
		TConstructHelper.registerHeadDrop(EntityImp.class);
		TConstructHelper.registerHeadDrop(EntityLeonard.class);
		TConstructHelper.registerHeadDrop(EntityShadowPerson.class);
		TConstructHelper.registerHeadDrop(EntityBlackDog.class);
		TConstructHelper.registerHeadDrop(EntityGhost.class);
	}

}
