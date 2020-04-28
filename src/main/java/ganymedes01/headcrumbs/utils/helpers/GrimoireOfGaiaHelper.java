package ganymedes01.headcrumbs.utils.helpers;

import gaia.entity.monster.EntityGaiaAnubis;
import gaia.entity.monster.EntityGaiaBanshee;
import gaia.entity.monster.EntityGaiaBaphomet;
import gaia.entity.monster.EntityGaiaCentaur;
import gaia.entity.monster.EntityGaiaCobbleGolem;
import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.entity.monster.EntityGaiaDhampir;
import gaia.entity.monster.EntityGaiaDryad;
import gaia.entity.monster.EntityGaiaDullahan;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.entity.monster.EntityGaiaEnderEye;
import gaia.entity.monster.EntityGaiaFleshLich;
import gaia.entity.monster.EntityGaiaGryphon;
import gaia.entity.monster.EntityGaiaHarpy;
import gaia.entity.monster.EntityGaiaHunter;
import gaia.entity.monster.EntityGaiaMandragora;
import gaia.entity.monster.EntityGaiaMermaid;
import gaia.entity.monster.EntityGaiaMimic;
import gaia.entity.monster.EntityGaiaMinotaur;
import gaia.entity.monster.EntityGaiaMinotaurus;
import gaia.entity.monster.EntityGaiaNaga;
import gaia.entity.monster.EntityGaiaNineTails;
import gaia.entity.monster.EntityGaiaSatyress;
import gaia.entity.monster.EntityGaiaSelkie;
import gaia.entity.monster.EntityGaiaShaman;
import gaia.entity.monster.EntityGaiaSharko;
import gaia.entity.monster.EntityGaiaSiren;
import gaia.entity.monster.EntityGaiaSludgeGirl;
import gaia.entity.monster.EntityGaiaSphinx;
import gaia.entity.monster.EntityGaiaSpriggan;
import gaia.entity.monster.EntityGaiaSuccubus;
import gaia.entity.monster.EntityGaiaValkyrie;
import gaia.entity.monster.EntityGaiaVampire;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.entity.monster.EntityGaiaWitch;
import gaia.entity.monster.EntityGaiaWitherCow;
import gaia.entity.monster.EntityGaiaYeti;
import gaia.entity.monster.EntityGaiaYukiOnna;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.AnubisHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.BansheeHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.BaphometHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.CentaurHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.CobbleGolemHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.CobblestoneGolemHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.DhampirHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.DryadHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.DullahanHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.EnderDragonGirlHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.EnderEyeHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.FleshLichHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.GoGWitchHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.GryphonHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.HarpyHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.HunterHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.MandragoraHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.MermaidHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.MimicHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.MinotaurHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.MinotaurusHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.NagaHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.NineTailsHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SatyrHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SelkieHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.ShamanHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SharkoHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SirenHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SludgeGirlHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SphinxHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SprigganHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SuccubusHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.ValkyrieHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.VampireHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.WerecatHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.WitherCowHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.YetiHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.YukiOnnaHead;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GrimoireOfGaiaHelper extends HeadDropHelper
{

	public static final String MOD_ID = "grimoireofgaia";

	public GrimoireOfGaiaHelper()
	{
		super(MOD_ID);

		super.registerMobHead("anubis", AnubisHead.INSTANCE);
		super.registerMobHead("banshee", BansheeHead.INSTANCE);
		super.registerMobHead("baphomet", BaphometHead.INSTANCE);
		super.registerMobHead("centaur", "centaur01", CentaurHead.INSTANCE);
		super.registerMobHead("cobble_golem", CobbleGolemHead.INSTANCE);
		super.registerMobHead("cobblestone_golem", CobblestoneGolemHead.INSTANCE);
		super.registerMobHead("dhampir", DhampirHead.INSTANCE);
		super.registerMobHead("dryad", "dryad01", DryadHead.INSTANCE);
		super.registerMobHead("dullahan", DullahanHead.INSTANCE);
		super.registerMobHead("ender_dragon_girl", EnderDragonGirlHead.INSTANCE);
		super.registerMobHead("ender_eye", EnderEyeHead.INSTANCE);
		super.registerMobHead("flesh_lich", FleshLichHead.INSTANCE);
		super.registerMobHead("gryphon", GryphonHead.INSTANCE);
		super.registerMobHead("harpy", "harpy01", HarpyHead.INSTANCE);
		super.registerMobHead("hunter", HunterHead.INSTANCE);
		super.registerMobHead("mandragora", MandragoraHead.INSTANCE);
		super.registerMobHead("mermaid", MermaidHead.INSTANCE);
		super.registerMobHead("mimic", MimicHead.INSTANCE);
		super.registerMobHead("minotaur", MinotaurHead.INSTANCE);
		super.registerMobHead("minotaurus", "minotaurus01", MinotaurusHead.INSTANCE);
		super.registerMobHead("naga", NagaHead.INSTANCE);
		super.registerMobHead("nine_tails", NineTailsHead.INSTANCE);
		super.registerMobHead("satyress", "satyress01", SatyrHead.INSTANCE);
		super.registerMobHead("selkie", SelkieHead.INSTANCE);
		super.registerMobHead("shaman", ShamanHead.INSTANCE);
		super.registerMobHead("sharko", SharkoHead.INSTANCE);
		super.registerMobHead("siren", SirenHead.INSTANCE);
		super.registerMobHead("sludge_girl", "sludge_girl01", SludgeGirlHead.INSTANCE);
		super.registerMobHead("sphinx", SphinxHead.INSTANCE);
		super.registerMobHead("spriggan", SprigganHead.INSTANCE);
		super.registerMobHead("succubus", SuccubusHead.INSTANCE);
		super.registerMobHead("valkyrie", ValkyrieHead.INSTANCE);
		super.registerMobHead("vampire", VampireHead.INSTANCE);
		super.registerMobHead("werecat", "werecat01", WerecatHead.INSTANCE);
		super.registerMobHead("witch", "witch01", GoGWitchHead.INSTANCE);
		super.registerMobHead("wither_cow", WitherCowHead.INSTANCE);
		super.registerMobHead("yeti", YetiHead.INSTANCE);
		super.registerMobHead("yuki-onna", YukiOnnaHead.INSTANCE);
	}
	
	@Override
	public void registerTinkersHeadDrops() {
		TConstructHelper.registerHeadDrop(EntityGaiaAnubis.class);
		TConstructHelper.registerHeadDrop(EntityGaiaBanshee.class);
		TConstructHelper.registerHeadDrop(EntityGaiaBaphomet.class);
		TConstructHelper.registerHeadDrop(EntityGaiaCentaur.class);
		TConstructHelper.registerHeadDrop(EntityGaiaCobbleGolem.class);
		TConstructHelper.registerHeadDrop(EntityGaiaCobblestoneGolem.class);
		TConstructHelper.registerHeadDrop(EntityGaiaDhampir.class);
		TConstructHelper.registerHeadDrop(EntityGaiaDryad.class);
		TConstructHelper.registerHeadDrop(EntityGaiaDullahan.class);
		TConstructHelper.registerHeadDrop(EntityGaiaEnderDragonGirl.class);
		TConstructHelper.registerHeadDrop(EntityGaiaEnderEye.class);
		TConstructHelper.registerHeadDrop(EntityGaiaFleshLich.class);
		TConstructHelper.registerHeadDrop(EntityGaiaGryphon.class);
		TConstructHelper.registerHeadDrop(EntityGaiaHarpy.class);
		TConstructHelper.registerHeadDrop(EntityGaiaHunter.class);
		TConstructHelper.registerHeadDrop(EntityGaiaMandragora.class);
		TConstructHelper.registerHeadDrop(EntityGaiaMermaid.class);
		TConstructHelper.registerHeadDrop(EntityGaiaMimic.class);
		TConstructHelper.registerHeadDrop(EntityGaiaMinotaur.class);
		TConstructHelper.registerHeadDrop(EntityGaiaMinotaurus.class);
		TConstructHelper.registerHeadDrop(EntityGaiaNaga.class);
		TConstructHelper.registerHeadDrop(EntityGaiaNineTails.class);
		TConstructHelper.registerHeadDrop(EntityGaiaSatyress.class);
		TConstructHelper.registerHeadDrop(EntityGaiaSelkie.class);
		TConstructHelper.registerHeadDrop(EntityGaiaShaman.class);
		TConstructHelper.registerHeadDrop(EntityGaiaSharko.class);
		TConstructHelper.registerHeadDrop(EntityGaiaSiren.class);
		TConstructHelper.registerHeadDrop(EntityGaiaSludgeGirl.class);
		TConstructHelper.registerHeadDrop(EntityGaiaSphinx.class);
		TConstructHelper.registerHeadDrop(EntityGaiaSpriggan.class);
		TConstructHelper.registerHeadDrop(EntityGaiaSuccubus.class);
		TConstructHelper.registerHeadDrop(EntityGaiaValkyrie.class);
		TConstructHelper.registerHeadDrop(EntityGaiaVampire.class);
		TConstructHelper.registerHeadDrop(EntityGaiaWerecat.class);
		TConstructHelper.registerHeadDrop(EntityGaiaWitch.class);
		TConstructHelper.registerHeadDrop(EntityGaiaWitherCow.class);
		TConstructHelper.registerHeadDrop(EntityGaiaYeti.class);
		TConstructHelper.registerHeadDrop(EntityGaiaYukiOnna.class);
	}

	@Override
	public ItemStack getHeadForEntity(String entityName, Entity ent)
	{
		if("bone_knight".equals(entityName))
			return new ItemStack(Items.SKULL);
		else if("creep".equals(entityName))
			return new ItemStack(Items.SKULL, 1 + ent.world.rand.nextInt(3), 4);

		return super.getHeadForEntity(entityName, ent);
	}
}