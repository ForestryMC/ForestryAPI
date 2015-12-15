/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.apiculture;

import forestry.api.core.IModelManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.Item;

public interface IBeeModelProvider {
	void registerModules(Item item, IModelManager manager);
	TextureAtlasSprite getModel(EnumBeeType type);
}
