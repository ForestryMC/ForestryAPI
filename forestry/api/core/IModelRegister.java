package forestry.api.core;

import net.minecraft.item.Item;

public interface IModelRegister {

	void registerModel(Item item, IModelManager manager);
	
}
