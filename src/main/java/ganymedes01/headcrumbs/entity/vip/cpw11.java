package ganymedes01.headcrumbs.entity.vip;

import cpw.mods.fml.common.Loader;
import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.StatCollector;

public class cpw11 extends VIPHandler {

	private static String title = "How to use your DirtChest 9000!";
	private static String page1 = "Welcome to your new DirtChest 9000! We hope you will enjoy many happy years of storing your stack of dirt in our storage utility.";
	private static String page2 = "Usage: simply insert the stack of dirt of your choice into the highly receptive slot and enjoy the great convenience of having that dirt available to you, any time you pass by this chest!";
	private static String page3 = "We hope you have enjoyed reviewing this instruction manual, and hope you will consider using our products in future! Kind regards, The DirtChest 9000 manual writers incorporated.";
	private static String page4 = "Warranty: This product has no warranty of any kind. Your dirt may not be stored, it may slowly leech into the environment, or alternatively, it may not do anything at all.";
	private static String page5 = "DirtChest 9000 is kind to the environment. Please dispose of this guide book responsibly, and do not whatever you do just chuck it into some lava. We would be very sad.";
	private ItemStack dirtChest9000GuideBook = null;

	@Override
	protected int minDropAmount() {
		return 1;
	}

	@Override
	protected int maxDropAmount() {
		return 1;
	}

	@Override
	protected ItemStack getItem(EntityHuman entity) {
		if (dirtChest9000GuideBook == null) {
			dirtChest9000GuideBook = new ItemStack(Items.written_book);
			dirtChest9000GuideBook.setTagInfo("author", new NBTTagString("cpw"));
			NBTTagList pages = new NBTTagList();

			if (Loader.isModLoaded("IronChest")) {
				dirtChest9000GuideBook.setTagInfo("title", new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest9000.title")));
				pages.appendTag(new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest9000.page1")));
				pages.appendTag(new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest9000.page2")));
				pages.appendTag(new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest9000.page3")));
				pages.appendTag(new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest9000.page4")));
				pages.appendTag(new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest9000.page5")));
			} else {
				dirtChest9000GuideBook.setTagInfo("title", new NBTTagString(title));
				pages.appendTag(new NBTTagString(page1));
				pages.appendTag(new NBTTagString(page2));
				pages.appendTag(new NBTTagString(page3));
				pages.appendTag(new NBTTagString(page4));
				pages.appendTag(new NBTTagString(page5));
			}

			dirtChest9000GuideBook.setTagInfo("pages", pages);
		}

		return dirtChest9000GuideBook.copy();
	}
}