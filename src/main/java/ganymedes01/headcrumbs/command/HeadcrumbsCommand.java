package ganymedes01.headcrumbs.command;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.libs.Reference;
import ganymedes01.headcrumbs.utils.HeadUtils;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import scala.actors.threadpool.Arrays;

public class HeadcrumbsCommand extends CommandBase {

	@Override
	public String getCommandName() {
		return Reference.MOD_ID;
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/" + Reference.MOD_ID + " [player] [head]";
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List addTabCompletionOptions(ICommandSender sender, String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList(Headcrumbs.others));
		list.addAll(Arrays.asList(Headcrumbs.modders));
		list.addAll(Arrays.asList(Headcrumbs.youtubers));
		list.addAll(Arrays.asList(Headcrumbs.mojang));
		list.addAll(Arrays.asList(Headcrumbs.mindCrack));
		list.addAll(Arrays.asList(Headcrumbs.forgeCraft));
		list.addAll(Arrays.asList(Headcrumbs.ftb));

		return args.length == 1 ? getListOfStringsMatchingLastWord(args, MinecraftServer.getServer().getAllUsernames()) : getListOfStringsMatchingLastWord(args, list.toArray(new String[0]));
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		try {
			EntityPlayer player = CommandBase.getPlayer(sender, args[0]);
			if (player != null) {
				ItemStack stack = HeadUtils.createHeadFor(args[1]);
				EntityItem entity = player.dropPlayerItemWithRandomChoice(stack, false);
				entity.delayBeforeCanPickup = 0;
				entity.func_145797_a(player.getCommandSenderName());
				CommandBase.func_152373_a(sender, this, "commands.give.success", new Object[] { stack.func_151000_E(), Integer.valueOf(1), player.getCommandSenderName() });
			}
		} catch (Exception e) {
			throw new WrongUsageException(getCommandUsage(sender), new Object[0]);
		}
	}
}