package com.omnicrola.pixelblaster.map.io;

import java.util.HashMap;

import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.map.EntityFactory;
import com.omnicrola.pixelblaster.map.MapLoader;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.util.AssetManager;

public class MapTemplateReader {

	private final PowerupFactory powerupFactory;
	private final AssetManager assetManager;
	private final IPhysicsManager physicsManager;
	private final EntityFactory entityFactory;

	public MapTemplateReader(AssetManager assetManager, IPhysicsManager physicsManager, PowerupFactory powerupFactory,
			EntityFactory entityFactory) {
		this.assetManager = assetManager;
		this.physicsManager = physicsManager;
		this.powerupFactory = powerupFactory;
		this.entityFactory = entityFactory;
	}

	public MapLoader loadTemplates() {

		final HashMap<Integer, LevelMapTemplate> templates = getTemplatesFromFiles();
		return new MapLoader(templates);
	}

	private HashMap<Integer, LevelMapTemplate> getTemplatesFromFiles() {
		final float tileSize = GameSettings.MAP_TILE_SIZE_IN_METERS;
		final MapTileLoader mapTileLoader = new MapTileLoader(this.assetManager);
		final HashMap<Integer, LevelMapTemplate> templates = new HashMap<>();
		final int levelNumber = 1;
		final LevelMapTemplate mapTemplate = loadTemplate(tileSize, mapTileLoader, levelNumber);
		templates.put(levelNumber, mapTemplate);
		return templates;
	}

	private LevelMapTemplate loadTemplate(final float tileSize, MapTileLoader mapTileLoader, final int currentLevel) {
		final XmlMapData mapData = this.assetManager.getMapData(currentLevel);
		final LevelMapTemplate mapTemplate = new LevelMapTemplate(tileSize, mapTileLoader, mapData, this.powerupFactory,
				this.entityFactory, this.physicsManager, this.assetManager);
		return mapTemplate;
	}

}
