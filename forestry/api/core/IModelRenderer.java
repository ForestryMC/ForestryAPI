/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 * 
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.core;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public interface IModelRenderer {

	void setRenderBoundsFromBlock(Block block);

	void setRenderBounds(double d, double e, double f, double g, double h, double i );
	
	void setBrightness(int i);

	void setColorRGBA_F(int r, int g, int b, float a );

	void setColorOpaque_I(int whiteVariant);
	
	void setColorOpaque(int r, int g, int b);
	
	void setColorOpaque_F(int r, int g, int b);

	void setColorOpaque_F(float rf, float bf, float gf );
	
	void addVertexWithUV(EnumFacing face, double x, double y, double z, double u, double v );

	boolean renderStandardBlock(Block block, BlockPos pos, TextureAtlasSprite[] sprites);
	
	boolean renderStandardBlock(Block block, BlockPos pos, TextureAtlasSprite sprites);

	void setTranslation(int x, int y, int z );

	boolean isAlphaPass();
	
	void renderFaceXNeg(BlockPos pos, TextureAtlasSprite sprite);
	
	void renderFaceYNeg(BlockPos pos, TextureAtlasSprite sprite);

	void renderFaceZNeg(BlockPos pos, TextureAtlasSprite sprite);

    void renderFaceYPos(BlockPos pos, TextureAtlasSprite sprite);

	void renderFaceZPos(BlockPos pos, TextureAtlasSprite sprite);

	void renderFaceXPos(BlockPos pos, TextureAtlasSprite sprite);

	IBakedModel finalizeModel(boolean flip);
	
	double getRenderMinX();
	
	double getRenderMinY();
	
	double getRenderMinZ();
	
	double getRenderMaxX();
	
	double getRenderMaxY();
	
	double getRenderMaxZ();
	
}
