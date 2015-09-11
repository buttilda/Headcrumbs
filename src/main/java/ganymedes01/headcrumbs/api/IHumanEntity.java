package ganymedes01.headcrumbs.api;

import com.mojang.authlib.GameProfile;

public interface IHumanEntity {

	GameProfile getProfile();

	String getUsername();

	void setUsername(String name);

	double getInterpolatedCapeX(float partialTickTime);

	double getInterpolatedCapeY(float partialTickTime);

	double getInterpolatedCapeZ(float partialTickTime);
}