package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.renderers.heads.BatHead;
import ganymedes01.headcrumbs.renderers.heads.SlimeHead;
import ganymedes01.headcrumbs.renderers.heads.WitherHead;
import ganymedes01.headcrumbs.renderers.heads.thaumcraft.EldrichGuardianHead;
import ganymedes01.headcrumbs.renderers.heads.thaumcraft.PechHead;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import thaumcraft.common.entities.monster.EntityBrainyZombie;
import thaumcraft.common.entities.monster.EntityEldritchCrab;
import thaumcraft.common.entities.monster.EntityEldritchGuardian;
import thaumcraft.common.entities.monster.EntityFireBat;
import thaumcraft.common.entities.monster.EntityGiantBrainyZombie;
import thaumcraft.common.entities.monster.EntityPech;
import thaumcraft.common.entities.monster.EntityThaumicSlime;
import thaumcraft.common.entities.monster.cult.EntityCultistCleric;
import thaumcraft.common.entities.monster.cult.EntityCultistKnight;

public class ThaumcraftHelper extends HeadDropHelper
{
	public static final String MOD_ID = "thaumcraft";

	public ThaumcraftHelper()
	{
		super(MOD_ID);

		super.registerMobHead("BrainyZombie", "bzombievil", WitherHead.INSTANCE);
		super.registerMobHead("giantbrainyzombie", "bzombievil", WitherHead.INSTANCE);
		super.registerMobHead("firebat", BatHead.INSTANCE);
		super.registerMobHead("tslime", SlimeHead.INSTANCE);
		super.registerMobHead("pech", "pech_forage", PechHead.INSTANCE);
		super.registerMobHead("eldritchguardian", "eldritch_guardian", EldrichGuardianHead.INSTANCE);
		super.registerMobHead("cultistknight", "cultist", EldrichGuardianHead.INSTANCE);
		super.registerMobHead("cultistcleric", "cultist", EldrichGuardianHead.INSTANCE);
		super.registerMobHead("eldritchcrab", "crab", EldrichGuardianHead.INSTANCE);

		if(Loader.isModLoaded(MOD_ID))
			addAspects();
	}

	@Override
	public void registerTinkersHeadDrops() {
		TConstructHelper.registerHeadDrop(EntityBrainyZombie.class);
		TConstructHelper.registerHeadDrop(EntityGiantBrainyZombie.class);
		TConstructHelper.registerHeadDrop(EntityFireBat.class);
		TConstructHelper.registerHeadDrop(EntityThaumicSlime.class);
		TConstructHelper.registerHeadDrop(EntityPech.class);
		TConstructHelper.registerHeadDrop(EntityEldritchGuardian.class);
		TConstructHelper.registerHeadDrop(EntityCultistKnight.class);
		TConstructHelper.registerHeadDrop(EntityCultistCleric.class);
		TConstructHelper.registerHeadDrop(EntityEldritchCrab.class);
	}
	
	@Optional.Method(modid = MOD_ID)
	private void addAspects()
	{
		//		AspectList aspects = new AspectList().add(Aspect.MAN, 4).add(Aspect.DEATH, 4).add(Aspect.SOUL, 4);
		//		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.player, 1, OreDictionary.WILDCARD_VALUE), aspects);
		//		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.skull, 1, OreDictionary.WILDCARD_VALUE), aspects);
	}

	@Override
	public ItemStack getHeadForEntity(String entityName, Entity ent)
	{
		ItemStack head = super.getHeadForEntity(entityName, ent);
		if(head != null)
			return head;

		//if(getThaumicSlimeSize(ent) == 1)
		//return this.getHeadForEntity("tslime");

		return null;
	}
}