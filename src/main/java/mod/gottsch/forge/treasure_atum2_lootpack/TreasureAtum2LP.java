/*
 * This file is part of  Treasure Atum2 Loot Pack.
 * Copyright (c) 2021, Mark Gottschling (gottsch)
 * 
 * All rights reserved.
 *
 * Treasure Atum2 Loot Pack is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Treasure Atum2 Loot Pack is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Treasure Atum2 Loot Pack.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */
package mod.gottsch.forge.treasure_atum2_lootpack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.someguyssoftware.treasure2.api.TreasureApi;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * 
 * @author Mark Gottschling on Sep 17, 2022
 *
 */
@Mod(value = TreasureAtum2LP.MODID)
public class TreasureAtum2LP {
	// constants
	public static final String MODID = "treasure2_atum2_lp";
	protected static final String NAME = "Treasure2Atum2LP";
	
	// logger
	public static Logger LOGGER = LogManager.getLogger(TreasureAtum2LP.NAME);

	public static TreasureAtum2LP instance;

	/**
	 * 
	 */
    public TreasureAtum2LP() {
    	TreasureAtum2LP.instance = this;
    	
		// Register the setup method for modloading
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		eventBus.addListener(this::common);
}

    /**
     * 
     * @param event
     */
	private void common(final FMLCommonSetupEvent event) {
		TreasureApi.registerLootTables(MODID);
	}
}
