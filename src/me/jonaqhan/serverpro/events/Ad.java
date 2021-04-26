package me.jonaqhan.serverpro.events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;

import me.jonaqhan.serverpro.Main;

public class Ad implements Listener {

	public Main plugin;

	public Ad(Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onAd(ServerCommandEvent e) {
		if (!e.getCommand().startsWith("say"))
			return;

		String content = e.getCommand();

		List<String> words = plugin.getConfig().getStringList("forbidden-words");

		for (String w : words) {

			if (content.contains(w)) {
				e.setCancelled(true);

			}

		}

		if (content.contains("§610")) {

			e.setCommand("say " + plugin.getConfig().getString("server-expire-10").replace("&", "§"));

		}
		if (content.contains("§65")) {

			e.setCommand("say " + plugin.getConfig().getString("server-expire-5").replace("&", "§"));

		}

	}

}
