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
		return sprite.getIconWidth();
	}

	@Override
	public int getSpriteHeight() {
		return sprite.getIconHeight();
	}

	@Override
	public float getMinV() {
		return sprite.getMinV();
	}

	@Override
	public float getMinU() {
		return sprite.getMinU();
	}

	@Override
	public float getMaxU() {
		return sprite.getMaxU();
	}

	@Override
	public float getMaxV() {
		return sprite.getMaxV();
	}

	@Override
	public float getInterpolatedU(double px) {
		return sprite.getInterpolatedU(px);
	}

	@Override
	public float getInterpolatedV(double px) {
		return sprite.getInterpolatedV(px);
	}

	@Override
	public String getSpriteName() {
		return sprite.getIconName();
	}

	@Override
	public TextureAtlasSprite getSprite() {
		return sprite;
	}

}
