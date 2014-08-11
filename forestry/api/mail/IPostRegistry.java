/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 * 
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.mail;

import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.mojang.authlib.GameProfile;

public interface IPostRegistry {

	/* POST OFFICE */
	IPostOffice getPostOffice(World world);

	/* LETTERS */
	boolean isLetter(ItemStack itemstack);

	ILetter createLetter(MailAddress sender, MailAddress recipient);

	ILetter getLetter(ItemStack itemstack);

	ItemStack createLetterStack(ILetter letter);

	/* CARRIERS */
	/**
	 * Registers a new {@link IPostalCarrier}. See {@link IPostalCarrier} for details.
	 * @param carrier {@link IPostalCarrier} to register.
	 */
	void registerCarrier(IPostalCarrier carrier);

	IPostalCarrier getCarrier(String uid);

	Map<String, IPostalCarrier> getRegisteredCarriers();

	/* TRADE STATIONS */
	void deleteTradeStation(World world, MailAddress address);

	ITradeStation getOrCreateTradeStation(World world, GameProfile owner, MailAddress address);

	ITradeStation getTradeStation(World world, MailAddress address);

	boolean isAvailableTradeAddress(World world, MailAddress address);

	boolean isValidTradeAddress(World world, MailAddress address);

	/* PO BOXES */
	boolean isValidPOBox(World world, MailAddress address);

}
