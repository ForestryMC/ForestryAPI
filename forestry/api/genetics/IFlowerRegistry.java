/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 * 
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.genetics;

import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IFlowerRegistry {
	
	ItemStack[] getAcceptableFlowers(String flowerType);
	
	boolean growFlower(String flowerType, World world, IIndividual individual, int x, int y, int z);
	
	boolean isAcceptedFlower(String flowerType, World world, IIndividual individual, int x, int y, int z);
	
	/**
	 * Registers a non-plantable flower, but bees accept them.
	 *
	 * @param flowerTypes See {@link forestry.api.apiculture.FlowerManager}.FlowerTypeXXX
	 */
	void registerAcceptableFlower(ItemStack flower, String... flowerTypes);
	
	void registerGrowthRule(IFlowerGrowthRule rule, String... flowerTypes);
	
	/**
	 * Registers a plantable flower.
	 * The distribution is based on its own weight and the total number of plants for this flowerType.
	 * 
	 * @param weight Weight for the Flower (Vanilla = 1.0, Modded flowers < 1.0)
	 * @param flowerTypes See {@link forestry.api.apiculture.FlowerManager}.FlowerTypeXXX
	 */
	void registerPlantableFlower(ItemStack flower, double weight, String... flowerTypes);

	ItemStack getRandomPlantableFlower(String flowerType, Random rand);

}
