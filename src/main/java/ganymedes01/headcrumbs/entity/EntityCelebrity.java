package ganymedes01.headcrumbs.entity;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.utils.UsernameUtils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IIcon;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import org.apache.commons.lang3.StringUtils;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityCelebrity extends EntityMob implements IRangedAttackMob {

	// Cape related variables. Copied from EntityPlayer
	public double field_71091_bM;
	public double field_71096_bN;
	public double field_71097_bO;
	public double field_71094_bP;
	public double field_71095_bQ;
	public double field_71085_bR;

	// Baby zombie stuff
	private static final AttributeModifier babySpeedBoostModifier = new AttributeModifier(UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836"), "Baby speed boost", 0.5D, 1);

	private final EntityAIArrowAttack arrowAI = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
	private static final int NAME = 13;
	private static final int CHILD = 14;
	private static final int WIDTH = 15;
	private static final int HEIGHT = 16;

	public EntityCelebrity(World world) {
		super(world);
		getNavigator().setBreakDoors(true);
		tasks.addTask(0, new EntityAISwimming(this));
		if (Headcrumbs.celebrityOpensDoors && world.difficultySetting == EnumDifficulty.HARD)
			tasks.addTask(1, new EntityAIOpenDoor(this, true));
		tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
		tasks.addTask(7, new EntityAIWander(this, 1.0D));
		tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(8, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		setSize(0.6F, 1.8F);
	}

	@Override
	protected boolean isAIEnabled() {
		return true;
	}

	@Override
	public boolean canPickUpLoot() {
		return true;
	}

	@Override
	public void onUpdate() {
		field_71091_bM = field_71094_bP;
		field_71096_bN = field_71095_bQ;
		field_71097_bO = field_71085_bR;
		double d3 = posX - field_71094_bP;
		double d0 = posY - field_71095_bQ;
		double d1 = posZ - field_71085_bR;
		double d2 = 10.0D;

		if (d3 > d2)
			field_71091_bM = field_71094_bP = posX;
		if (d1 > d2)
			field_71097_bO = field_71085_bR = posZ;
		if (d0 > d2)
			field_71096_bN = field_71095_bQ = posY;
		if (d3 < -d2)
			field_71091_bM = field_71094_bP = posX;
		if (d1 < -d2)
			field_71097_bO = field_71085_bR = posZ;
		if (d0 < -d2)
			field_71096_bN = field_71095_bQ = posY;

		field_71094_bP += d3 * 0.25D;
		field_71085_bR += d1 * 0.25D;
		field_71095_bQ += d0 * 0.25D;

		if (worldObj.isRemote) {
			float w = dataWatcher.getWatchableObjectFloat(WIDTH);
			if (w != width)
				width = w;
			float h = dataWatcher.getWatchableObjectFloat(HEIGHT);
			if (h != height)
				height = h;
		}

		super.onUpdate();
	}

	/* ENTITY INIT */

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		getDataWatcher().addObject(NAME, "");
		getDataWatcher().addObject(CHILD, (byte) 0);
		getDataWatcher().addObject(WIDTH, width);
		getDataWatcher().addObject(HEIGHT, height);
	}

	/* SOUNDS */

	@Override
	protected String getLivingSound() {
		return getVIPHandler().livingSound();
	}

	@Override
	protected String getHurtSound() {
		return getVIPHandler().hurtSound();
	}

	@Override
	protected String getDeathSound() {
		return getVIPHandler().deathSound();
	}

	/* DROPS */

	@Override
	protected void dropFewItems(boolean recentHit, int looting) {
		getVIPHandler().dropItems(this, looting);
	}

	@Override
	protected void dropRareDrop(int looting) {
		getVIPHandler().dropRare(this, looting);
	}

	/* EQUIPAMENT AND ITEMS */

	@Override
	protected void addRandomArmor() {
		super.addRandomArmor();

		if (rand.nextFloat() < (worldObj.difficultySetting == EnumDifficulty.HARD ? 0.1F : 0.05F)) {
			int i = rand.nextInt(3);

			if (i == 0)
				setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
			else if (i == 1)
				setCurrentItemOrArmor(0, new ItemStack(Items.bow));
		}
	}

	@Override
	public void setCurrentItemOrArmor(int slot, ItemStack stack) {
		super.setCurrentItemOrArmor(slot, stack);
		setCombatAI();
	}

	/* SPAWN AND DESPAWN */

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		setUsername(getRandomUsername());
		addRandomArmor();
		enchantEquipment();
		setCombatAI();

		float f = worldObj.func_147462_b(posX, posY, posZ);
		getEntityAttribute(SharedMonsterAttributes.knockbackResistance).applyModifier(new AttributeModifier("Knockback Resistance Bonus", rand.nextDouble() * 0.05, 0));
		double d0 = rand.nextDouble() * 1.5 * f;

		if (d0 > 1.0)
			getEntityAttribute(SharedMonsterAttributes.followRange).applyModifier(new AttributeModifier("Range Bonus", d0, 2));

		if (rand.nextFloat() < f * 0.05F)
			getEntityAttribute(SharedMonsterAttributes.maxHealth).applyModifier(new AttributeModifier("Health Bonus", rand.nextDouble() * 3.0 + 1.0, 2));

		if (rand.nextFloat() < f * 0.15F)
			getEntityAttribute(SharedMonsterAttributes.attackDamage).applyModifier(new AttributeModifier("Damage Bonus", rand.nextDouble() + 0.5, 2));

		if (rand.nextFloat() < f * 0.2F)
			getEntityAttribute(SharedMonsterAttributes.movementSpeed).applyModifier(new AttributeModifier("Speed Bonus", rand.nextDouble() * 2.0 * 0.24 + 0.01, 2));

		if (rand.nextDouble() < Headcrumbs.babyCelebrityChance)
			setChild(true);

		getVIPHandler().onSpawn(this);

		return null;
	}

	@Override
	protected void despawnEntity() {
		super.despawnEntity();
		if (isDead && ridingEntity != null)
			ridingEntity.setDead();
	}

	/* RENDERING */

	@Override
	public double getYOffset() {
		return -0.3;
	}

	@Override
	@SideOnly(Side.CLIENT)
	// This is so NBT sensible tools (a.k.a. TiC tools) render when being held by the celebrity
	public IIcon getItemIcon(ItemStack stack, int pass) {
		return stack.getItem().requiresMultipleRenderPasses() ? stack.getItem().getIcon(stack, pass) : stack.getIconIndex();
	}

	/* SAVE AND LOAD */

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeEntityToNBT(nbt);

		String username = getUsername();
		if (!StringUtils.isBlank(username))
			nbt.setString("Username", username);

		if (isChild())
			nbt.setBoolean("IsBaby", true);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		super.readEntityFromNBT(nbt);

		String username;
		if (nbt.hasKey("Username")) {
			username = nbt.getString("Username");
			getNames().remove(username);
		} else
			username = getRandomUsername();
		setUsername(username);

		if (nbt.getBoolean("IsBaby"))
			setChild(true);

		setCombatAI();
	}

	/* ATTACK STUFF */

	@Override
	public boolean attackEntityAsMob(Entity target) {
		boolean result = super.attackEntityAsMob(target);
		if (result)
			swingItem();
		return result;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float damage) {
		if (!hasBow())
			return;

		EntityArrow arrow = new EntityArrow(worldObj, this, target, 1.6F, 14 - worldObj.difficultySetting.getDifficultyId() * 4);
		int power = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, getHeldItem());
		int punch = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, getHeldItem());
		arrow.setDamage(damage * 2.0F + rand.nextGaussian() * 0.25D + worldObj.difficultySetting.getDifficultyId() * 0.11F);

		if (power > 0)
			arrow.setDamage(arrow.getDamage() + power * 0.5D + 0.5D);

		if (punch > 0)
			arrow.setKnockbackStrength(punch);

		if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, getHeldItem()) > 0)
			arrow.setFire(100);

		playSound("random.bow", 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));
		worldObj.spawnEntityInWorld(arrow);
	}

	private boolean hasBow() {
		return getHeldItem() != null && getHeldItem().getItem() == Items.bow;
	}

	private void setCombatAI() {
		if (hasBow())
			tasks.addTask(1, arrowAI);
		else
			tasks.removeTask(arrowAI);
	}

	/* USERNAME */

	private VIPHandler getVIPHandler() {
		return VIPHandler.getHandler(getUsername());
	}

	@Override
	public String getCommandSenderName() {
		return getUsername();
	}

	@Override
	public String getCustomNameTag() {
		return getUsername();
	}

	@Override
	public boolean hasCustomNameTag() {
		return true;
	}

	@Override
	public IChatComponent func_145748_c_() {
		return new ChatComponentText(getCommandSenderName()) {

			private ChatStyle style;

			@Override
			public ChatStyle getChatStyle() {
				if (style == null) {
					style = new ChatStyle() {

						@Override
						@SideOnly(Side.CLIENT)
						public String getFormattingCode() {
							return Headcrumbs.celebrityNamePrefix;
						}

					};
					Iterator<?> iterator = siblings.iterator();

					while (iterator.hasNext()) {
						IChatComponent ichatcomponent = (IChatComponent) iterator.next();
						ichatcomponent.getChatStyle().setParentStyle(style);
					}
				}

				return style;
			}
		};
	}

	@Override
	public void setCustomNameTag(String name) {
	}

	private void setUsername(String name) {
		getDataWatcher().updateObject(NAME, UsernameUtils.getFixedUsername(name));
	}

	public String getUsername() {
		String username = getDataWatcher().getWatchableObjectString(NAME);
		if (StringUtils.isBlank(username))
			getDataWatcher().updateObject(NAME, getRandomUsername());
		return username;
	}

	private String getRandomUsername() {
		List<String> names = getNames();

		String username = names.get(rand.nextInt(names.size()));
		names.remove(username);
		return username;
	}

	private static List<String> names = new LinkedList<String>();

	private static List<String> getNames() {
		if (names.isEmpty())
			names.addAll(Headcrumbs.getAllNames());

		return names;
	}

	@SideOnly(Side.CLIENT)
	private GameProfile profile;

	@SideOnly(Side.CLIENT)
	public GameProfile getProfile() {
		if (profile == null)
			profile = new GameProfile(null, getUsername());
		return profile;
	}

	// Child stuff

	@Override
	public boolean isChild() {
		return getDataWatcher().getWatchableObjectByte(CHILD) == 1;
	}

	public void setChild(boolean isChild) {
		getDataWatcher().updateObject(CHILD, (byte) (isChild ? 1 : 0));

		if (worldObj != null && !worldObj.isRemote) {
			IAttributeInstance speed = getEntityAttribute(SharedMonsterAttributes.movementSpeed);
			speed.removeModifier(babySpeedBoostModifier);
			if (isChild)
				speed.applyModifier(babySpeedBoostModifier);
		}

		if (isChild)
			setSize(width * 0.5F, height * 0.5F);
	}

	@Override
	protected void setSize(float width, float height) {
		super.setSize(width, height);
		dataWatcher.updateObject(WIDTH, this.width);
		dataWatcher.updateObject(HEIGHT, this.height);
	}
}