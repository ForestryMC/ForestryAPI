/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.genetics;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IFlowerProvider {

	/**
	 * @return Unique identifier for this type of flower.
	 */
	String getFlowerType();

	/**
	 * @return Short, human-readable identifier used in the beealyzer.
	 */
	String getDescription();

	/**
	 * @return true if the pollinatable can be pollinated by bees of this FlowerProvider type
	 */
	boolean isAcceptedPollinatable(World world, IPollinatable pollinatable);

	/**
	 * Allows the flower provider to affect the bee produce at the given location.
	 *
	 * @return Array of itemstacks being the (modified or unmodified) produce.
	 */
	ItemStack[] affectProducts(World world, IIndividual individual, int x, int y, int z, ItemStack[] products);

	/**
	 * @deprecated since Forestry 3.6. Use FlowerManager.flowerRegistry.isAcceptedFlower() instead
	 * @return True if the block at the passed coordinates is a valid flower for the species.
	 */
	@Deprecated
	boolean isAcceptedFlower(World world, IIndividual individual, int x, int y, int z);

	/**
	 * @deprecated since Forestry 3.6. Use FlowerManager.flowerRegistry.growFlower() instead
	 * @return True if a flower was planted.
	 */
	@Deprecated
	boolean growFlower(World world, IIndividual individual, int x, int y, int z);

	/**
	 * @deprecated since Forestry 3.6. Use FlowerManager.flowerRegistry.getAcceptableFlowers() instead
	 * @return List of valid flowers for the flower provider. The first in the array is for use as an icon.
	 *  Returns an empty list if the flower provider does not have any valid flowers.
	 */
	@Deprecated
	List<IFlower> getFlowers();
}
