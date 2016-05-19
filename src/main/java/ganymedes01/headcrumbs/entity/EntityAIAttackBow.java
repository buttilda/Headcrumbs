package ganymedes01.headcrumbs.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.util.EnumHand;

/**
 * Adapted from net.minecraft.entity.ai.EntityAIAttackRangedBow
 */
public class EntityAIAttackBow extends EntityAIBase {

	private final EntityHuman entity;
	private final double moveSpeedAmp;
	private int attackCooldown;
	private final float maxAttackDistance;
	private int attackTime = -1;
	private int seeTime;
	private boolean strafingClockwise;
	private boolean strafingBackwards;
	private int strafingTime = -1;

	public EntityAIAttackBow(EntityHuman human, double speedAmplifier, int delay, float maxDistance) {
		entity = human;
		moveSpeedAmp = speedAmplifier;
		attackCooldown = delay;
		maxAttackDistance = maxDistance * maxDistance;
		setMutexBits(3);
	}

	public void setAttackCooldown(int p_189428_1_) {
		attackCooldown = p_189428_1_;
	}

	@Override
	public boolean shouldExecute() {
		return entity.getAttackTarget() == null ? false : isBowInMainhand();
	}

	protected boolean isBowInMainhand() {
		return entity.getHeldItemMainhand() != null && entity.getHeldItemMainhand().getItem() == Items.BOW;
	}

	@Override
	public boolean continueExecuting() {
		return (shouldExecute() || !entity.getNavigator().noPath()) && isBowInMainhand();
	}

	@Override
	public void startExecuting() {
		super.startExecuting();
		entity.setDrawingBow(true);
	}

	@Override
	public void resetTask() {
		super.startExecuting();
		entity.setDrawingBow(false);
		seeTime = 0;
		attackTime = -1;
		entity.resetActiveHand();
	}

	@Override
	public void updateTask() {
		EntityLivingBase entitylivingbase = entity.getAttackTarget();

		if (entitylivingbase != null) {
			double d0 = entity.getDistanceSq(entitylivingbase.posX, entitylivingbase.getEntityBoundingBox().minY, entitylivingbase.posZ);
			boolean flag = entity.getEntitySenses().canSee(entitylivingbase);
			boolean flag1 = seeTime > 0;

			if (flag != flag1)
				seeTime = 0;

			if (flag)
				++seeTime;
			else
				--seeTime;

			if (d0 <= maxAttackDistance && seeTime >= 20) {
				entity.getNavigator().clearPathEntity();
				++strafingTime;
			} else {
				entity.getNavigator().tryMoveToEntityLiving(entitylivingbase, moveSpeedAmp);
				strafingTime = -1;
			}

			if (strafingTime >= 20) {
				if (entity.getRNG().nextFloat() < 0.3D)
					strafingClockwise = !strafingClockwise;

				if (entity.getRNG().nextFloat() < 0.3D)
					strafingBackwards = !strafingBackwards;

				strafingTime = 0;
			}

			if (strafingTime > -1) {
				if (d0 > maxAttackDistance * 0.75F)
					strafingBackwards = false;
				else if (d0 < maxAttackDistance * 0.25F)
					strafingBackwards = true;

				entity.getMoveHelper().strafe(strafingBackwards ? -0.5F : 0.5F, strafingClockwise ? 0.5F : -0.5F);
				entity.faceEntity(entitylivingbase, 30.0F, 30.0F);
			} else
				entity.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);

			if (entity.isHandActive()) {
				if (!flag && seeTime < -60)
					entity.resetActiveHand();
				else if (flag) {
					int i = entity.getItemInUseMaxCount();

					if (i >= 20) {
						entity.resetActiveHand();
						entity.attackEntityWithRangedAttack(entitylivingbase, ItemBow.getArrowVelocity(i));
						attackTime = attackCooldown;
					}
				}
			} else if (--attackTime <= 0 && seeTime >= -60)
				entity.setActiveHand(EnumHand.MAIN_HAND);
		}
	}
}