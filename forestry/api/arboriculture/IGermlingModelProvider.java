/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.arboriculture;

import forestry.api.core.IModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;

public interface IGermlingModelProvider {
	void registerModels(IModelManager manager);
	ModelResourceLocation getModel(EnumGermlingType type);
}
