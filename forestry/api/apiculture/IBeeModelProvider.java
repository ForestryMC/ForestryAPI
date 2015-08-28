/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.apiculture;

import forestry.api.core.IModelManager;
import forestry.api.core.ITextureManager;
import forestry.api.core.sprite.ISprite;
import net.minecraft.client.resources.model.ModelResourceLocation;

public interface IBeeModelProvider {
	void registerModels(IModelManager manager);
	ModelResourceLocation getModel(EnumBeeType type);
}
