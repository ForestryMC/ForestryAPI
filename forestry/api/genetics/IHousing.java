/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 * 
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.genetics;

import forestry.api.core.EnumErrorCode;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.mojang.authlib.GameProfile;

import forestry.api.core.EnumHumidity;
import forestry.api.core.EnumTemperature;

/**
 * Any housing, hatchery or nest which is a fixed location in the world.
 */
public interface IHousing {

	/**
	 * @return String containing the login of this housing's owner.
	 */
	GameProfile getOwnerName();

	World getWorld();

	int getXCoord();

	int getYCoord();

	int getZCoord();

	int getBiomeId();

	EnumTemperature getTemperature();

	EnumHumidity getHumidity();

	@Deprecated // Deprecated since Forestry 3.2.0. Use EnumErrorCode version instead.
	void setErrorState(int state);
	void setErrorState(EnumErrorCode state);

	@Deprecated // Deprecated since Forestry 3.2.0. Use getErrorState instead.
	int getErrorOrdinal();
	EnumErrorCode getErrorState();

	/**
	 * Adds products to the housing's inventory.
	 * 
	 * @param product
	 *            ItemStack with the product to add.
	 * @param all
	 * @return Boolean indicating success or failure.
	 */
	boolean addProduct(ItemStack product, boolean all);

}
