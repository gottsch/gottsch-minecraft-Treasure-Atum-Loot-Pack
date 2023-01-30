/*
 * This file is part of Treasure2: Twilight Forest Loot Pack.
 * Copyright (c) 2021, Mark Gottschling (gottsch)
 * 
 * All rights reserved.
 *
 * Treasure2: Twilight Forest Loot Pack is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Treasure2: Twilight Forest Loot Pack is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Treasure2: Twilight Forest Loot Pack.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */
package mod.gottsch.forge.treasure_atum2_lootpack.config;

import com.someguyssoftware.gottschcore.config.IConfig;

import mod.gottsch.forge.treasure_atum2_lootpack.TreasureAtum2LP;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Ignore;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 
 * @author Mark Gottschling on Jun 11, 2021
 *
 */
@Config(modid = TreasureAtum2LP.MODID, name = TreasureAtum2LP.MODID + "/" + TreasureAtum2LP.MODID + "-"
		+ ModConfig.CONFIG_VERSION, type = Type.INSTANCE)
public class ModConfig implements IConfig {
    @Ignore
	public static final String CONFIG_VERSION = "c1.0";
    
	@Comment({"Enables/Disables mod."})
	@Name("01. Enable the mod:")
	public static boolean enabled = true;
	
	@Comment({"The directory where mods are located.", "This is relative to the Minecraft install path."})
	@Name("02. Mods folder:")
	public static String folder = "mods";
	
	@Comment({"The directory where configs are located.", "Resource files will be located here as well.", "This is relative to the Minecraft install path."})
	@Name("03. Config folder:")
	public static String configFolder = "config";
	
	@Comment({"Enables/Disables version checking."})
	@Name("04. Enable the version checker:")
	public static boolean enableVersionChecker = true;
	
	@Comment({"The latest published version number.", "This is auto-updated by the version checker.", "This may be @deprecated."})
	@Name("05. Latest mod version available:")
	public static String latestVersion = "";
	
	@Comment({"Remind the user of the latest version (as indicated in latestVersion proeprty) update."})
	@Name("06. Enable latest mod version reminder:")
	public static boolean latestVersionReminder = true;
    
	@Ignore
	public static ModConfig instance = new ModConfig();
	
	/**
	 * 
	 */
    public ModConfig() {}
    
    @Mod.EventBusSubscriber
	public static class EventHandler {
		/**
		 * Inject the new values and save to the config file when the config has been changed from the GUI.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(TreasureAtum2LP.MODID)) {
				ConfigManager.sync(TreasureAtum2LP.MODID, Config.Type.INSTANCE);
			}
		}
    }
    
    @Override
	public boolean isModEnabled() {
		return enabled;
	}

	@Override
	public void setModEnabled(boolean modEnabled) {
		enabled = modEnabled;
	}

	@Override
	public String getModsFolder() {
		return folder;
	}

	@Override
	public void setModsFolder(String modsFolder) {
		folder = modsFolder;
    }
    
	@Override
	public boolean isEnableVersionChecker() {
		return enableVersionChecker;
	}

	@Override
	public String getLatestVersion() {
		return latestVersion;
	}

	@Override
	public void setEnableVersionChecker(boolean enableVersionChecker) {
		this.enableVersionChecker = enableVersionChecker;
	}

	@Override
	public void setLatestVersion(String latestVersion) {
		this.latestVersion = latestVersion;

	}

	@Override
	public boolean isLatestVersionReminder() {
		return latestVersionReminder;
	}

	@Override
	public void setLatestVersionReminder(boolean latestVersionReminder) {
		this.latestVersionReminder = latestVersionReminder;
	}

	@Override
	public void setForgeConfiguration(Configuration forgeConfiguration) {
	}

	@Override
	public Configuration getForgeConfiguration() {
		return null;
	}

	@Override
	public void setProperty(String category, String key, boolean value) {
	}

	@Override
	public void setProperty(String category, String key, String value) {
	}

	@Override
	public void setProperty(Property property, String value) {
	}

	@Override
	public String getConfigFolder() {
		return configFolder;
	}

	@Override
	public void setConfigFolder(String configFolder) {
	}
}