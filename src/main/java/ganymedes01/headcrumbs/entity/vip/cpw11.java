package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityCelebrity;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.StatCollector;

public class cpw11 extends VIPHandler {

	@Override
	protected int minDropAmount() {
		return 1;
	}

	@Override
	protected int maxDropAmount() {
		return 1;
	}

	@Override
	protected ItemStack getItem(EntityCelebrity entity) {
		ItemStack dirtChest9000GuideBook = new ItemStack(Items.written_book);
		dirtChest9000GuideBook.setTagInfo("author", new NBTTagString("cpw"));
		dirtChest9000GuideBook.setTagInfo("title", new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest9000.title")));
		NBTTagList pages = new NBTTagList();
		pages.appendTag(new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest9000.page1")));
		pages.appendTag(new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest9000.page2")));
		pages.appendTag(new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest9000.page3")));
		pages.appendTag(new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest9000.page4")));
		pages.appendTag(new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest9000.page5")));
		dirtChest9000GuideBook.setTagInfo("pages", pages);

		return dirtChest9000GuideBook;
	}
}