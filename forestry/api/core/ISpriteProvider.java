/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 * 
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.core;

import forestry.api.core.sprite.ISprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Provides icons, needed in some interfaces, most notably for bees and trees. 
 */
public interface ISpriteProvider {
	
	@SideOnly(Side.CLIENT)
	ISprite getIcon(short texUID);
	
	@SideOnly(Side.CLIENT)
	void registerIcons(ITextureManager register);

}
