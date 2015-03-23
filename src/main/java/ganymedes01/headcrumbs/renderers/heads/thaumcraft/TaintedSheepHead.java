package ganymedes01.headcrumbs.renderers.heads.thaumcraft;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.heads.SheepHead;
import ganymedes01.headcrumbs.utils.Utils;

public class TaintedSheepHead extends SheepHead {

	public static final TaintedSheepHead INSTANCE = new TaintedSheepHead();

	protected TaintedSheepHead() {
		setSecondTexture(Utils.getResource(Strings.TC_PREFIX + "sheep_fur.png"));
	}
}