/**
 * 
 */
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