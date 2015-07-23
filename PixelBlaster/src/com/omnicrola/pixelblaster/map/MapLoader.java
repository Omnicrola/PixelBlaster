package com.omnicrola.pixelblaster.map;

import java.io.File;

import org.newdawn.slick.Image;

import com.omnicrola.pixelblaster.graphics.GameBackground;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.util.AssetManager;

public class MapLoader {
	private final AssetManager assetManager;
	private final MapTileLoader mapTileLoader;

	public MapLoader(AssetManager assetManager, MapTileLoader mapTileLoader) {
		this.assetManager = assetManager;
		this.mapTileLoader = mapTileLoader;
	}

	public ILevelMap load(int currentLevel) {
		final XmlMapData mapData = this.assetManager.getMapData(currentLevel);
		final MapTileDataSet tileData = this.mapTileLoader.loadData(mapData);
		final GameBackground background = createBackground(mapData);
		return new LevelMap(GameSettings.MAP_TILE_SIZE_IN_METERS, tileData, background, mapData);
	}

	private GameBackground createBackground(XmlMapData mapData) {
		final String background = "Backgrounds" + File.separator + mapData.background;
		final Image image = this.assetManager.getImage(background);
		return new GameBackground(image);
	}

}
