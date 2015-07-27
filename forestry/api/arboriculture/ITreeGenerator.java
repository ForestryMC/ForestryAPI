/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.arboriculture;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mojang.authlib.GameProfile;

import net.minecraftforge.common.util.ForgeDirection;

import forestry.api.world.ITreeGenData;

/**
 * Implements the tree generation for a tree species.
 */
public interface ITreeGenerator {
	WorldGenerator getWorldGenerator(ITreeGenData tree);
	void setLogBlock(World world, int x, int y, int z, ForgeDirection facing);
	void setLeaves(World world, GameProfile owner, int x, int y, int z, boolean decorative);
}
