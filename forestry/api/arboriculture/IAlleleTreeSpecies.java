/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 * 
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.arboriculture;

import java.util.Collection;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import forestry.api.genetics.IAlleleSpecies;
import forestry.api.genetics.IFruitFamily;

public interface IAlleleTreeSpecies extends IAlleleSpecies {

	ITreeRoot getRoot();
	
	/**
	 * @return Native plant type of this species.
	 */
	EnumPlantType getPlantType();

	/**
	 * @return List of all {@link IFruitFamily}s which can grow on leaves generated by this species.
	 */
	Collection<IFruitFamily> getSuitableFruit();

	/**
	 * @return Tree generator for this species.
	 */
	ITreeGenerator getGenerator();

	/* TEXTURES AND OVERRIDES */
	int getLeafColour(boolean pollinated);

	@SideOnly(Side.CLIENT)
	TextureAtlasSprite getLeafIcon(boolean pollinated, boolean fancy);

	@SideOnly(Side.CLIENT)
	TextureAtlasSprite getGermlingIcon(EnumGermlingType type, int renderPass);
	
	@SideOnly(Side.CLIENT)
	int getGermlingColour(EnumGermlingType type, int renderPass);

}
