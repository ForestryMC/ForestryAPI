/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.farming;

import net.minecraft.util.EnumFacing;

public enum FarmDirection {
	NORTH(EnumFacing.NORTH),
	EAST(EnumFacing.EAST),
	SOUTH(EnumFacing.SOUTH),
	WEST(EnumFacing.WEST);

	private final EnumFacing direction;

	FarmDirection(EnumFacing direction) {
		this.direction = direction;
	}

	public EnumFacing getDirection() {
		return direction;
	}

	public static FarmDirection getFarmDirection(EnumFacing direction) {
		switch (direction) {
			case NORTH: return NORTH;
			case EAST: return EAST;
			case SOUTH: return SOUTH;
			case WEST: return WEST;
		}
		return null;
	}
}
