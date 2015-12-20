/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 * 
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.arboriculture;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import forestry.api.core.IModelManager;
import forestry.api.genetics.IFruitFamily;

public interface IFruitProvider {

	IFruitFamily getFamily();

	int getColour(ITreeGenome genome, IBlockAccess world, BlockPos pos, int ripeningTime);

	boolean markAsFruitLeaf(ITreeGenome genome, World world, BlockPos pos);

	int getRipeningPeriod();

	// / Products, Chance
	ItemStack[] getProducts();

	// / Specialty, Chance
	ItemStack[] getSpecialty();

	ItemStack[] getFruits(ITreeGenome genome, World world, BlockPos pos, int ripeningTime);

	/**
	 * @return Short, human-readable identifier used in the treealyzer.
	 */
	String getDescription();

	/* TEXTURE OVERLAY */
	/**
	 * @param genome
	 * @param world
	 * @param x
	 * @param y
	 * @param pos
	 * @param ripeningTime
	 *            Elapsed ripening time for the fruit.
	 * @param fancy
	 * @return IIcon index of the texture to overlay on the leaf block.
	 */
	short getIconIndex(ITreeGenome genome, IBlockAccess world, BlockPos pos, int ripeningTime, boolean fancy);

	/**
	 * @return true if this fruit provider requires fruit blocks to spawn, false otherwise.
	 */
	boolean requiresFruitBlocks();

	/**
	 * Tries to spawn a fruit block at the potential position when the tree generates.
	 * 
	 * @param genome
	 * @param world
	 * @param pos
	 * @return true if a fruit block was spawned, false otherwise.
	 */
	boolean trySpawnFruitBlock(ITreeGenome genome, World world, BlockPos pos);

	@SideOnly(Side.CLIENT)
	void registerModels(Item item, IModelManager manager);
}
