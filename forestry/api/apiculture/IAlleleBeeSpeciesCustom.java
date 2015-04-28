/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.apiculture;

import net.minecraft.item.ItemStack;

import forestry.api.genetics.IAlleleSpeciesCustom;

public interface IAlleleBeeSpeciesCustom extends IAlleleBeeSpecies, IAlleleSpeciesCustom {

	IAlleleBeeSpeciesCustom addProduct(ItemStack product, int chance);

	IAlleleBeeSpeciesCustom addSpecialty(ItemStack specialty, int chance);

	IAlleleBeeSpeciesCustom setJubilanceProvider(IJubilanceProvider provider);

	/** Use this if you have custom icons for bees. */
	IAlleleBeeSpeciesCustom setCustomBeeIconProvider(IBeeIconProvider beeIconProvider);
}
