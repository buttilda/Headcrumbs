package ganymedes01.headcrumbs.utils;

import java.util.ArrayList;
import java.util.List;

import ganymedes01.headcrumbs.api.IHumanEntity;
import net.minecraft.tileentity.TileEntitySkull;

public class ThreadedProfileFiller {

	private static List<IHumanEntity> humans = new ArrayList<IHumanEntity>();
	private static Thread thread;

	public static void updateProfile(IHumanEntity human) {
		humans.add(human);

		if(thread == null || thread.getState() == Thread.State.TERMINATED){
			thread = new Thread(new Runnable() {

				@Override
				public void run() {
					while(!humans.isEmpty()){
						IHumanEntity human = humans.get(0);
						if(human != null)
							human.setProfile(TileEntitySkull.updateGameProfile(human.getProfile()));
						humans.remove(0);
					}
				}
			});

			thread.start();
		}
	}
}