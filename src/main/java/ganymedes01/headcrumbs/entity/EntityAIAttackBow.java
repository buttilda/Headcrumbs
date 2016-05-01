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
	private final int field_188501_c;
	private final float maxAttackDistance;
	private int field_188503_e = -1;
	private int field_188504_f;
	private boolean field_188505_g;
	private boolean field_188506_h;
	private int field_188507_i = -1;

	public EntityAIAttackBow(EntityHuman entity, double moveSpeedAmp, int field_188501_c, float maxAttackDistance) {
		this.entity = entity;
		this.moveSpeedAmp = moveSpeedAmp;
		this.field_188501_c = field_188501_c;
		this.maxAttackDistance = maxAttackDistance * maxAttackDistance;
		setMutexBits(3);
	}

	@Override
	public boolean shouldExecute() {
		return entity.getAttackTarget() == null ? false : func_188498_f();
	}

	protected boolean func_188498_f() {
		return entity.getHeldItemMainhand() != null && entity.getHeldItemMainhand().getItem() == Items.bow;
	}

	@Override
	public boolean continueExecuting() {
		return (shouldExecute() || !entity.getNavigator().noPath()) && func_188498_f();
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
		field_188504_f = 0;
		field_188503_e = -1;
		entity.resetActiveHand();
	}

	@Override
	public void updateTask() {
		EntityLivingBase entitylivingbase = entity.getAttackTarget();

		if (entitylivingbase != null) {
			double d0 = entity.getDistanceSq(entitylivingbase.posX, entitylivingbase.getEntityBoundingBox().minY, entitylivingbase.posZ);
			boolean flag = entity.getEntitySenses().canSee(entitylivingbase);
			boolean flag1 = field_188504_f > 0;

			if (flag != flag1)
				field_188504_f = 0;

			if (flag)
				++field_188504_f;
			else
				--field_188504_f;

			if (d0 <= maxAttackDistance && field_188504_f >= 20) {
				entity.getNavigator().clearPathEntity();
				++field_188507_i;
			} else {
				entity.getNavigator().tryMoveToEntityLiving(entitylivingbase, moveSpeedAmp);
				field_188507_i = -1;
			}

			if (field_188507_i >= 20) {
				if (entity.getRNG().nextFloat() < 0.3D)
					field_188505_g = !field_188505_g;

				if (entity.getRNG().nextFloat() < 0.3D)
					field_188506_h = !field_188506_h;

				field_188507_i = 0;
			}

			if (field_188507_i > -1) {
				if (d0 > maxAttackDistance * 0.75F)
					field_188506_h = false;
				else if (d0 < maxAttackDistance * 0.25F)
					field_188506_h = true;

				entity.getMoveHelper().func_188488_a(field_188506_h ? -0.5F : 0.5F, field_188505_g ? 0.5F : -0.5F);
				entity.faceEntity(entitylivingbase, 30.0F, 30.0F);
			} else
				entity.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);

			if (entity.isHandActive()) {
				if (!flag && field_188504_f < -60)
					entity.resetActiveHand();
				else if (flag) {
					int i = entity.getItemInUseMaxCount();

					if (i >= 20) {
						entity.resetActiveHand();
						entity.attackEntityWithRangedAttack(entitylivingbase, ItemBow.func_185059_b(i));
						field_188503_e = field_188501_c;
					}
				}
			} else if (--field_188503_e <= 0 && field_188504_f >= -60)
				entity.setActiveHand(EnumHand.MAIN_HAND);
		}
	}
}