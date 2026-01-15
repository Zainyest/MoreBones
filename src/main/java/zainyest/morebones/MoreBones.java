package zainyest.morebones;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zainyest.morebones.init.Items;

public class MoreBones implements ModInitializer {
	public static final String MOD_ID = "morebones";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		initRegistries();
	}

	private void initRegistries() {

		//Vanilla
		Items.init();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
