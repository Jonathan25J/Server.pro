package me.jonaqhan.serverpro.plugins;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.UnknownDependencyException;
import org.bukkit.plugin.java.JavaPlugin;

import me.jonaqhan.serverpro.Main;

public class Load {

	public Main plugin;

	public Load(Main plugin) {
		this.plugin = plugin;

		loadPlugins();
	}

	public void loadPlugins() {

		File dir = new File(plugin.getServer().getWorldContainer() + File.separator + "pluginz");
		if (!dir.exists())
			dir.mkdir();

		File[] jars = dir.listFiles(new FilenameFilter() {
			public boolean accept(final File a_directory, final String a_name) {
				return a_name.endsWith(".jar");
			};
		});

		if (jars != null) {

			for (File file : jars) {
				try {
					Plugin pl = Bukkit.getPluginManager().loadPlugin(file);
					Bukkit.getPluginManager().enablePlugin(pl);
				} catch (UnknownDependencyException | InvalidPluginException | InvalidDescriptionException e) {
					e.printStackTrace();
				}

			}
		}
	}

	protected void setDataFolder(Plugin plugin) {
		try {
			if (plugin instanceof JavaPlugin) {
				JavaPlugin jpl = (JavaPlugin) plugin;
				File dataFolder = new File(plugin.getServer().getWorldContainer() + File.separator + "pluginz");
				Field field = JavaPlugin.class.getDeclaredField("dataFolder");
				field.setAccessible(true);
				field.set(jpl, dataFolder);
			}
		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
			System.out.println(e);
		}

	}
}
