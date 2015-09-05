/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 * 
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.arboriculture;

import java.util.HashMap;

import forestry.arboriculture.genetics.ITreeDefinition;

public class TreeModels {
	/**
	 * Can be used to add models to the spling
	 */
	public static HashMap<String, Class<? extends ITreeDefinition>> definition = new HashMap<String, Class<? extends ITreeDefinition>>();

}