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
import com.bewitchment.common.entity.util.ModEntityAnimal;
import com.bewitchment.common.entity.util.ModEntityMob;
import com.bewitchment.common.entity.util.ModEntityTameable;

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
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.CambionSlimHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.CleaverHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.DemonHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.DemonessHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.DrudenHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.FeuerwurmHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.HellhoundHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.ImpHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.LeonardHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.ShadowPersonClassicHead;
import ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon.ShadowPersonSlimHead;
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
		super.registerMobHead("lizard_1", "lizard_1", LizardHead.INSTANCE);
		super.registerMobHead("lizard_2", "lizard_2", LizardHead.INSTANCE);
		super.registerMobHead("lizard_3", "lizard_3", LizardHead.INSTANCE);
		
		super.registerMobHead("owl", "owl_0", OwlHead.INSTANCE);
		super.registerMobHead("owl_1", "owl_1", OwlHead.INSTANCE);
		super.registerMobHead("owl_2", "owl_2", OwlHead.INSTANCE);
		super.registerMobHead("owl_3", "owl_3", OwlHead.INSTANCE);
		
		super.registerMobHead("raven", RavenHead.INSTANCE);
		
		super.registerMobHead("snake", "snake_0", SnakeHead.INSTANCE);
		super.registerMobHead("snake_1", "snake_1", SnakeHead.INSTANCE);
		super.registerMobHead("snake_2", "snake_2", SnakeHead.INSTANCE);
		super.registerMobHead("snake_3", "snake_3", SnakeHead.INSTANCE);
		super.registerMobHead("snake_4", "snake_4", SnakeHead.INSTANCE);
		super.registerMobHead("snake_5", "snake_5", SnakeHead.INSTANCE);
		
		super.registerMobHead("toad", "toad_0", ToadHead.INSTANCE);
		super.registerMobHead("toad_1", "toad_1", ToadHead.INSTANCE);
		super.registerMobHead("toad_2", "toad_2", ToadHead.INSTANCE);
		super.registerMobHead("toad_3", "toad_3", ToadHead.INSTANCE);
		
		super.registerMobHead("werewolf", "werewolf/werewolf_brown", WerewolfHead.INSTANCE);
		super.registerMobHead("werewolf_1", "werewolf/werewolf_arctic", WerewolfHead.INSTANCE);
		super.registerMobHead("werewolf_2", "werewolf/werewolf_black", WerewolfHead.INSTANCE);
		super.registerMobHead("werewolf_3", "werewolf/werewolf_red", WerewolfHead.INSTANCE);
		super.registerMobHead("werewolf_4", "werewolf/werewolf_timber", WerewolfHead.INSTANCE);
		super.registerMobHead("werewolf_5", "werewolf/werewolf_grey", WerewolfHead.INSTANCE);
		
		//demons
		super.registerMobHead("bafometyr", BafometyrHead.INSTANCE);
		super.registerMobHead("baphomet", BaphometHead.INSTANCE);
		
		super.registerMobHead("cambion", "cambion_0", CambionHead.INSTANCE);
		super.registerMobHead("cambion_1", "cambion_1", CambionHead.INSTANCE);
		super.registerMobHead("cambion_2", "cambion_2", CambionSlimHead.INSTANCE);
		super.registerMobHead("cambion_3", "cambion_3", CambionSlimHead.INSTANCE);
		
		super.registerMobHead("cleaver", CleaverHead.INSTANCE);
		
		super.registerMobHead("demoness", "demoness_0", DemonessHead.INSTANCE);
		super.registerMobHead("demoness_1", "demoness_1", DemonessHead.INSTANCE);
		super.registerMobHead("demoness_2", "demoness_2", DemonessHead.INSTANCE);
		super.registerMobHead("demoness_3", "demoness_3", DemonessHead.INSTANCE);
		
		super.registerMobHead("demon", "demon_0", DemonHead.INSTANCE);
		super.registerMobHead("demon_1", "demon_1", DemonHead.INSTANCE);
		super.registerMobHead("demon_2", "demon_2", DemonHead.INSTANCE);
		super.registerMobHead("demon_3", "demon_3", DemonHead.INSTANCE);
		
		super.registerMobHead("druden", "drude_0", DrudenHead.INSTANCE);
		super.registerMobHead("druden_1", "drude_1", DrudenHead.INSTANCE);
		super.registerMobHead("druden_2", "drude_2", DrudenHead.INSTANCE);
		super.registerMobHead("druden_3", "drude_3", DrudenHead.INSTANCE);

		super.registerMobHead("feuerwurm", "feuerwurm_0", FeuerwurmHead.INSTANCE);
		super.registerMobHead("feuerwurm_1", "feuerwurm_1", FeuerwurmHead.INSTANCE);
		super.registerMobHead("feuerwurm_2", "feuerwurm_2", FeuerwurmHead.INSTANCE);
		super.registerMobHead("feuerwurm_3", "feuerwurm_3", FeuerwurmHead.INSTANCE);
		super.registerMobHead("feuerwurm_4", "feuerwurm_4", FeuerwurmHead.INSTANCE);
		super.registerMobHead("feuerwurm_5", "feuerwurm_5", FeuerwurmHead.INSTANCE);
		super.registerMobHead("feuerwurm_6", "feuerwurm_6", FeuerwurmHead.INSTANCE);
		super.registerMobHead("feuerwurm_7", "feuerwurm_7", FeuerwurmHead.INSTANCE);
		super.registerMobHead("feuerwurm_8", "feuerwurm_8", FeuerwurmHead.INSTANCE);
		
		super.registerMobHead("hellhound", "hellhound_0", HellhoundHead.INSTANCE);
		super.registerMobHead("hellhound_1", "hellhound_1", HellhoundHead.INSTANCE);
		super.registerMobHead("hellhound_2", "hellhound_2", HellhoundHead.INSTANCE);
		super.registerMobHead("hellhound_3", "hellhound_3", HellhoundHead.INSTANCE);
		
		super.registerMobHead("imp", "imp_0", ImpHead.INSTANCE);
		super.registerMobHead("imp_1", "imp_1", ImpHead.INSTANCE);
		super.registerMobHead("imp_2", "imp_2", ImpHead.INSTANCE);
		super.registerMobHead("imp_3", "imp_3", ImpHead.INSTANCE);
		super.registerMobHead("imp_4", "imp_4", ImpHead.INSTANCE);
		super.registerMobHead("imp_5", "imp_5", ImpHead.INSTANCE);
		super.registerMobHead("imp_6", "imp_6", ImpHead.INSTANCE);
		
		super.registerMobHead("leonard", LeonardHead.INSTANCE);
		
		super.registerMobHead("shadow_person", "shadowperson", ShadowPersonClassicHead.INSTANCE);
		super.registerMobHead("shadow_person_1", "shadowperson_hatdemon", ShadowPersonClassicHead.INSTANCE);
		super.registerMobHead("shadow_person_2", "shadowperson", ShadowPersonSlimHead.INSTANCE);
		super.registerMobHead("shadow_person_3", "shadowperson_hatdemon", ShadowPersonSlimHead.INSTANCE);
		
		//ghosts
		super.registerMobHead("black_dog", "black_dog_0", BlackDogHead.INSTANCE);
		super.registerMobHead("black_dog_1", "black_dog_1", BlackDogHead.INSTANCE);
		super.registerMobHead("black_dog_2", "black_dog_2", BlackDogHead.INSTANCE);
		super.registerMobHead("black_dog_3", "black_dog_3", BlackDogHead.INSTANCE);
		super.registerMobHead("black_dog_4", "black_dog_4", BlackDogHead.INSTANCE);
		
		super.registerMobHead("ghost", "ghost_1", GhostHead.INSTANCE);
		super.registerMobHead("ghost_1", "ghost_2", GhostHead.INSTANCE);
		super.registerMobHead("ghost_2", "ghost_3", GhostHead.INSTANCE);
		super.registerMobHead("ghost_3", "ghost_4", GhostHead.INSTANCE);
		super.registerMobHead("ghost_4", "ghost_5", GhostHead.INSTANCE);
	}
	
	@Override
	public String getTextureLocBase() {
		return Strings.BW_PREFIX;
	}
	
	@Override
	public ItemStack getHeadForEntity(String entityName, Entity ent) {
		
		String id = "";
		
		if (ent instanceof EntityLizard) {
			id = ent.getDataManager().get(ModEntityAnimal.SKIN).toString();
			
		} else if (ent instanceof EntityOwl || ent instanceof EntitySnake 
				|| ent instanceof EntityToad) {
			id = ent.getDataManager().get(ModEntityTameable.SKIN).toString();
			
		} else if (ent instanceof EntityWerewolf) {
			id = String.valueOf(((EntityWerewolf)ent).getWerewolfType());
			
		
		} else if (ent instanceof EntityCambion) {
			id = String.valueOf(((EntityCambion)ent).getCambionType());
			
		} else if (ent instanceof EntityDemoness || ent instanceof EntityDemon 
				|| ent instanceof EntityDruden || ent instanceof EntityFeuerwurm
				|| ent instanceof EntityHellhound || ent instanceof EntityImp
				|| ent instanceof EntityShadowPerson || ent instanceof EntityBlackDog) {
			id = ent.getDataManager().get(ModEntityMob.SKIN).toString();
			
		}
		
		if (!id.isEmpty() && !id.equals("0")) {
			entityName = entityName.concat("_" + id);
		}
		
		return super.getHeadForEntity(entityName, ent);
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
