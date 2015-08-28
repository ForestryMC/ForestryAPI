/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.arboriculture;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mojang.authlib.GameProfile;

import forestry.api.world.ITreeGenData;

/**
 * Implements the tree generation for a tree species.
 */
public interface ITreeGenerator {
	WorldGenerator getWorldGenerator(ITreeGenData tree);
	void setLogBlock(World world, BlockPos pos, EnumFacing facing);
	void setLeaves(World world, GameProfile owner, BlockPos pos, boolean decorative);
}
