/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.apiculture.hives;

import java.util.List;

import forestry.api.apiculture.IHiveDrop;
import net.minecraft.util.IStringSerializable;

public interface IHiveRegistry {

	/* Forestry Hive Names */
	
	public static enum HiveType implements IStringSerializable{
		FOREST("Forestry:forest"),
		MEADOWS("Forestry:meadows"),
		DESERT("Forestry:desert"),
		JUNGLE("Forestry:jungle"),
		END("Forestry:end"),
		SNOW("Forestry:snow"),
		SWAMP("Forestry:swamp");
		
		private HiveType(String name) {
			this.name = name;
		}

		public String name;
		
		public String getHiveName()
		{
			return name;
		}
		
		@Override
		public String getName() {
			return name().toLowerCase();
		}
		
	}

	/**
	 * Adds a new hive to be generated in the world.
	 */
	void registerHive(String hiveName, IHiveDescription hiveDescription);

	/**
	 * Add drops to a registered hive.
	 */
	void addDrops(String hiveName, IHiveDrop... drops);
	void addDrops(String hiveName, List<IHiveDrop> drop);
}
