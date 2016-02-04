package ganymedes01.headcrumbs.entity;

import java.util.HashMap;
import java.util.Map;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

import ganymedes01.headcrumbs.Headcrumbs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class VIPHandler {

	private static final VIPHandler DEFAULT = new VIPHandler(0);
	private static final Map<String, VIPHandler> handlers = new HashMap<String, VIPHandler>();

	public static VIPHandler getHandler(String name) {
		if (Headcrumbs.enableVIPs && handlers.containsKey(name))
			return handlers.get(name);

		return DEFAULT;
	}

	public VIPHandler() {
		handlers.put(getClass().getSimpleName(), this);
	}

	private VIPHandler(int i) {
	}

	public void dropItems(EntityHuman entity, int looting) {
		int amount = minDropAmount() + entity.getRNG().nextInt(maxBaseDropAmount());

		if (looting > 0)
			amount += entity.getRNG().nextInt(looting + 1);

		amount = Math.min(maxDropAmount(), amount);
		for (int i = 0; i < amount; i++) {
			ItemStack stack = entity.isChild() ? getDefaultDropItem(entity) : getItem(entity);
			if (stack != null)
				entity.entityDropItem(stack, 0);
		}
	}

	public void dropRare(EntityHuman entity, int looting) {
	}

	protected int minDropAmount() {
		return 0;
	}

	protected int maxDropAmount() {
		return Integer.MAX_VALUE;
	}

	protected int maxBaseDropAmount() {
		return 3;
	}

	protected ItemStack getItem(EntityHuman entity) {
		return getDefaultDropItem(entity);
	}

	private ItemStack getDefaultDropItem(EntityHuman entity) {
		return entity.getRNG().nextBoolean() ? new ItemStack(Items.bone) : new ItemStack(Items.rotten_flesh);
	}

	public void onSpawn(EntityHuman entity) {
	}

	public String livingSound() {
		return null;
	}

	protected String hurtSound() {
		return "game.hostile.hurt";
	}

	protected String deathSound() {
		return "game.hostile.die";
	}

	public static void init() {
		try {
			for (ClassInfo clazzInfo : ClassPath.from(VIPHandler.class.getClassLoader()).getTopLevelClasses(VIPHandler.class.getPackage().getName() + ".vip")) {
				Class<?> clazz = clazzInfo.load();
				if (clazz != VIPHandler.class && VIPHandler.class.isAssignableFrom(clazz))
					clazz.newInstance();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}