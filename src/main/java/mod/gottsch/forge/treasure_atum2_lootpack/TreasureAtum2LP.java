package mod.gottsch.forge.treasure_atum2_lootpack;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.someguyssoftware.gottschcore.annotation.Credits;
import com.someguyssoftware.gottschcore.config.IConfig;
import com.someguyssoftware.gottschcore.mod.AbstractMod;
import com.someguyssoftware.gottschcore.mod.IMod;
import com.someguyssoftware.gottschcore.version.BuildVersion;
import com.someguyssoftware.treasure2.api.TreasureApi;
import com.someguyssoftware.treasure2.eventhandler.WorldEventHandler;

import mod.gottsch.forge.treasure_atum2_lootpack.config.ModConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * 
 * @author Mark Gottschling on Sep 17, 2022
 *
 */
@Mod(modid = TreasureAtum2LP.MODID, 
name = TreasureAtum2LP.NAME, 
version = TreasureAtum2LP.VERSION, 
dependencies = "required-after:gottschcore@[1.14.0,);required-after:treasure2@[2.0.0,);required-after:atum@[1.12.2-2.0.20,)", 
acceptedMinecraftVersions = "[1.12.2]", 
updateJSON = TreasureAtum2LP.UPDATE_JSON_URL)
@Credits(values = { "Treasure2: Atum2 Loot Pack was first developed by Mark Gottschling on Sept 17, 2022."})
public class TreasureAtum2LP extends AbstractMod {
	// constants
	public static final String MODID = "treasure2_atum2_lp";
	protected static final String NAME = "Treasure2Atum2LP";
	protected static final String VERSION = "2.0.0";

	public static final String UPDATE_JSON_URL = "https://raw.githubusercontent.com/gottsch/gottsch-minecraft-Treasure-Atum2-Loot-Pack/1.12.2-main/update.json";

	private static final BuildVersion MINECRAFT_VERSION = new BuildVersion(1, 12, 2);

	// latest version
	private static BuildVersion latestVersion;

	// logger
	public static Logger LOGGER = LogManager.getLogger(TreasureAtum2LP.NAME);

	@Instance(value = TreasureAtum2LP.MODID)
	public static TreasureAtum2LP instance;

	/**
	 * 
	 */
	public TreasureAtum2LP() {

	}

	/**
	 * 
	 * @param event
	 */
	@Override
	@EventHandler
	public void preInt(FMLPreInitializationEvent event) {
		super.preInt(event);

		// register additional events
		MinecraftForge.EVENT_BUS.register(new WorldEventHandler(getInstance()));
		// create the treasure registries
		TreasureApi.registerLootTables(MODID);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (!getConfig().isModEnabled()) {
			return;
		}

		// perform any post init
		super.postInit(event);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getConfig()
	 */
	@Override
	public IConfig getConfig() {
		return ModConfig.instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getMinecraftVersion()
	 */
	@Override
	public BuildVersion getMinecraftVersion() {
		return TreasureAtum2LP.MINECRAFT_VERSION;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getVerisionURL()
	 */
	@Override
	public String getVerisionURL() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getName()
	 */
	@Override
	public String getName() {
		return TreasureAtum2LP.NAME;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getId()
	 */
	@Override
	public String getId() {
		return TreasureAtum2LP.MODID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.AbstractMod#getInstance()
	 */
	@Override
	public IMod getInstance() {
		return TreasureAtum2LP.instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.AbstractMod#getVersion()
	 */
	@Override
	public String getVersion() {
		return TreasureAtum2LP.VERSION;
	}

	@Override
	public BuildVersion getModLatestVersion() {
		return latestVersion;
	}

	@Override
	public void setModLatestVersion(BuildVersion version) {
		TreasureAtum2LP.latestVersion = version;
	}

	@Override
	public String getUpdateURL() {
		return TreasureAtum2LP.UPDATE_JSON_URL;
	}
}