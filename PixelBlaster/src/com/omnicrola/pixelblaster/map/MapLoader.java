package com.omnicrola.pixelblaster.map;

import java.util.Random;

import com.omnicrola.pixelblaster.util.AssetManager;

public class MapLoader {
	private final AssetManager assetManager;

	public MapLoader(AssetManager assetManager) {
		this.assetManager = assetManager;
	}

	public ILevelMap load(int currentLevel) {
		final short[][] tileData = createTileData();
		final IMapTile[] mapTiles = createTiles();
		return new LevelMap(128, mapTiles, tileData);
	}

	private short[][] createTileData() {
		final Random random = new Random(159);
		final short[][] data = new short[64][12];
		for (int x = 0; x < data.length; x++) {
			data[x][5] = 1;
			data[x][4] = (short) ((random.nextFloat() < 0.5) ? 0 : 1);
		}
		data[10][3] = 1;
		data[10][2] = 1;
		return data;
	}

	private IMapTile[] createTiles() {
		final IMapTile[] mapTiles = new IMapTile[2];
		mapTiles[0] = MapTile.AIR;
		mapTiles[1] = new MapTile(this.assetManager.getImage("map/planet.png"));
		return mapTiles;
	}
}
