package me.jonaqhan.serverpro.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jonaqhan.serverpro.Main;
import net.md_5.bungee.api.ChatColor;

public class Reload implements CommandExecutor {

	public Main plugin;

	public Reload(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("spreload").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String content, String[] args) {

		Player p = (Player) sender;

		plugin.reloadConfig();

		p.sendMessage(ChatColor.GOLD + "Server.pro" + ChatColor.AQUA + "-" + ChatColor.BLUE + "plugin" + ChatColor.GREEN
				+ " has been reloaded");

		return false;
	}

}
