/*
 *******************************************************************************
 * Copyright (c) 2011-2014 SirSengir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Various Contributors including, but not limited to:
 * SirSengir (original work), CovertJaguar, Player, Binnie, MysteriousAges
 *******************************************************************************
 */
package forestry.api.core;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 *
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class ErrorStateRegistry {

	private static final BiMap<Short, IErrorState> states = HashBiMap.create();

	public static void registerErrorState(IErrorState state) {
		states.put(state.getID(), state);
	}

	public static short getErrorStateCode(IErrorState state) {
		return states.inverse().get(state);
	}
	
	public static IErrorState getErrorStateFromCode(short id) {
		return states.get(id);
	}

	@SideOnly(Side.CLIENT)
	public static void initIcons(IIconRegister register) {
		for (IErrorState code : states.values()) {
			code.registerIcons(register);
		}
	}
}
