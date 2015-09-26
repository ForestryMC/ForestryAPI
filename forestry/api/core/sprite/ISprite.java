/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.core.sprite;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public interface ISprite
{

	int getSpriteWidth();

	int getSpriteHeight();

	float getMinV();
	
	float getMinU();
	
	float getMaxU();

	float getMaxV();
	
	float getInterpolatedU(double px );

	float getInterpolatedV(double px );
	
	String getSpriteName();

	TextureAtlasSprite getSprite();
}

