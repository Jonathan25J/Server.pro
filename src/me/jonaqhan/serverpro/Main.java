package me.jonaqhan.serverpro;

import org.bukkit.plugin.java.JavaPlugin;

import me.jonaqhan.serverpro.commands.Reload;
import me.jonaqhan.serverpro.events.Ad;
import me.jonaqhan.serverpro.plugins.Load;

public class Main extends JavaPlugin {

	public void onEnable() {

		new Load(this);

		new Ad(this);

		new Reload(this);

		saveDefaultConfig();

	}

	public void onDisable() {

	}
}
