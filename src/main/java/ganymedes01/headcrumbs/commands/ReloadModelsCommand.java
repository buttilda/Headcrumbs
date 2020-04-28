package ganymedes01.headcrumbs.commands;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.libs.HeadDropRegistry;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class ReloadModelsCommand extends CommandBase {

	public ReloadModelsCommand() {
	}
	
	@Override
	public String getName() {
		return "reloadmodels";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/reloadmodels";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if (sender instanceof EntityPlayerMP) {
			HeadDropRegistry.initModels();
			Headcrumbs.registerHelpers();
		} else {
			sender.sendMessage(new TextComponentString("This is a client-only command."));
		}
		
	}

}
