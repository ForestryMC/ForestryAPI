/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.apiculture;

import forestry.api.core.ITextureManager;
import forestry.api.core.sprite.ISprite;
public interface IBeeIconProvider {
	void registerIcons(ITextureManager register);
	ISprite getIcon(EnumBeeType type, int renderPass);
}
