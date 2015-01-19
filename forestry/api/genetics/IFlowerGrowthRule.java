/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 * 
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.genetics;

import net.minecraft.world.World;

/**
 * Basic condition for flower growing
 * e.g. {@link forestry.apiculture.VanillaDirtGrassGrowthRule}
 * 
 * @author samtrion
 */
public interface IFlowerGrowthRule {	
	boolean growFlower(IFlowerRegistry fr, String flowerType, World world, IIndividual individual, int x, int y, int z);
}
