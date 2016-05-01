package ganymedes01.headcrumbs.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Predicate;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.api.IHumanEntity;
import ganymedes01.headcrumbs.utils.ThreadedProfileFiller;
import ganymedes01.headcrumbs.utils.UsernameUtils;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIBreakDoor;
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
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityHuman extends EntityMob implements IRangedAttackMob, IHumanEntity {

	// Cape stuff
	private double prevCapeX, prevCapeY, prevCapeZ;
	private double capeX, capeY, capeZ;

	// Texture stuff
	private GameProfile profile;
	private ResourceLocation skin, cape;
	private boolean skinAvailable = false, capeAvailable = false, profileReady = false;

	// Attributes
	private static final AttributeModifier babySpeedBoostModifier = new AttributeModifier(UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836"), "Baby speed boost", 0.5D, 1);

	// AI
	private final EntityAIBase breakDoorAI = new EntityAIBreakDoor(this);
	private final EntityAIBase arrowAI = new EntityAIAttackBow(this, 1.0D, 20, 15.0F);

	// Data watcher
	private static final DataParameter<String> NAME = EntityDataManager.<String> createKey(EntityHuman.class, DataSerializers.STRING);
	private static final DataParameter<Boolean> CHILD = EntityDataManager.<Boolean> createKey(EntityHuman.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Float> WIDTH = EntityDataManager.<Float> createKey(EntityHuman.class, DataSerializers.FLOAT);
	private static final DataParameter<Float> HEIGHT = EntityDataManager.<Float> createKey(EntityHuman.class, DataSerializers.FLOAT);
	private static final DataParameter<Boolean> DRAWING_BOW = EntityDataManager.<Boolean> createKey(EntityHuman.class, DataSerializers.BOOLEAN);

	public EntityHuman(World world) {
		super(world);
		((PathNavigateGround) getNavigator()).setBreakDoors(true);
		tasks.addTask(0, new EntityAISwimming(this));
		if (world.getDifficulty() == EnumDifficulty.HARD)
			tasks.addTask(1, new EntityAIOpenDoor(this, true));
		tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
		tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
		tasks.addTask(7, new EntityAIWander(this, 1.0D));
		tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(8, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, 0, true, false, new Predicate<EntityPlayer>() {

			@Override
			public boolean apply(EntityPlayer input) {
				return Headcrumbs.humansAttackTwins || !input.getName().equals(getUsername());
			}
		}));
		setSize(0.6F, 1.8F);
	}

	@Override
	public boolean canPickUpLoot() {
		return true;
	}

	@Override
	public void onUpdate() {
		prevCapeX = capeX;
		prevCapeY = capeY;
		prevCapeZ = capeZ;
		double x = posX - capeX;
		double y = posY - capeY;
		double z = posZ - capeZ;
		double maxCapeAngle = 10.0;

		if (x > maxCapeAngle)
			prevCapeX = capeX = posX;
		if (z > maxCapeAngle)
			prevCapeZ = capeZ = posZ;
		if (y > maxCapeAngle)
			prevCapeY = capeY = posY;
		if (x < -maxCapeAngle)
			prevCapeX = capeX = posX;
		if (z < -maxCapeAngle)
			prevCapeZ = capeZ = posZ;
		if (y < -maxCapeAngle)
			prevCapeY = capeY = posY;

		capeX += x * 0.25;
		capeZ += z * 0.25;
		capeY += y * 0.25;

		if (worldObj.isRemote) {
			float w = dataWatcher.get(WIDTH);
			if (w != width)
				width = w;
			float h = dataWatcher.get(HEIGHT);
			if (h != height)
				height = h;
		}

		super.onUpdate();
	}

	/* ENTITY INIT */

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.24);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataWatcher.register(NAME, "");
		dataWatcher.register(CHILD, false);
		dataWatcher.register(WIDTH, width);
		dataWatcher.register(HEIGHT, height);
		dataWatcher.register(DRAWING_BOW, false);
	}

	/* SOUNDS */

	@Override
	protected SoundEvent getAmbientSound() {
		return getVIPHandler().getAmbientSound();
	}

	@Override
	protected SoundEvent getHurtSound() {
		return getVIPHandler().hurtSound();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return getVIPHandler().deathSound();
	}

	/* DROPS */

	@Override
	protected void dropFewItems(boolean recentHit, int looting) {
		getVIPHandler().dropItems(this, looting);
	}

	/* EQUIPAMENT AND ITEMS */

	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);

		if (rand.nextFloat() < (worldObj.getDifficulty() == EnumDifficulty.HARD ? 0.1F : 0.05F)) {
			int i = rand.nextInt(3);

			if (i == 0) {
				setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.stone_sword));
				if (worldObj.getDifficulty() == EnumDifficulty.HARD)
					if (rand.nextFloat() > 0.5F) {
						setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Items.shield));
						getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(new AttributeModifier("Shield Bonus", rand.nextDouble() * 3.0 + 1.0, 2));
					}
			} else if (i == 1) {
				setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.bow));
				if (worldObj.getDifficulty() == EnumDifficulty.HARD)
					if (rand.nextFloat() > 0.5F) {
						List<ResourceLocation> keys = new ArrayList<ResourceLocation>(PotionType.potionTypeRegistry.getKeys());
						ResourceLocation key = keys.get(rand.nextInt(keys.size()));
						PotionType potion = PotionType.potionTypeRegistry.getObject(key);
						setItemStackToSlot(EntityEquipmentSlot.OFFHAND, PotionUtils.addPotionToItemStack(new ItemStack(Items.tipped_arrow), potion));
					}
			}
		}
	}

	@Override
	public void setItemStackToSlot(EntityEquipmentSlot slot, ItemStack stack) {
		super.setItemStackToSlot(slot, stack);
		setCombatAI();
	}

	@Override
	public ItemStack getPickedResult(RayTraceResult target) {
		ItemStack stack = new ItemStack(Items.spawn_egg);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("entity_name", EntityList.classToStringMapping.get(getClass()));
		stack.setTagCompound(nbt);
		return stack;
	}

	/* SPAWN AND DESPAWN */

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		setUsername(getRandomUsername(rand));
		setEquipmentBasedOnDifficulty(difficulty);
		setEnchantmentBasedOnDifficulty(difficulty);
		setCombatAI();

		float additionalDifficulty = difficulty.getClampedAdditionalDifficulty();
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).applyModifier(new AttributeModifier("Knockback Resistance Bonus", rand.nextDouble() * 0.05, 0));

		double rangeBonus = rand.nextDouble() * 1.5 * additionalDifficulty;
		if (rangeBonus > 1.0)
			getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(new AttributeModifier("Range Bonus", rangeBonus, 2));

		if (rand.nextFloat() < additionalDifficulty * 0.05F)
			getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(new AttributeModifier("Health Bonus", rand.nextDouble() * 3.0 + 1.0, 2));

		if (rand.nextFloat() < additionalDifficulty * 0.15F)
			getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).applyModifier(new AttributeModifier("Damage Bonus", rand.nextDouble() + 0.5, 2));

		if (rand.nextFloat() < additionalDifficulty * 0.2F)
			getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(new AttributeModifier("Speed Bonus", rand.nextDouble() * 2.0 * 0.24 + 0.01, 2));

		if (rand.nextDouble() < Headcrumbs.babyHumanChance)
			setChild(true);

		if (rand.nextFloat() < additionalDifficulty * 0.1F)
			tasks.addTask(1, breakDoorAI);

		getVIPHandler().onSpawn(this, difficulty);

		return null;
	}

	@Override
	protected void despawnEntity() {
		super.despawnEntity();
		Entity ridingEntity = getRidingEntity();
		if (isDead && ridingEntity != null)
			ridingEntity.setDead();
	}

	/* RENDERING */

	@Override
	public double getYOffset() {
		return -0.3;
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
			username = getRandomUsername(rand);
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
			swingArm(EnumHand.MAIN_HAND);
		return result;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float damage) {
		if (!hasBow())
			return;

		EntityTippedArrow arrow = new EntityTippedArrow(worldObj, this);
		ItemStack offHandStack = getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);
		if (offHandStack != null && offHandStack.getItem() == Items.tipped_arrow)
			arrow.setPotionEffect(offHandStack);

		double x = target.posX - posX;
		double y = target.getEntityBoundingBox().minY + target.height / 3.0F - arrow.posY;
		double z = target.posZ - posZ;
		double d0 = MathHelper.sqrt_double(x * x + z * z);
		arrow.setThrowableHeading(x, y + d0 * 0.2, z, 1.6F, 14 - worldObj.getDifficulty().getDifficultyId() * 4);
		int power = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.power, this);
		int punch = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.punch, this);
		arrow.setDamage(damage * 2.0F + rand.nextGaussian() * 0.25 + worldObj.getDifficulty().getDifficultyId() * 0.11F);

		if (power > 0)
			arrow.setDamage(arrow.getDamage() + power * 0.5 + 0.5);

		if (punch > 0)
			arrow.setKnockbackStrength(punch);

		if (EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.flame, this) > 0)
			arrow.setFire(100);

		playSound(SoundEvents.entity_skeleton_shoot, 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
		worldObj.spawnEntityInWorld(arrow);
	}

	private boolean hasBow() {
		ItemStack stack = getHeldItem(EnumHand.MAIN_HAND);
		return stack != null && stack.getItem() instanceof ItemBow;
	}

	private void setCombatAI() {
		if (hasBow())
			tasks.addTask(1, arrowAI);
		else
			tasks.removeTask(arrowAI);
	}

	@SideOnly(Side.CLIENT)
	public boolean isDrawingBow() {
		return dataWatcher.get(DRAWING_BOW).booleanValue();
	}

	public void setDrawingBow(boolean flag) {
		dataWatcher.set(DRAWING_BOW, flag);
	}

	/* USERNAME */

	private VIPHandler getVIPHandler() {
		return VIPHandler.getHandler(getUsername());
	}

	@Override
	public String getName() {
		return getUsername();
	}

	@Override
	public String getCustomNameTag() {
		return getUsername();
	}

	@Override
	public boolean hasCustomName() {
		return true;
	}

	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentString(getName()) {

			private Style style;

			@Override
			public Style getChatStyle() {
				if (style == null) {
					style = new Style() {

						@Override
						@SideOnly(Side.CLIENT)
						public String getFormattingCode() {
							return Headcrumbs.humanNamePrefix;
						}

					};
					Iterator<ITextComponent> iterator = siblings.iterator();

					while (iterator.hasNext()) {
						ITextComponent ichatcomponent = iterator.next();
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

	public static String getRandomUsername(Random rand) {
		List<String> names = getNames();

		String username = names.get(rand.nextInt(names.size()));
		names.remove(username);
		return username;
	}

	private static List<String> names = new LinkedList<String>();

	public static List<String> getNames() {
		if (names.isEmpty())
			names.addAll(Headcrumbs.getAllNames());
		return names;
	}

	// IHumanEntity

	@Override
	public GameProfile getProfile() {
		if (profile == null) {
			profile = new GameProfile(null, getUsername());
			ThreadedProfileFiller.updateProfile(this);
		}
		return profile;
	}

	@Override
	public void setProfile(GameProfile profile) {
		this.profile = profile;
		profileReady = true;
	}

	@Override
	public String getUsername() {
		return dataWatcher.get(NAME);
	}

	@Override
	public void setUsername(String name) {
		dataWatcher.set(NAME, UsernameUtils.getFixedUsername(name));

		if ("Herobrine".equals(name)) {
			getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).applyModifier(new AttributeModifier("Herobrine Damage Bonus", 1, 2));
			getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(new AttributeModifier("Herobrine Speed Bonus", 0.5, 2));
		}
	}

	@Override
	public double getInterpolatedCapeX(float partialTickTime) {
		return prevCapeX + (capeX - prevCapeX) * partialTickTime - (prevPosX + (posX - prevPosX) * partialTickTime);
	}

	@Override
	public double getInterpolatedCapeY(float partialTickTime) {
		return prevCapeY + (capeY - prevCapeY) * partialTickTime - (prevPosY + (posY - prevPosY) * partialTickTime);
	}

	@Override
	public double getInterpolatedCapeZ(float partialTickTime) {
		return prevCapeZ + (capeZ - prevCapeZ) * partialTickTime - (prevPosZ + (posZ - prevPosZ) * partialTickTime);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public SkinManager.SkinAvailableCallback getCallback() {
		return new SkinManager.SkinAvailableCallback() {

			@Override
			public void skinAvailable(MinecraftProfileTexture.Type type, ResourceLocation location, MinecraftProfileTexture profileTexture) {
				switch (type) {
					case CAPE:
						cape = location;
						break;
					case SKIN:
					default:
						skin = location;
						break;
				}
				setTextureAvailable(type);
			}
		};
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isTextureAvailable(MinecraftProfileTexture.Type type) {
		switch (type) {
			case CAPE:
				return capeAvailable;
			case SKIN:
			default:
				return skinAvailable;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void setTextureAvailable(MinecraftProfileTexture.Type type) {
		switch (type) {
			case CAPE:
				capeAvailable = true;
				break;
			case SKIN:
			default:
				skinAvailable = true;
				break;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ResourceLocation getTexture(MinecraftProfileTexture.Type type) {
		switch (type) {
			case CAPE:
				return cape;
			case SKIN:
			default:
				return skin;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isProfileReady() {
		return profileReady;
	}

	// Child stuff

	@Override
	public boolean isChild() {
		return dataWatcher.get(CHILD);
	}

	public void setChild(boolean isChild) {
		dataWatcher.set(CHILD, isChild);

		if (worldObj != null && !worldObj.isRemote) {
			IAttributeInstance speed = getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
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
		dataWatcher.set(WIDTH, this.width);
		dataWatcher.set(HEIGHT, this.height);
	}
}