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
		final Random random = new Random(149);
		final short[][] data = new short[64][12];
		for (int x = 0; x < data.length; x++) {
			data[x][5] = 17;
			data[x][4] = (short) (random.nextInt(18));
		}
		return data;
	}

	private IMapTile[] createTiles() {
		final String base = "Ground/Planet/planet";
		final IMapTile[] mapTiles = new IMapTile[19];
		mapTiles[0] = MapTile.AIR;
		mapTiles[1] = new MapTile(this.assetManager.getImage(base + ".png"));
		mapTiles[2] = new MapTile(this.assetManager.getImage(base + "Center.png"));
		mapTiles[3] = new MapTile(this.assetManager.getImage(base + "Center_rounded.png"));
		mapTiles[4] = new MapTile(this.assetManager.getImage(base + "Cliff_left.png"));
		mapTiles[5] = new MapTile(this.assetManager.getImage(base + "Cliff_right.png"));
		mapTiles[6] = new MapTile(this.assetManager.getImage(base + "CliffAlt_left.png"));
		mapTiles[7] = new MapTile(this.assetManager.getImage(base + "CliffAlt_right.png"));
		mapTiles[8] = new MapTile(this.assetManager.getImage(base + "Corner_left.png"));
		mapTiles[9] = new MapTile(this.assetManager.getImage(base + "Corner_right.png"));
		mapTiles[10] = new MapTile(this.assetManager.getImage(base + "Half.png"));
		mapTiles[11] = new MapTile(this.assetManager.getImage(base + "Half_left.png"));
		mapTiles[12] = new MapTile(this.assetManager.getImage(base + "Half_mid.png"));
		mapTiles[13] = new MapTile(this.assetManager.getImage(base + "Half_right.png"));
		mapTiles[14] = new MapTile(this.assetManager.getImage(base + "Hill_left.png"));
		mapTiles[15] = new MapTile(this.assetManager.getImage(base + "Hill_right.png"));
		mapTiles[16] = new MapTile(this.assetManager.getImage(base + "Left.png"));
		mapTiles[17] = new MapTile(this.assetManager.getImage(base + "Mid.png"));
		mapTiles[18] = new MapTile(this.assetManager.getImage(base + "Right.png"));
		return mapTiles;
	}
}
