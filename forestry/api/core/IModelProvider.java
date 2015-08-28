/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 * 
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.core;

import forestry.api.apiculture.EnumBeeType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Provides modles, needed in some interfaces, most notably for bees and trees. 
 */
public interface IModelProvider {
	
	@SideOnly(Side.CLIENT)
	ModelResourceLocation getModel();
	
	@SideOnly(Side.CLIENT)
	void registerModels(IModelManager manager);

}
