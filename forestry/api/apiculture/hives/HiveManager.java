/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.apiculture.hives;

import java.util.ArrayList;

public class HiveManager {

	private static ArrayList<IHive> hives = new ArrayList<IHive>();
	public static ArrayList<IHive> getHives() {
		return new ArrayList<IHive>(hives);
	}

	/**
	 * Add new custom hives here to have them generate in the world.
	 */
	public static boolean addHive(IHive hive) {
		return hives.add(hive);
	}

	/**
	 * Get an existing hive to add new IHiveDrops to them.
	 */
	public static IHive getForestHive()	{ return hives.get(0); }
	public static IHive getMeadowsHive(){ return hives.get(1); }
	public static IHive getDesertHive()	{ return hives.get(2); }
	public static IHive getJungleHive()	{ return hives.get(3); }
	public static IHive getEndHive()	{ return hives.get(4); }
	public static IHive getSnowHive()	{ return hives.get(5); }
	public static IHive getSwampHive()	{ return hives.get(6); }

}
