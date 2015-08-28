/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.core.sprite;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class Sprite implements ISprite {

	public Sprite(TextureAtlasSprite sprite) {
		this.sprite = sprite;
	}
	
	public TextureAtlasSprite sprite;
	
	@Override
	public int getSpriteWidth() {
		return 0;
	}

	@Override
	public int getSpriteHeight() {
		return 0;
	}

	@Override
	public float getMinV() {
		return 0;
	}

	@Override
	public float getMinU() {
		return 0;
	}

	@Override
	public float getMaxU() {
		return 0;
	}

	@Override
	public float getMaxV() {
		return 0;
	}

	@Override
	public float getInterpolatedU(double px) {
		return 0;
	}

	@Override
	public float getInterpolatedV(double px) {
		return 0;
	}

	@Override
	public String getSpriteName() {
		return null;
	}

	@Override
	public TextureAtlasSprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

}
